package com.puce.series.service;

import com.puce.series.models.Serie;
import com.puce.series.repository.SerieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SerieService {

    private final SerieRepository serieRepository;

    public List<Serie> listarTodas() {
        return serieRepository.findAll();
    }

    public Optional<Serie> buscarPorId(Long id) {
        return serieRepository.findById(id);
    }

    public Serie crear(Serie serie) {
        serie.setId(null);
        return serieRepository.save(serie);
    }

    public Optional<Serie> actualizar(Long id, Serie datos) {
        return serieRepository.findById(id).map(serie -> {
            serie.setTitulo(datos.getTitulo());
            serie.setPlataforma(datos.getPlataforma());
            serie.setCalificacion(datos.getCalificacion());
            return serieRepository.save(serie);
        });
    }

    public boolean eliminar(Long id) {
        if (!serieRepository.existsById(id)) {
            return false;
        }
        serieRepository.deleteById(id);
        return true;
    }
}
