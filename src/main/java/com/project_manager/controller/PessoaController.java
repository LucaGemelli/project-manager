package com.project_manager.controller;

import com.project_manager.model.Pessoa;
import com.project_manager.service.PessoaService;
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
@RequestMapping("/pessoas")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @GetMapping
    public String listPessoas(Model model) {
        List<Pessoa> pessoas = pessoaService.findAll();
        model.addAttribute("pessoas", pessoas);
        return "pessoas/list";
    }

    @GetMapping("/novo")
    public String novaPessoa(Model model) {
        model.addAttribute("pessoa", new Pessoa());
        return "pessoas/form";
    }

    @PostMapping
    public String savePessoa(Pessoa pessoa) {
        pessoaService.save(pessoa);
        return "redirect:/pessoas";
    }

    @GetMapping("/editar/{id}")
    public String editarPessoa(@PathVariable Long id, Model model) {
        Optional<Pessoa> pessoa = pessoaService.findById(id);
        if (pessoa.isPresent()) {
            model.addAttribute("pessoa", pessoa.get());
            return "pessoas/form";
        } else {
            return "redirect:/pessoas";
        }
    }

    @GetMapping("/excluir/{id}")
    public String excluirPessoa(@PathVariable Long id) {
        pessoaService.delete(id);
        return "redirect:/pessoas";
    }
}
