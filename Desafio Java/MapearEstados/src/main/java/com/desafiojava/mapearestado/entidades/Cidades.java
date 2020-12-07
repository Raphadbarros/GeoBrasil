package com.desafiojava.mapearestado.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.databind.ser.std.SerializableSerializer;

@Entity
public class Cidades extends SerializableSerializer {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String nomeCidades;
	
	@ManyToOne
	@JoinColumn(name = "estado_id")
	private Estados estados;

	public Cidades() {
	}

	public Cidades(Integer id, String nomeCidades, Estados estados) {
		super();
		this.id = id;
		this.nomeCidades = nomeCidades;
		this.estados = estados;
	}

	public Estados getEstados() {
		return estados;
	}

	public void setEstados(Estados estados) {
		this.estados = estados;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getnomeCidades() {
		return nomeCidades;
	}

	public void setnomeCidades(String nomeCidades) {
		this.nomeCidades = nomeCidades;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cidades other = (Cidades) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
