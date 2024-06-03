package com.project_manager.controller;

import com.project_manager.model.Projeto;
import com.project_manager.service.ProjetoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/projetos")
public class ProjetoController {

    @Autowired
    private ProjetoService projetoService;

    @GetMapping
    public String listProjetos(Model model) {
        List<Projeto> projetos = projetoService.findAll();
        model.addAttribute("projetos", projetos);
        return "projetos/list";
    }

    @GetMapping("/novo")
    public String novoProjeto(Model model) {
        model.addAttribute("projeto", new Projeto());
        return "projetos/novoProjeto";
    }

    @PostMapping
    public String saveProjeto(Projeto projeto) {
        projetoService.save(projeto);
        return "redirect:/projetos";
    }

    @GetMapping("/editar/{id}")
    public String editarProjeto(@PathVariable Long id, Model model) {
        Optional<Projeto> projeto = projetoService.findById(id);
        if (projeto.isPresent()) {
            model.addAttribute("projeto", projeto.get());
            return "projetos/form";
        } else {
            return "redirect:/projetos";
        }
    }

    @GetMapping("/excluir/{id}")
    public String excluirProjeto(@PathVariable Long id) {
        projetoService.delete(id);
        return "redirect:/projetos";
    }
}
