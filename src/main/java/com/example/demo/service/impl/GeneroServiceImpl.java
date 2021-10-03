package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.builder.GeneroBuilder;
import com.example.demo.dto.GeneroCrearDto;
import com.example.demo.dto.GeneroEditarDto;
import com.example.demo.excepciones.BussinesException;
import com.example.demo.excepciones.ResourceNotFoundException;
import com.example.demo.model.Genero;
import com.example.demo.repository.GeneroRepository;
import com.example.demo.repository.PeliculaRepository;
import com.example.demo.service.GeneroService;

@Service
public class GeneroServiceImpl implements GeneroService{

	 	@Autowired
	    private GeneroRepository generoRepository;

	    @Autowired
	    private PeliculaRepository peliculaRepository;
	    
	    @Override
	    public List<Genero> findAll(){
	        try{
	            return generoRepository.findAll();
	        } catch (Exception e){
	            throw new BussinesException("Error al mostrar la entidad");
	        }
	    }

	    @Override
	    public Genero saveGenero(GeneroCrearDto generoDto) {
	        try{
	            Genero nuevoGenero = new GeneroBuilder().withGeneroDto(generoDto).build();
	            return generoRepository.save(nuevoGenero);
	        } catch (Exception e){
	            throw new BussinesException("imposible generar nueva entidad");
	        }
	    }

	    @Override
	    public Genero update(Long id, GeneroEditarDto generoDto) {
	        try{
	            Genero nuevoGenero = generoRepository.findById(id).get();
	            nuevoGenero = new GeneroBuilder().withGeneroDto(generoDto).edit(nuevoGenero);
	            nuevoGenero.setPeli(peliculaRepository.findById(generoDto.getIdPelicula()).get());
	            return generoRepository.save(nuevoGenero);

	        } catch (Exception e){
	            throw new ResourceNotFoundException("no se encontro el id de la entidad");
	        }
	    }

	    @Override
	    public void delete(@PathVariable Long id) {
	        try{
	            generoRepository.deleteById(id);
	        } catch (Exception e){
	            throw new ResourceNotFoundException("no se encontro el id de la entidad");
	        }
	    }
}