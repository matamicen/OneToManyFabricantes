package com.example.demoSpring.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "articulos")
public class Articulo {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String nombre;
	private float precio;
	
    
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "fabricante_id")
	private Fabricante fabricante;
	
	
	
	public Articulo() {
		super();
	}



	public Articulo(String nombre, float precio) {
		super();
		this.nombre = nombre;
		this.precio = precio;
		
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public float getPrecio() {
		return precio;
	}



	public void setPrecio(float precio) {
		this.precio = precio;
	}



	public Fabricante getFabricante() {
		return fabricante;
	}



	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}

	

	
	
	
	

}
