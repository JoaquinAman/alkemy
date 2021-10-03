package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.GeneroCrearDto;
import com.example.demo.dto.GeneroEditarDto;
import com.example.demo.model.Genero;


public interface GeneroService {
	public Genero saveGenero(GeneroCrearDto generoDto);
	public List<Genero> findAll();
	public Genero update(Long id, GeneroEditarDto generoDto);
	public void delete (Long id);
}
