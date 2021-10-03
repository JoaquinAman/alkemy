package com.example.demo.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PeliculaCrearDto {

    private String imagen;
    private String titulo;
    private int calificacion;
}
