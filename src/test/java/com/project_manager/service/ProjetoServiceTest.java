package com.project_manager.service;

import com.project_manager.model.Pessoa;
import com.project_manager.model.Projeto;
import com.project_manager.repository.ProjetoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class ProjetoServiceTest {

    @Mock
    private ProjetoRepository projetoRepository;

    @InjectMocks
    private ProjetoService projetoService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testListarProjetos() {
        List<Projeto> projetos = new ArrayList<>();
        LocalDate dataInicio = LocalDate.of(2023, 1, 1);
        LocalDate dataPrevisaoFim = LocalDate.of(2023, 6, 30);
        projetos.add(new Projeto(1L, "Projeto A", dataInicio, dataPrevisaoFim, null, "Descrição Projeto A", "Em Análise", 10000.0F, "Baixo Risco", new Pessoa()));
        projetos.add(new Projeto(2L, "Projeto B", dataInicio, dataPrevisaoFim, null, "Descrição Projeto B", "Iniciado", 15000.0F, "Médio Risco", new Pessoa()));
        when(projetoRepository.findAll()).thenReturn(projetos);
        List<Projeto> resultado = projetoService.findAll();
        assertEquals(2, resultado.size());
        assertEquals("Projeto A", resultado.get(0).getNome());
        assertEquals("Projeto B", resultado.get(1).getNome());
    }

    @Test
    public void testBuscarProjetoPorId() {
        Long projetoId = 1L;
        LocalDate dataInicio = LocalDate.of(2023, 1, 1);
        LocalDate dataPrevisaoFim = LocalDate.of(2023, 6, 30);
        Projeto projeto = new Projeto(projetoId, "Projeto A", dataInicio, dataPrevisaoFim, null, "Descrição Projeto A", "Em Análise", 10000.0F, "Baixo Risco", new Pessoa());
        when(projetoRepository.findById(projetoId)).thenReturn(Optional.of(projeto));
        Optional<Projeto> resultado = projetoService.findById(projetoId);
        assertEquals("Projeto A", resultado.orElseThrow().getNome());
    }
}
