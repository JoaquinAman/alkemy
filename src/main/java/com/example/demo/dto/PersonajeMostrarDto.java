package com.example.demo.dto;

import java.util.List;

import com.example.demo.model.Pelicula;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PersonajeMostrarDto {

    private List<Pelicula> peliculas;

}
