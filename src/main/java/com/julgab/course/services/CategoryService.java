package com.julgab.course.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.julgab.course.entities.Category;
import com.julgab.course.repositories.CategoryRepository;

@Service // Transforma em um Component do Sprint e com isto, permite fazer uma injeção de dependência com a @Autowired
public class CategoryService {
	
	@Autowired // É para que o Spring Boot faça automaticamente um injeção de dependência.
	private CategoryRepository repository;
	
	public List<Category> findAll(){
		return repository.findAll();
	}
	
	public Category findById(Integer id){
//		Optional<Category> obj = repository.findById(id); 
//		return obj.get();
		return (repository.findById(id).get());
	}
}
