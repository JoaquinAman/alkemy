package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.builder.PeliculaBuilder;
import com.example.demo.dto.PeliculaCrearDto;
import com.example.demo.dto.PeliculaEditarDto;
import com.example.demo.excepciones.BussinesException;
import com.example.demo.excepciones.ResourceNotFoundException;
import com.example.demo.model.Genero;
import com.example.demo.model.Pelicula;
import com.example.demo.model.Personaje;
import com.example.demo.repository.GeneroRepository;
import com.example.demo.repository.PeliculaRepository;
import com.example.demo.repository.PersonajeRepository;
import com.example.demo.service.PeliculaService;

@Service
public class PeliculaServiceImpl implements PeliculaService{

	@Autowired
    private PeliculaRepository peliculaRepository;
    @Autowired
    private PersonajeRepository personajeRepository;
    @Autowired
    private GeneroRepository generoRepository;
    

    @Override
    public List<Pelicula> findAll() {
        try{
            return peliculaRepository.findAll();
        } catch (Exception e){
            throw new BussinesException("Error al mostrar la entidad");
        }
    }

    @Override
    public Pelicula buscarPorTitulo(@PathVariable String titulo) {
        try{
            return peliculaRepository.findByTitulo(titulo);
        } catch (Exception e){
            throw new ResourceNotFoundException("no se encontro la entidad");
        }
    }

    @Override
    public List<Pelicula> buscarPorCreacionAscendente() {
        try{
            return peliculaRepository.findAllByOrderByFechaCreacionAsc();
        } catch (Exception e){
            throw new BussinesException("Error al mostrar la entidad");
        }
    }

    @Override
    public List<Pelicula> buscarPorCreacionDescendente() {
        try{
            return peliculaRepository.findAllByOrderByFechaCreacionDesc();
        } catch (Exception e){
            throw new BussinesException("Error al mostrar la entidad");
        }
    }

    @Override
    public List<Pelicula> buscarTodasPelisPorGeneroId(Long id) {
        try{
            Genero genero = generoRepository.findById(id).get();
            return genero.getPeliculas(); 
        } catch (Exception e){
            throw new ResourceNotFoundException("no se encontro el id de la entidad");
        }
    }

    @Override
    public Pelicula savePelicula(@RequestBody PeliculaCrearDto pelicula) {
        try{
            Pelicula nuevaPelicula = new PeliculaBuilder().withPeliculaDto(pelicula).build();
            return peliculaRepository.save(nuevaPelicula);
        } catch (Exception e){
            throw new BussinesException("imposible generar nueva entidad");
        }
    }

    @Override
    public Pelicula update(Long id, PeliculaEditarDto pelicula) {
        try{
            Pelicula nuevaPelicula = peliculaRepository.findById(id).get();
            nuevaPelicula = new PeliculaBuilder().withPeliculaDto(pelicula).edit(nuevaPelicula);
            if(pelicula.getIdPersonaje() != null){
                Personaje personaje = personajeRepository.findById(pelicula.getIdPersonaje()).get();
                nuevaPelicula.setPersonaje(personaje);
                //al asignarle un personaje a la pelicula enlaza tambien el personaje a la pelicula que le corresponde
                personaje.setPeli(nuevaPelicula);
                personajeRepository.save(personaje);
            }
            return peliculaRepository.save(nuevaPelicula);
        } catch (Exception e){
            throw new ResourceNotFoundException("no se encontro el id de la entidad");
        }
    }

    @Override
    public void delete(@PathVariable Long id) {
        try{
            peliculaRepository.deleteById(id);
        } catch (Exception e){
            throw new ResourceNotFoundException("no se encontro el id de la entidad");
        }
    }
}
