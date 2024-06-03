package com.luanribeiro.tp3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.luanribeiro.tp3.model.Aluno;
import com.luanribeiro.tp3.repository.AlunoRepository;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    public Aluno acharAlunoPeloId(Long alunoId) {
        return alunoRepository.findById(alunoId).orElse(null);
    }

    public List<Aluno> buscarTodos() {
        return alunoRepository.findAll();
    }

    public ResponseEntity<?> deletar(Long id) {
        Aluno aluno = alunoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado."));

        alunoRepository.delete(aluno);
        return ResponseEntity.ok().build();
    }

    public Aluno criar(Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    public Aluno atualizar(Long id, Aluno aluno) {
        Aluno novoAluno = alunoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado."));

        novoAluno.setNome(aluno.getNome());
        novoAluno.setCursos(aluno.getCursos());

        return alunoRepository.save(novoAluno);
    }

}
