package com.julgab.course.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.julgab.course.entities.User;
import com.julgab.course.repositories.UserRepository;

@Service // Transforma em um Component do Sprint e com isto, permite fazer uma injeção de dependência com a @Autowired
public class UserService {
	
	@Autowired // É para que o Spring Boot faça automaticamente um injeção de dependência.
	private UserRepository repository;
	
	public List<User> findAll(){
		return repository.findAll();
	}
	
	public User findById(Integer id){
//		Optional<User> obj = repository.findById(id); 
//		return obj.get();
		return (repository.findById(id).get());
	}
	
	public User insert(User obj) {
		return repository.save(obj);
	}
}
