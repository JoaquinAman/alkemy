package com.example.demo.model;

import java.util.ArrayList;
import java.util.Date;
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
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Null;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Pelicula {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column()
	private String imagen;
	@Column()
	private String titulo;
	@Column()
	private Date fechaCreacion;
	@Column()
	@Min(1)
    @Max(5)
    private int calificacion;
	
	@Null
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, targetEntity = Personaje.class)
	@JoinTable(name = "pelicula_personajes",
			inverseJoinColumns = @JoinColumn(name = "personaje_id", nullable = false, updatable = false),
			foreignKey = @ForeignKey(ConstraintMode.CONSTRAINT),
			inverseForeignKey = @ForeignKey(ConstraintMode.CONSTRAINT))
	@JsonBackReference
	private List<Personaje> personajes;
	
    public Pelicula(String imagen, String titulo, Date fechaCreacion, int calificacion) {
        this.imagen = imagen;
        this.titulo = titulo;
        this.fechaCreacion = fechaCreacion;
        this.calificacion = calificacion;
        this.personajes = new ArrayList<>();
    }

    public Pelicula(String imagen, String titulo, int calificacion) {}
    
    public void setPersonaje(Personaje personaje){
        personajes.add(personaje);
    }
}
