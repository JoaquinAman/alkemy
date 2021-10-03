package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Personaje;

@Repository
public interface PersonajeRepository extends JpaRepository<Personaje, Long> {


    @Query("select personaje.nombre, personaje.imagen from Personaje personaje")
    List<String> getAllNombresAndImagen();

    List<Personaje> getAllPeliculasById(Long id);

    List<Personaje> findByNombre(String nombre);

    List<Personaje> findByEdad(int edad);

    List<Personaje> findByPeso(int edad);
}
