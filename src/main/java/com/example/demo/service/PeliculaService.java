package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.PeliculaCrearDto;
import com.example.demo.dto.PeliculaEditarDto;
import com.example.demo.model.Pelicula;


public interface PeliculaService {
	public Pelicula savePelicula(PeliculaCrearDto peliculaDto);
	public List<Pelicula> findAll();
	public Pelicula update(Long id, PeliculaEditarDto peliculaDto);
	public void delete(Long id);
	

	public Pelicula buscarPorTitulo(String titulo);
	public List<Pelicula> buscarPorCreacionAscendente();
	public List<Pelicula> buscarPorCreacionDescendente();
	public List<Pelicula> buscarTodasPelisPorGeneroId(Long id);
}
