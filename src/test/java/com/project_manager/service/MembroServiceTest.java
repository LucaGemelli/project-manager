package com.project_manager.service;

import com.project_manager.model.Membro;
import com.project_manager.model.Pessoa;
import com.project_manager.model.Projeto;
import com.project_manager.repository.MembroRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class MembroServiceTest {

    @Mock
    private MembroRepository membroRepository;

    @InjectMocks
    private MembroService membroService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testListarMembros() {
        List<Membro> membros = new ArrayList<>();
        membros.add(new Membro(1L, mockProjeto(), mockPessoa()));
        membros.add(new Membro(1L, mockProjeto(), mockPessoa()));
        when(membroRepository.findAll()).thenReturn(membros);
        List<Membro> membrosEncontrados = membroService.findAll();
        assertFalse(membrosEncontrados.isEmpty());
        assertEquals(2, membrosEncontrados.size());
        assertEquals(1L, membrosEncontrados.get(0).getProjeto().getId());
        assertEquals(1L, membrosEncontrados.get(0).getProjeto().getId());
    }

    @Test
    public void testBuscarMembroPorIdExistente() {
        Membro membroExistente = new Membro(1L, mockProjeto(), mockPessoa());
        when(membroRepository.findById(anyLong())).thenReturn(Optional.of(membroExistente));
        Optional<Membro> membroOptional = membroService.findById(1L);
        assertTrue(membroOptional.isPresent());
        assertEquals(membroExistente.getId(), membroOptional.get().getId());
        assertEquals(membroExistente.getProjeto().getId(), membroOptional.get().getProjeto().getId());
    }

    @Test
    public void testBuscarMembroPorIdNaoExistente() {
        when(membroRepository.findById(anyLong())).thenReturn(Optional.empty());
        Optional<Membro> membroOptional = membroService.findById(1L);
        assertFalse(membroOptional.isPresent());
    }

    @Test
    public void testSalvarMembro() {
        Membro membroNovo = new Membro(1L, mockProjeto(), mockPessoa());
        when(membroRepository.save(any(Membro.class))).thenReturn(membroNovo);
        Membro membroSalvo = membroService.save(membroNovo);
        assertNotNull(membroSalvo);
        assertEquals(membroNovo.getId(), membroSalvo.getId());
        assertEquals(membroNovo.getProjeto().getId(), membroSalvo.getProjeto().getId());
    }

    @Test
    public void testExcluirMembroExistente() {
        Long membroId = 1L;
        when(membroRepository.existsById(membroId)).thenReturn(true);
        doNothing().when(membroRepository).deleteById(membroId);
        membroService.delete(membroId);
        verify(membroRepository, times(1)).deleteById(membroId);
    }

    @Test
    public void testExcluirMembroNaoExistente() {
        doThrow(IllegalArgumentException.class).when(membroRepository).deleteById(anyLong());
        assertThrows(IllegalArgumentException.class, () -> membroService.delete(1L));
        verify(membroRepository, never()).deleteById(1L);
    }

    @Test
    public void testAtualizarMembroExistente() {
        Membro membroExistente = new Membro(1L, mockProjeto(), mockPessoa());
        when(membroRepository.existsById(anyLong())).thenReturn(true);
        when(membroRepository.save(any(Membro.class))).thenReturn(membroExistente);
        Membro membroAtualizado = membroService.update(membroExistente);
        assertNotNull(membroAtualizado);
        assertEquals(membroExistente.getId(), membroAtualizado.getId());
        assertEquals(membroExistente.getProjeto().getId(), membroAtualizado.getProjeto().getId());
    }

    @Test
    public void testAtualizarMembroNaoExistente() {
        Membro membroNaoExistente = new Membro(1L, mockProjeto(), mockPessoa());
        when(membroRepository.existsById(anyLong())).thenReturn(false);
        assertThrows(IllegalArgumentException.class, () -> membroService.update(membroNaoExistente));
        verify(membroRepository, never()).save(any(Membro.class));
    }

    private Projeto mockProjeto() {
        return new Projeto(1L, "Projeto A", LocalDate.of(2023, 6, 30), LocalDate.of(2023, 6, 30), null, "Descrição Projeto A", "Em Análise", 10000.0F, "Baixo Risco", new Pessoa());
    }

    private Pessoa mockPessoa() {
        return new Pessoa();
    }
}
