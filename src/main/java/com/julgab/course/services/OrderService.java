package com.julgab.course.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.julgab.course.entities.Order;
import com.julgab.course.repositories.OrderRepository;

@Service // Transforma em um Component do Sprint e com isto, permite fazer uma injeção de dependência com a @Autowired
public class OrderService {
	
	@Autowired // É para que o Spring Boot faça automaticamente um injeção de dependência.
	private OrderRepository repository;
	
	public List<Order> findAll(){
		return repository.findAll();
	}
	
	public Order findById(Integer id){
//		Optional<Order> obj = repository.findById(id); 
//		return obj.get();
		return (repository.findById(id).get());
	}
}
