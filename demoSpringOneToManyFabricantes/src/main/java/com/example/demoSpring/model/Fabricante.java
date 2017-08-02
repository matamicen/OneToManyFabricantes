package com.example.demoSpring.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "fabricantes")
public class Fabricante {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String nombre;
	
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "fabricante")
	private List<Articulo> listaArticulos;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "municipio_id")
	private Municipio municipio;
	
	
	public Fabricante() {
		super();
		listaArticulos = new ArrayList<Articulo>();
	}




	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

    public void agregoArticulo (Articulo art)
    {
    	this.listaArticulos.add(art);
    	art.setFabricante(this);
    	
    }



	public List<Articulo> getListaArticulos() {
		return listaArticulos;
	}




	public Long getId() {
		return id;
	}




	public void setId(Long id) {
		this.id = id;
	}




	public Municipio getMunicipio() {
		return municipio;
	}




	public void setMunicipio(Municipio municipio) {
		this.municipio = municipio;
	}




	public void setListaArticulos(List<Articulo> listaArticulos) {
		this.listaArticulos = listaArticulos;
	}

	
	

}
