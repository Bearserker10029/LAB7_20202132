package org.example.cursoservice.controller;

import org.example.cursoservice.model.Curso;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/curso")
public class CursoController {

    private final Map<String, Curso> catalogo = new HashMap<>();

    public CursoController() {
        catalogo.put("1TEL05", new Curso("1TEL05", "Servicios y Aplicaciones para IoT", 4));
        catalogo.put("1TEL04", new Curso("1TEL04", "Redes de Computadoras", 4));
        catalogo.put("1TEL03", new Curso("1TEL03", "Comunicaciones Digitales", 3));
        catalogo.put("1TEL02", new Curso("1TEL02", "Sistemas Operativos", 3));
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<Curso> getCurso(@PathVariable String codigo) {
        if (codigo == null) {
            return ResponseEntity.badRequest().build();
        }
        Curso curso = catalogo.get(codigo.toUpperCase());
        if (curso != null) {
            return ResponseEntity.ok(curso);
        }
        return ResponseEntity.notFound().build();
    }
}
