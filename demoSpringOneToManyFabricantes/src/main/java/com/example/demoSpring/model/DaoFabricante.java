package com.example.demoSpring.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface DaoFabricante extends CrudRepository<Fabricante, Long> {

	 public Iterable<Fabricante> findByNombre(String nombre);
	
}
