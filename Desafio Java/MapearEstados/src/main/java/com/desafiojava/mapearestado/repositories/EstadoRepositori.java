package com.desafiojava.mapearestado.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.desafiojava.mapearestado.entidades.Estados;


@Repository
public interface EstadoRepositori extends JpaRepository<Estados, Integer>{
	
	
}
