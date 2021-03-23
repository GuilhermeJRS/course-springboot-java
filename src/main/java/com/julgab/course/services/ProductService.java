package com.julgab.course.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.julgab.course.entities.Product;
import com.julgab.course.repositories.ProductRepository;

@Service // Transforma em um Component do Sprint e com isto, permite fazer uma injeção de dependência com a @Autowired
public class ProductService {
	
	@Autowired // É para que o Spring Boot faça automaticamente um injeção de dependência.
	private ProductRepository repository;
	
	public List<Product> findAll(){
		return repository.findAll();
	}
	
	public Product findById(Integer id){
//		Optional<Product> obj = repository.findById(id); 
//		return obj.get();
		return (repository.findById(id).get());
	}
}
