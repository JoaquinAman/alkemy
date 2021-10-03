package com.example.demo.builder;

import com.example.demo.dto.PeliculaCrearDto;
import com.example.demo.dto.PeliculaEditarDto;
import com.example.demo.model.Pelicula;

public class PeliculaBuilder {

	private String imagen;
    private String titulo;
    private int calificacion;

    public PeliculaBuilder withPeliculaDto(PeliculaCrearDto peliculaDto){
        this.imagen = peliculaDto.getImagen();
        this.titulo = peliculaDto.getTitulo();
        this.calificacion = peliculaDto.getCalificacion();
        return this;
    }

    public PeliculaBuilder withPeliculaDto(PeliculaEditarDto peliculaDto){
        this.imagen = peliculaDto.getImagen();
        this.titulo = peliculaDto.getTitulo();
        this.calificacion = peliculaDto.getCalificacion();
        return this;
    }

    public Pelicula build(){
        return new Pelicula(this.imagen, this.titulo, this.calificacion);
    }

    public Pelicula edit(Pelicula pelicula){
        pelicula.setImagen(this.imagen);
        pelicula.setTitulo(this.titulo);
        if(calificacion < 1 || calificacion > 5){
            throw new IllegalArgumentException("La nota tiene que ser de 1 a 5");
        } else {
            pelicula.setCalificacion(this.calificacion);
        }
        return pelicula;
    }
}
