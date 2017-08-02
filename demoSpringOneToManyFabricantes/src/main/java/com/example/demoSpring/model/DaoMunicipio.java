package com.example.demoSpring.model;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface DaoMunicipio extends CrudRepository<Municipio, Long> {
	
	public List<Municipio> findBynombre(String nombre);

}
