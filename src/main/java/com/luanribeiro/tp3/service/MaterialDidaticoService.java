package com.luanribeiro.tp3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.luanribeiro.tp3.model.MaterialDidatico;
import com.luanribeiro.tp3.repository.MaterialDidaticoRepository;

@Service
public class MaterialDidaticoService {
    @Autowired
    private MaterialDidaticoRepository materialDidaticoRepository;

    public List<MaterialDidatico> buscarTodos() {
        return materialDidaticoRepository.findAll();
    }

    public MaterialDidatico salvar(MaterialDidatico materialDidatico) {
        return materialDidaticoRepository.save(materialDidatico);
    }

    public ResponseEntity<?> deletar(String id) {
        MaterialDidatico material = materialDidaticoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Material não encontrado."));

        materialDidaticoRepository.delete(material);
        return ResponseEntity.ok().build();
    }

    public MaterialDidatico atualizar(String id, MaterialDidatico materialDidatico) {
        MaterialDidatico novoMaterial = materialDidaticoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Material não encontrado."));

        novoMaterial.setNome(materialDidatico.getNome());
        novoMaterial.setQuantidade(materialDidatico.getQuantidade());

        return materialDidaticoRepository.save(novoMaterial);
    }

}
