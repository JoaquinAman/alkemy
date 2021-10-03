package com.example.demo.controller;

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

import com.example.demo.dto.PersonajeCrearDto;
import com.example.demo.dto.PersonajeEditarDto;
import com.example.demo.model.Personaje;
import com.example.demo.service.PersonajeService;

@RestController
@RequestMapping("/characters")
@CrossOrigin("*")
public class PersonajeController {

    private final PersonajeService personajeService;

    public PersonajeController(PersonajeService personajeService) {
        this.personajeService = personajeService;
    }

    @GetMapping("/personajes")
    public ResponseEntity<?> mostrarPersonajes(){
        try{
            return new ResponseEntity<>(personajeService.findAll(), HttpStatus.ACCEPTED);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public ResponseEntity<?> mostrarPorNombresEImagenes(){
        try{
            return new ResponseEntity<>(personajeService.mostrarNombresYImagen(), HttpStatus.ACCEPTED);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("movies/{id}")
    public ResponseEntity<?> mostrarPelisPorId(@PathVariable Long id){
        try{
            return new ResponseEntity<>(personajeService.mostrarPeliculasPorId(id), HttpStatus.ACCEPTED);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<?> mostrarPorNombre(@PathVariable String nombre){
        try{
            return new ResponseEntity<>(personajeService.buscarPorNombre(nombre), HttpStatus.ACCEPTED);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/edad/{edad}")
    public ResponseEntity<?> mostrarPorEdad(@PathVariable int edad){
        try{
            return new ResponseEntity<>(personajeService.buscarPorEdad(edad), HttpStatus.ACCEPTED);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/peso/{peso}")
    public ResponseEntity<?> mostrarPorPeso(@PathVariable int peso){
        try{
            return new ResponseEntity<>(personajeService.buscarPorPeso(peso), HttpStatus.ACCEPTED);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarPersonaje(@PathVariable Long id, @RequestBody PersonajeEditarDto personajeDto){
        try{
            return new ResponseEntity<>(personajeService.update(id, personajeDto), HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<?> guardarPersonaje(@RequestBody PersonajeCrearDto personaje){
        try{
            Personaje nuevoPersonaje = personajeService.savePersonaje(personaje);
            return new ResponseEntity<>(nuevoPersonaje, HttpStatus.ACCEPTED);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> borrarPersonaje(@PathVariable Long id){
        try{
            personajeService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
