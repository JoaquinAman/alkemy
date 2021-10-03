package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Null;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "genero")
public class Genero {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column()
	private String nombre;
	@Column()
	private String imagen;
    @Null
    @OneToMany(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	private List<Pelicula> peliculas;
	
    public Genero(String nombre, String imagen) {
        this.nombre = nombre;
        this.imagen = imagen;
        this.peliculas = new ArrayList<>();
    }
    
    public void setPeli(Pelicula pelicula) {
        peliculas.add(pelicula);
    }
}
