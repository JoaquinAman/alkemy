package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.builder.PersonajeBuilder;
import com.example.demo.dto.PersonajeCrearDto;
import com.example.demo.dto.PersonajeEditarDto;
import com.example.demo.excepciones.BussinesException;
import com.example.demo.excepciones.ResourceNotFoundException;
import com.example.demo.model.Pelicula;
import com.example.demo.model.Personaje;
import com.example.demo.repository.PeliculaRepository;
import com.example.demo.repository.PersonajeRepository;
import com.example.demo.service.PersonajeService;

@Service
public class PersonajeServiceImpl implements PersonajeService {

	@Autowired
	private PersonajeRepository personajeRepository;
	@Autowired
	private PeliculaRepository peliculaRepository;

	@Override
	public List<Personaje> findAll() {
		try {
			return personajeRepository.findAll();
		} catch (Exception e) {
			throw new BussinesException("Error al mostrar la entidad");
		}
	}

	@Override
	public List<String> mostrarNombresYImagen() {
		try {
			return personajeRepository.getAllNombresAndImagen();
		} catch (Exception e) {
			throw new BussinesException("Error al mostrar la entidad");
		}
	}

	@Override
	public List<Personaje> mostrarPeliculasPorId(Long id) {
		try {
			Pelicula pelicula = peliculaRepository.findById(id).get();
			return pelicula.getPersonajes();
		} catch (Exception e) {
			throw new ResourceNotFoundException("no se encontro el id de la entidad");
		}
	}

	@Override
	public List<Personaje> buscarPorNombre(String nombre) {
		try {
			return personajeRepository.findByNombre(nombre);
		} catch (Exception e) {
			throw new ResourceNotFoundException("no se encontro la entidad");
		}
	}

	@Override
	public List<Personaje> buscarPorEdad(int edad) {
		try {
			return personajeRepository.findByEdad(edad);
		} catch (Exception e) {
			throw new ResourceNotFoundException("no se encontro la entidad");
		}
	}

	@Override
	public List<Personaje> buscarPorPeso(int peso) {
		try {
			return personajeRepository.findByPeso(peso);
		} catch (Exception e) {
			throw new ResourceNotFoundException("no se encontro la entidad");
		}
	}

	@Override
	public Personaje savePersonaje(PersonajeCrearDto personaje) {
		try {
			Personaje nuevoPersonaje = new PersonajeBuilder().withPersonajeDto(personaje).build();
			return personajeRepository.save(nuevoPersonaje);
		} catch (Exception e) {
			throw new BussinesException("imposible generar nueva entidad");
		}
	}

	@Override
	public Personaje update(Long id, PersonajeEditarDto newPersonaje) {
		try {
			Personaje nuevoPersonaje = personajeRepository.findById(id).get();
			nuevoPersonaje = new PersonajeBuilder().withPersonajeDto(newPersonaje).edit(nuevoPersonaje);
			if (newPersonaje.getIdPelicula() != null) {
				Pelicula pelicula = peliculaRepository.findById(newPersonaje.getIdPelicula()).get();
				nuevoPersonaje.setPeli(pelicula);
				// al asignarle una pelicula al personaje enlaza tambien la pelicula con el
				// personaje
				pelicula.setPersonaje(nuevoPersonaje);
				peliculaRepository.save(pelicula);
			}
			return personajeRepository.save(nuevoPersonaje);
		} catch (Exception e) {
			throw new ResourceNotFoundException("no se encontro el id de la entidad");
		}
	}

	@Override
	public void delete(Long id) {
		try {
			personajeRepository.deleteById(id);
		} catch (Exception e) {
			throw new ResourceNotFoundException("no se encontro el id de la entidad");
		}
	}

}
