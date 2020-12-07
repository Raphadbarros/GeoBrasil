package com.desafiojava.mapearestado.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "estados")
public class Estados implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idEstado;

	private String nomeEstado;

	private String Bandeira;

	@OneToMany(mappedBy = "estados")
	private List<Cidades> cidades = new ArrayList<>();

	public Estados() {

	}

	public Estados(Integer idEstado, String nomeEstado, String bandeira) {
		super();
		this.idEstado = idEstado;
		this.nomeEstado = nomeEstado;
		Bandeira = bandeira;
	}

	public String getBandeira() {
		return Bandeira;
	}

	public void setBandeira(String bandeira) {
		Bandeira = bandeira;
	}

	public Integer getidEstado() {
		return idEstado;
	}

	public void setidEstado(Integer idEstado) {
		this.idEstado = idEstado;
	}

	public String getnomeEstado() {
		return nomeEstado;
	}

	public void setnomeEstado(String nomeEstado) {
		this.nomeEstado = nomeEstado;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idEstado == null) ? 0 : idEstado.hashCode());
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
		Estados other = (Estados) obj;
		if (idEstado == null) {
			if (other.idEstado != null)
				return false;
		} else if (!idEstado.equals(other.idEstado))
			return false;
		return true;
	}

}
