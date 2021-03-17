package com.julgab.course.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.julgab.course.entities.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	@GetMapping
	public ResponseEntity<User> findAll(){
		User u1 = new User(1, "Eleonora Moreira", "noram@gmail.com", "21983214675", "12345");
		return ResponseEntity.ok().body(u1);
	}

}
