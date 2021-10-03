package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Null;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Personaje {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column()
	private String imagen;
	@Column()
	private String nombre;
	@Column()
	private String historia;
	@Column()
	private int edad;
	@Column()
	private int peso;
	
	
    @Null
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = Pelicula.class)
	@JoinTable(name = "personaje_peliculas",
		inverseJoinColumns = @JoinColumn(name = "pelicula_id", nullable = false, updatable = false),
		joinColumns = @JoinColumn(name = "personaje_id", nullable = false, updatable = false),
		foreignKey = @ForeignKey(ConstraintMode.CONSTRAINT),
		inverseForeignKey = @ForeignKey(ConstraintMode.CONSTRAINT))
	@JsonManagedReference
	private List<Pelicula> peliculas;
    
    public Personaje(String imagen, String nombre, int edad, int peso, String historia) {
        this.imagen = imagen;
        this.nombre = nombre;
        this.edad = edad;
        this.peso = peso;
        this.historia = historia;
        this.peliculas = new ArrayList<>();
    }
    public void setPeli(Pelicula pelicula){
        peliculas.add(pelicula);
    }
}
