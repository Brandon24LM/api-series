package com.puce.series.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "series")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Serie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El título es obligatorio")
    @Column(nullable = false)
    private String titulo;

    @NotBlank(message = "La plataforma es obligatoria")
    @Column(nullable = false)
    private String plataforma;

    @NotNull(message = "La calificación es obligatoria")
    @DecimalMin(value = "1.0", message = "La calificación mínima es 1")
    @DecimalMax(value = "10.0", message = "La calificación máxima es 10")
    @Column(nullable = false)
    private Double calificacion;
}
