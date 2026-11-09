package com.puce.series.controller;

import com.puce.series.models.Serie;
import com.puce.series.service.SerieService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/series")
@RequiredArgsConstructor
public class SerieController {

    private final SerieService serieService;

    // GET /api/series -> listar todas
    @GetMapping
    public ResponseEntity<List<Serie>> listar() {
        return ResponseEntity.ok(serieService.listarTodas());
    }

    // GET /api/series/{id} -> buscar por id
    @GetMapping("/{id}")
    public ResponseEntity<Serie> buscar(@PathVariable Long id) {
        return serieService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // POST /api/series -> crear
    @PostMapping
    public ResponseEntity<Serie> crear(@Valid @RequestBody Serie serie) {
        return ResponseEntity.status(HttpStatus.CREATED).body(serieService.crear(serie));
    }

    // PUT /api/series/{id} -> actualizar
    @PutMapping("/{id}")
    public ResponseEntity<Serie> actualizar(@PathVariable Long id, @Valid @RequestBody Serie serie) {
        return serieService.actualizar(id, serie)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // DELETE /api/series/{id} -> eliminar
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        return serieService.eliminar(id)
                ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }
}
