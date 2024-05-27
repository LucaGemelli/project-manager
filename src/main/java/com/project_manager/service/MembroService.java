package com.project_manager.service;

import com.project_manager.model.Membro;
import com.project_manager.model.Pessoa;
import com.project_manager.model.Projeto;
import com.project_manager.repository.MembroRepository;
import com.project_manager.repository.PessoaRepository;
import com.project_manager.repository.ProjetoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class MembroService {

    @Autowired
    private MembroRepository membrosRepository;

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private ProjetoRepository projetoRepository;

    public List<Membro> findAll() {
        return membrosRepository.findAll();
    }

    public Optional<Membro> findById(Long id) {
        return membrosRepository.findById(id);
    }

    @Transactional
    public Membro save(Membro membro) {
        return membrosRepository.save(membro);
    }

    @Transactional
    public void delete(Long id) {
        membrosRepository.deleteById(id);
    }

    @Transactional
    public Membro addMembroToProjeto(Long idProjeto, Long idPessoa) {
        Optional<Projeto> projetoOpt = projetoRepository.findById(idProjeto);
        Optional<Pessoa> pessoaOpt = pessoaRepository.findById(idPessoa);

        if (projetoOpt.isPresent() && pessoaOpt.isPresent()) {
            Projeto projeto = projetoOpt.get();
            Pessoa pessoa = pessoaOpt.get();

            if (pessoa.getFuncionario()) {
                Membro membro = new Membro();
                membro.setProjeto(projeto);
                membro.setPessoa(pessoa);
                return membrosRepository.save(membro);
            } else {
                throw new IllegalArgumentException("A pessoa não é um funcionário.");
            }
        } else {
            throw new IllegalArgumentException("Projeto ou Pessoa não encontrados.");
        }
    }
}
