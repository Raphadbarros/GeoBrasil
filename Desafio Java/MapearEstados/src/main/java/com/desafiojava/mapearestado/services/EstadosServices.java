package com.desafiojava.mapearestado.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafiojava.mapearestado.entidades.Estados;
import com.desafiojava.mapearestado.repositories.EstadoRepositori;

import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class EstadosServices {

	@Autowired
	public EstadoRepositori estadoRepositori;

	public Estados buscarEstadosId(Integer id) throws ObjectNotFoundException {
		Optional<Estados> obj = estadoRepositori.findById(id);
		return obj.orElseThrow(()-> new ObjectNotFoundException(
				"Não foi encontrado Estado"+ id +",Nome:" + Estados.class.getName()));
	}
	
	public List<Estados> listartodosEstados() throws ObjectNotFoundException {
		List<Estados> obj = estadoRepositori.findAll();
		return obj;
	}
	

}
