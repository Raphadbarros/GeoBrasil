package com.desafiojava.mapearestado.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.desafiojava.mapearestado.entidades.Estados;
import com.desafiojava.mapearestado.services.EstadosServices;

import javassist.tools.rmi.ObjectNotFoundException;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class MapearestadoController {

	public MapearestadoController() {
	}

	@Autowired
	private EstadosServices estadosServ;

	@RequestMapping(value = "/estados", method = RequestMethod.GET)
	public ResponseEntity<?> listartodosEstados() throws ObjectNotFoundException {
		List<Estados> obj = estadosServ.listartodosEstados();
		return ResponseEntity.ok().body(obj);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> listarestadosid(@PathVariable Integer id) throws ObjectNotFoundException {
		Estados obj = estadosServ.buscarEstadosId(id);
		return ResponseEntity.ok().body(obj);
	}

}