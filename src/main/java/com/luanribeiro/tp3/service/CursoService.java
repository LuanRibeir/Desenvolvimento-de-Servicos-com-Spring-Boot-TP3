package com.luanribeiro.tp3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.luanribeiro.tp3.model.Curso;
import com.luanribeiro.tp3.repository.CursoRepository;

@Service
public class CursoService {
    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private AlunoService alunoService;

    @Cacheable(value = "cursos")
    public List<Curso> buscarCursos() {
        return cursoRepository.findAll();
    }

    public Curso adicionarCursoAoAluno(Long alunoId, Curso curso) {
        var aluno = alunoService.acharAlunoPeloId(alunoId);
        curso.setAluno(aluno);
        return cursoRepository.save(curso);
    }

    public Curso buscarCursoPeloId(Long id) {
        return cursoRepository.findById(id).orElseThrow(() -> new RuntimeException("Curso não encontrado."));
    }

    public ResponseEntity<?> deletar(Long id) {
        return cursoRepository.findById(id).map(curso -> {
            cursoRepository.delete(curso);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new RuntimeException("Curso não encontrado."));
    }

    public Curso atualizar(Long id, Curso cursoToUpdate) {
        return cursoRepository.findById(id).map(curso -> {
            curso.setNome(cursoToUpdate.getNome());
            return cursoRepository.save(curso);
        }).orElseThrow(() -> new RuntimeException("Curso não encontrado."));
    }

    public ResponseEntity<?> buscarTodos(Long alunoId) {
        List<Curso> cursos = cursoRepository.findByAlunoId(alunoId);
        if (cursos.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(cursos);
    }
}
