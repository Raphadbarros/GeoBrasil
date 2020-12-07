package com.desafiojava.mapearestado.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.desafiojava.mapearestado.entidades.Cidades;

@Repository
public interface CidadesRepositori extends JpaRepository<Cidades, Integer>{

	
}
