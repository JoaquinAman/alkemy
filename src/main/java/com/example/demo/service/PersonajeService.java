package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.PersonajeCrearDto;
import com.example.demo.dto.PersonajeEditarDto;
import com.example.demo.model.Personaje;

public interface PersonajeService {
	
	public Personaje savePersonaje(PersonajeCrearDto personajeDto);
	public List<Personaje> findAll();
	public Personaje update(Long id, PersonajeEditarDto personajeDto);
	public void delete(Long id);
	
	public List<String> mostrarNombresYImagen();
	public List<Personaje> mostrarPeliculasPorId(Long id);
	public List<Personaje> buscarPorNombre(String nombre);
	public List<Personaje> buscarPorEdad(int edad);
	public List<Personaje> buscarPorPeso(int peso);
}
