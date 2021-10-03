package com.example.demo.builder;

import com.example.demo.dto.GeneroCrearDto;
import com.example.demo.dto.GeneroEditarDto;
import com.example.demo.model.Genero;

public class GeneroBuilder {

    private String nombre;
    private String imagen;

    public GeneroBuilder withGeneroDto(GeneroCrearDto generoDto){
        this.nombre = generoDto.getNombre();
        this.imagen = generoDto.getImagen();
        return this;
    }

    public GeneroBuilder withGeneroDto(GeneroEditarDto generoDto){
        this.nombre = generoDto.getNombre();
        this.imagen = generoDto.getImagen();
        return this;
    }

    public Genero build(){
        return new Genero(this.nombre, this.imagen);
    }

    public Genero edit(Genero genero){
        genero.setNombre(this.nombre);
        genero.setImagen(this.imagen);
        return genero;
    }

}
