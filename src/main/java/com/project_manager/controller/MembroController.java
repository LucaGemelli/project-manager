package com.project_manager.controller;

import com.project_manager.model.Membro;
import com.project_manager.service.MembroService;
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
@RequestMapping("/membros")
public class MembroController {

    @Autowired
    private MembroService membrosService;

    @GetMapping
    public String listMembros(Model model) {
        List<Membro> membros = membrosService.findAll();
        model.addAttribute("membros", membros);
        return "membros/list";
    }

    @GetMapping("/novo")
    public String novoMembro(Model model) {
        model.addAttribute("membro", new Membro());
        return "membros/form";
    }

    @PostMapping
    public String saveMembro(Membro membro) {
        membrosService.save(membro);
        return "redirect:/membros";
    }

    @GetMapping("/editar/{id}")
    public String editarMembro(@PathVariable Long id, Model model) {
        Optional<Membro> membro = membrosService.findById(id);
        if (membro.isPresent()) {
            model.addAttribute("membro", membro.get());
            return "membros/form";
        } else {
            return "redirect:/membros";
        }
    }

    @GetMapping("/excluir/{id}")
    public String excluirMembro(@PathVariable Long id) {
        membrosService.delete(id);
        return "redirect:/membros";
    }
}
