package com.julgab.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.julgab.course.entities.User;
import com.julgab.course.repositories.UserRepository;
import com.julgab.course.services.exceptions.ResourceNotFoundException;

@Service // Transforma em um Component do Sprint e com isto, permite fazer uma injeção de dependência com a @Autowired
public class UserService {
	
	@Autowired // É para que o Spring Boot faça automaticamente um injeção de dependência.
	private UserRepository repository;
	
	public List<User> findAll(){
		return repository.findAll();
	}
	
	public User findById(Integer id){
		Optional<User> obj = repository.findById(id); 
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public User insert(User obj) {
		return repository.save(obj);
	}
	
	public void delete(Integer id) {
		repository.deleteById(id);
	}
	
	public User update(Integer id, User obj) {
		User entity = repository.getOne(id);
		userUpdate(entity, obj);
		return repository.save(entity);
	}

	private void userUpdate(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
	}
}
