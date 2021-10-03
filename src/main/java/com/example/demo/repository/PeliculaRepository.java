package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Pelicula;

@Repository
public interface PeliculaRepository extends JpaRepository<Pelicula, Long> {

		Pelicula findByTitulo(String titulo);
	    List<Pelicula> findAllByOrderByFechaCreacionAsc();
	    List<Pelicula> findAllByOrderByFechaCreacionDesc();
}
