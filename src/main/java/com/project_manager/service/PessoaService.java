package com.project_manager.service;

import com.project_manager.model.Pessoa;
import com.project_manager.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public List<Pessoa> findAll() {
        return pessoaRepository.findAll();
    }

    public Optional<Pessoa> findById(Long id) {
        return pessoaRepository.findById(id);
    }

    @Transactional
    public Pessoa save(Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }

    @Transactional
    public void delete(Long id) {
        pessoaRepository.deleteById(id);
    }

    @Transactional
    public Pessoa update(Pessoa pessoa) {
        if (pessoaRepository.existsById(pessoa.getId())) {
            return pessoaRepository.save(pessoa);
        } else {
            throw new IllegalArgumentException("Pessoa não encontrada.");
        }
    }
}
