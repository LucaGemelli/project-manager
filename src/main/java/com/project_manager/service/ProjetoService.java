package com.project_manager.service;

import com.project_manager.model.Projeto;
import com.project_manager.model.enumeration.StatusProjeto;
import com.project_manager.repository.ProjetoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProjetoService {

    @Autowired
    private ProjetoRepository projetoRepository;

    public List<Projeto> findAll() {
        return projetoRepository.findAll();
    }

    public Optional<Projeto> findById(Long id) {
        return projetoRepository.findById(id);
    }

    @Transactional
    public Projeto save(Projeto projeto) {
        return projetoRepository.save(projeto);
    }

    @Transactional
    public void delete(Long id) {
        Optional<Projeto> projetoOpt = projetoRepository.findById(id);
        if (projetoOpt.isPresent()) {
            Projeto projeto = projetoOpt.get();
            if (projeto.getStatus() != StatusProjeto.INICIADO &&
                    projeto.getStatus() != StatusProjeto.EM_ANDAMENTO &&
                    projeto.getStatus() != StatusProjeto.ENCERRADO) {
                projetoRepository.deleteById(id);
            } else {
                throw new IllegalArgumentException("Projeto não pode ser excluído nos status: iniciado, em andamento ou encerrado.");
            }
        } else {
            throw new IllegalArgumentException("Projeto não encontrado.");
        }
    }

    @Transactional
    public Projeto update(Projeto projeto) {
        if (projetoRepository.existsById(projeto.getId())) {
            return projetoRepository.save(projeto);
        } else {
            throw new IllegalArgumentException("Projeto não encontrado.");
        }
    }
}
