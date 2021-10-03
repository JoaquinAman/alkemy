package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Genero;

@Repository
public interface GeneroRepository extends JpaRepository<Genero, Long>{

}
