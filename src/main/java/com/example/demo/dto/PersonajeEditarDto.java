package com.example.demo.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PersonajeEditarDto {

    private String imagen;
    private String nombre;
    private int edad;
    private int peso;
    private String historia;
    private Long idPelicula;

}
