package com.example.demoSpring.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Municipio {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String nombre;
	private String intendente;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "municipio")
	private List<Fabricante> listaFabricantes;

	public Municipio() {
		super();
		listaFabricantes = new ArrayList<Fabricante>();
	}
	
	

	public Municipio(String nombre, String intendente) {
		super();
		this.nombre = nombre;
		this.intendente = intendente;
		listaFabricantes = new ArrayList<Fabricante>();
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getIntendente() {
		return intendente;
	}

	public void setIntendente(String intendente) {
		this.intendente = intendente;
	}

	public List<Fabricante> getListaFabricantes() {
		return listaFabricantes;
	}

	public void setListaFabricantes(List<Fabricante> listaFabricantes) {
		this.listaFabricantes = listaFabricantes;
	}
	
	public void agregoFabricante(Fabricante fab)
	{
		this.listaFabricantes.add(fab);
		fab.setMunicipio(this);
	}
	

}
