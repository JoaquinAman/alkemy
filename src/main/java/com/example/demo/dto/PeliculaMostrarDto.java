package com.example.demo.dto;

import java.util.List;

import com.example.demo.model.Personaje;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PeliculaMostrarDto {

	 private List<Personaje> personajes;

}
