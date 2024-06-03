package com.luanribeiro.tp3.controller;

import org.springframework.web.bind.annotation.RestController;

import com.luanribeiro.tp3.model.Curso;
import com.luanribeiro.tp3.service.CursoService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/curso")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @PostMapping("/aluno/{alunoId}")
    public Curso addCursoAluno(@PathVariable Long alunoId, @RequestBody Curso curso) {
        return cursoService.adicionarCursoAoAluno(alunoId, curso);
    }

    @GetMapping
    public List<Curso> getAllCurso() {
        return cursoService.buscarCursos();
    }

    @GetMapping("/{id}")
    public Curso getCursoById(@PathVariable Long id) {
        return cursoService.buscarCursoPeloId(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCurso(@PathVariable Long id) {
        return cursoService.deletar(id);
    }

    @PutMapping("/{id}")
    public Curso updateCurso(@PathVariable Long id, @RequestBody Curso cursoToUpdate) {
        return cursoService.atualizar(id, cursoToUpdate);
    }

    @GetMapping("/aluno/{alunoId}")
    public ResponseEntity<?> getAllCursoAluno(@PathVariable Long alunoId) {
        return cursoService.buscarTodos(alunoId);
    }

}
