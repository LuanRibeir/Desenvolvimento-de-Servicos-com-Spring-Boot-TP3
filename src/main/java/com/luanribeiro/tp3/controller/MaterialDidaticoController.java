package com.luanribeiro.tp3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luanribeiro.tp3.model.MaterialDidatico;
import com.luanribeiro.tp3.service.MaterialDidaticoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/materialDidatico")
public class MaterialDidaticoController {
    @Autowired
    private MaterialDidaticoService materialDidaticoService;

    @PostMapping
    public MaterialDidatico addMaterialDidatico(@RequestBody MaterialDidatico MaterialDidatico) {
        return materialDidaticoService.salvar(MaterialDidatico);
    }

    @GetMapping
    public List<MaterialDidatico> getMaterialDidatico() {
        return materialDidaticoService.buscarTodos();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMaterialDidatico(@PathVariable String id) {
        System.out.println(id);
        return materialDidaticoService.deletar(id);
    }

    @PutMapping("/{id}")
    public MaterialDidatico updateCurso(@PathVariable String id, @RequestBody MaterialDidatico materialDidatico) {
        return materialDidaticoService.atualizar(id, materialDidatico);
    }

}
