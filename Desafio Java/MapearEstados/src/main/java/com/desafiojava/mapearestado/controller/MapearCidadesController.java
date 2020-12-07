package com.desafiojava.mapearestado.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.desafiojava.mapearestado.entidades.Cidades;
import com.desafiojava.mapearestado.services.CidadesServices;

import javassist.tools.rmi.ObjectNotFoundException;

@Controller
@RequestMapping("/api/cidades")
@CrossOrigin(origins = "*")
public class MapearCidadesController {

	@Autowired
	private CidadesServices cidadesServ;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public ResponseEntity<?> cidades() throws ObjectNotFoundException {
		List<Cidades> obj = cidadesServ.buscarCidades();
		return ResponseEntity.ok().body(obj);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> listartodosEstados(@PathVariable Integer id) throws ObjectNotFoundException {
		List<Cidades> obj = cidadesServ.buscarcidade(id);
		return ResponseEntity.ok().body(obj);
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public Cidades insertCidade(Cidades obj) throws ObjectNotFoundException {
		return obj = cidadesServ.insert(obj);
	}

	@RequestMapping(value = "/{nomecidade}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deletaCidade(@PathVariable String nomecidade) throws ObjectNotFoundException {
		cidadesServ.DeletarCidade(nomecidade);
		return ResponseEntity.noContent().build();
	}

}
