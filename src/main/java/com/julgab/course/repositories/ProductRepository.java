package com.julgab.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.julgab.course.entities.Product;

// Não tem a necessidade de usar a anotação @Repository para tornar um Component do Spring,pois a JpaRepository já é 
// uma @Repository e com isto já pode fazer uma injeção de dependencia com o @Autowired
public interface ProductRepository extends JpaRepository<Product, Integer>{
	
}
