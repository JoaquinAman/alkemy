package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Usuario {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column()
	private String mail;
	@Column()
	private String username;
	@Column()
	private String password;

	 public Usuario(String mail, String username, String password) {
	        this.mail = mail;
	        this.username = username;
	        this.password = password;
    }

}
