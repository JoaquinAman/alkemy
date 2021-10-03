package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.PeliculaCrearDto;
import com.example.demo.dto.PeliculaEditarDto;
import com.example.demo.model.Pelicula;
import com.example.demo.service.PeliculaService;

@RestController
@RequestMapping("/movies")
@CrossOrigin("*")
public class PeliculaController {

	@Autowired
    private final PeliculaService peliculaService;

    public PeliculaController(PeliculaService peliculaService) {
        this.peliculaService = peliculaService;
    }

    @GetMapping
    public ResponseEntity<?> mostrarPeliculas(){
        try{
            return new ResponseEntity<>(peliculaService.findAll(), HttpStatus.ACCEPTED);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("titulo/{titulo}")
    public ResponseEntity<?> mostrarPeliculasPorTitulo(@PathVariable String titulo){
        try{
            return new ResponseEntity<>(peliculaService.buscarPorTitulo(titulo), HttpStatus.ACCEPTED);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("genero/{id}")
    public ResponseEntity<?> mostrarPorGenero(@PathVariable Long id){
        try{
            return new ResponseEntity<>(peliculaService.buscarTodasPelisPorGeneroId(id), HttpStatus.ACCEPTED);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("orden/ASC")
    public ResponseEntity<?> mostrarPeliculasPorCreacionAscendente(){
        try{
            return new ResponseEntity<>(peliculaService.buscarPorCreacionAscendente(), HttpStatus.ACCEPTED);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("orden/DESC")
    public ResponseEntity<?> mostrarPeliculasPorCreacionDescendiente(){
        try{
            return new ResponseEntity<>(peliculaService.buscarPorCreacionDescendente(), HttpStatus.ACCEPTED);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarGenero(@PathVariable Long id, @RequestBody PeliculaEditarDto peliculaDto){
        try{
            Pelicula pelicula = peliculaService.update(id, peliculaDto);
            return new ResponseEntity<>(pelicula, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<?> guardarPelicula(@RequestBody PeliculaCrearDto peliculaDto){
        try{
            Pelicula pelicula = peliculaService.savePelicula(peliculaDto);
            return new ResponseEntity<>(pelicula, HttpStatus.ACCEPTED);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> borrarPeliculaPorId(@PathVariable Long id){
        try{
            peliculaService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
