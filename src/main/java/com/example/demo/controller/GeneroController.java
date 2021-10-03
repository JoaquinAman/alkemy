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

import com.example.demo.dto.GeneroCrearDto;
import com.example.demo.dto.GeneroEditarDto;
import com.example.demo.model.Genero;
import com.example.demo.service.GeneroService;

@RestController
@RequestMapping("/generos")
@CrossOrigin("*")
public class GeneroController {
		
		private final GeneroService generoService;

	    public GeneroController(GeneroService generoService) {
	        this.generoService = generoService;
	    }

	    @GetMapping
	    public ResponseEntity<?> mostrarGeneros(){
	        try{
	            return new ResponseEntity<>(generoService.findAll(), HttpStatus.ACCEPTED);
	        } catch (Exception e){
	            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<?> actualizarGenero(@PathVariable Long id, @RequestBody GeneroEditarDto generoDto){
	        try{
	            return new ResponseEntity<>(generoService.update(id, generoDto), HttpStatus.OK);

	        } catch (Exception e){
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }

	    @PostMapping
	    public ResponseEntity<?> guardarGenero(@RequestBody GeneroCrearDto generoDto){
	        try{
	            Genero genero = generoService.saveGenero(generoDto);
	            return new ResponseEntity<>(genero, HttpStatus.CREATED);
	        } catch (Exception e){
	            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<?> borrarGenero(@PathVariable Long id){
	        try{
	            generoService.delete(id);
	            return new ResponseEntity<>(HttpStatus.OK);
	        } catch (Exception e){
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }
}
