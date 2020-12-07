package com.desafiojava.mapearestado.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafiojava.mapearestado.entidades.Cidades;
import com.desafiojava.mapearestado.entidades.Estados;
import com.desafiojava.mapearestado.repositories.CidadesRepositori;
import com.desafiojava.mapearestado.repositories.EstadoRepositori;

import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class CidadesServices {

	@Autowired
	public CidadesRepositori cidadesRepositori;

	@Autowired
	public EstadoRepositori estadoRepositori;

	@Autowired
	public EstadosServices estadoServices;

	public List<Cidades> buscarCidades() {
		List<Cidades> obj = cidadesRepositori.findAll();
		return obj;
	}

	public List<Cidades> buscarcidade(int id) throws ObjectNotFoundException {
		List<Cidades> obj = cidadesRepositori.findAll();
		List<Cidades> cidades = new ArrayList<>();

		for (Cidades valor : obj) {

			if (valor.getEstados().getidEstado().equals(id)) {
				cidades.add(valor);
			}
		}
		return cidades;

	}

	public Cidades insert(Cidades obj) throws ObjectNotFoundException {
		int idEstado = obj.getEstados().getidEstado();
		String nomeCidade = obj.getnomeCidades();

		Estados estadosBase = estadoServices.buscarEstadosId(idEstado);
		List<Cidades> todasCidades = cidadesRepositori.findAll();

		if (idEstado == estadosBase.getidEstado()) {

			for (Cidades valor : todasCidades) {

				if (valor.getnomeCidades().equals(nomeCidade)) {
					break;
				} else {
					return cidadesRepositori.save(obj);
				}

			}

		} else {
			return cidadesRepositori.save(obj);
		}
		return obj;

	}

	public Cidades VerificaCidadeExiste(Cidades obj) throws ObjectNotFoundException {

		return obj;
	}

	public void DeletarCidade(String nomecidade) throws ObjectNotFoundException {
		String cidade = "Rio Grande do Sul";

		List<Estados> listEstadosBase = estadoRepositori.findAll();
		List<Cidades> listCidadesBase = cidadesRepositori.findAll();

		for (Cidades valorCidade : listCidadesBase) {

			if (valorCidade.getnomeCidades().equals(cidade)) {
				int idCidadeEstadoBase = valorCidade.getEstados().getidEstado();

				for (Estados valorEstados : listEstadosBase) {

					if (valorEstados.getidEstado().equals(idCidadeEstadoBase)) {
						break;
					} else {
						int CidadeIdDelear = valorCidade.getId();
						cidadesRepositori.deleteById(CidadeIdDelear);

					}
				}
			} else {

				for (Cidades valorCidades : listCidadesBase) {

					if (valorCidades.getnomeCidades().equals(cidade)) {
						int idCidade = valorCidades.getId();
						cidadesRepositori.deleteById(idCidade);
					}
				}
			}
		}

	}

}