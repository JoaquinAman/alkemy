package com.example.demo.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PeliculaEditarDto {
    private String imagen;
    private String titulo;
    private int calificacion;
    private Long idPersonaje;

}
