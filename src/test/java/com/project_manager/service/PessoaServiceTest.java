package com.project_manager.service;

import com.project_manager.model.Pessoa;
import com.project_manager.repository.PessoaRepository;
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

public class PessoaServiceTest {

    @Mock
    private PessoaRepository pessoaRepository;

    @InjectMocks
    private PessoaService pessoaService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testListarPessoas() {
        List<Pessoa> pessoas = new ArrayList<>();
        LocalDate dataNascimento = LocalDate.of(1990, 1, 1);
        LocalDate dataNascimento2 = LocalDate.of(1995, 6, 15);
        pessoas.add(new Pessoa(1L, "João", dataNascimento, "123.456.789-00", true, false));
        pessoas.add(new Pessoa(2L, "Maria", dataNascimento2, "987.654.321-00", false, true));
        when(pessoaRepository.findAll()).thenReturn(pessoas);
        List<Pessoa> resultado = pessoaService.findAll();
        assertEquals(2, resultado.size());
        assertEquals("João", resultado.get(0).getNome());
        assertEquals("Maria", resultado.get(1).getNome());
    }

    @Test
    public void testBuscarPessoaPorIdExistente() {
        Long pessoaId = 1L;
        LocalDate dataNascimento = LocalDate.of(1990, 1, 1);
        Pessoa pessoa = new Pessoa(pessoaId, "João", dataNascimento, "123.456.789-00", true, false);
        when(pessoaRepository.findById(pessoaId)).thenReturn(Optional.of(pessoa));
        Optional<Pessoa> resultado = pessoaService.findById(pessoaId);
        assertTrue(resultado.isPresent());
        assertEquals("João", resultado.orElseThrow().getNome());
    }

    @Test
    public void testBuscarPessoaPorIdNaoExistente() {
        Long pessoaId = 100L;
        when(pessoaRepository.findById(pessoaId)).thenReturn(Optional.empty());
        Optional<Pessoa> resultado = pessoaService.findById(pessoaId);
        assertFalse(resultado.isPresent());
    }

    @Test
    public void testSalvarPessoa() {
        LocalDate dataNascimento = LocalDate.of(2000, 10, 20);
        Pessoa novaPessoa = new Pessoa(null, "Ana", dataNascimento, "111.222.333-44", true, false);
        Pessoa pessoaSalva = new Pessoa(1L, "Ana", dataNascimento, "111.222.333-44", true, false);
        when(pessoaRepository.save(any(Pessoa.class))).thenReturn(pessoaSalva);
        Pessoa pessoaRetornada = pessoaService.save(novaPessoa);
        assertNotNull(pessoaRetornada.getId());
        assertEquals("Ana", pessoaRetornada.getNome());
    }

    @Test
    public void testAtualizarPessoaExistente() {
        Long pessoaId = 1L;
        LocalDate dataNascimento = LocalDate.of(1990, 1, 1);
        Pessoa pessoaExistente = new Pessoa(pessoaId, "João", dataNascimento, "123.456.789-00", true, false);
        Pessoa pessoaAtualizada = new Pessoa(pessoaId, "João Silva", dataNascimento, "123.456.789-00", true, false);
        when(pessoaRepository.existsById(pessoaId)).thenReturn(true);
        when(pessoaRepository.findById(pessoaId)).thenReturn(Optional.of(pessoaExistente));
        when(pessoaRepository.save(any(Pessoa.class))).thenReturn(pessoaAtualizada);
        Pessoa pessoaRetornada = pessoaService.update(pessoaAtualizada);
        assertEquals("João Silva", pessoaRetornada.getNome());
    }

    @Test
    public void testAtualizarPessoaNaoExistente() {
        Long pessoaId = 100L;
        LocalDate dataNascimento = LocalDate.of(1990, 1, 1);
        Pessoa pessoaAtualizada = new Pessoa(pessoaId, "Maria", dataNascimento, "987.654.321-00", false, true);
        when(pessoaRepository.existsById(pessoaId)).thenReturn(false);
        assertThrows(IllegalArgumentException.class, () -> {
            pessoaService.update(pessoaAtualizada);
        });
    }

    @Test
    public void testExcluirPessoaExistente() {
        Long pessoaId = 1L;
        when(pessoaRepository.existsById(pessoaId)).thenReturn(true);
        doNothing().when(pessoaRepository).deleteById(pessoaId);
        assertTrue(pessoaService.delete(pessoaId));
        verify(pessoaRepository, times(1)).deleteById(pessoaId);
    }

    @Test
    public void testExcluirPessoaNaoExistente() {
        doThrow(IllegalArgumentException.class).when(pessoaRepository).deleteById(anyLong());
        assertThrows(IllegalArgumentException.class, () -> pessoaService.delete(1L));
        verify(pessoaRepository, never()).deleteById(1L);
    }
}