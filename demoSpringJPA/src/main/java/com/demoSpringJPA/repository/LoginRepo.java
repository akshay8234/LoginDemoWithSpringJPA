package com.demoSpringJPA.repository;

import org.springframework.data.repository.CrudRepository;

import com.demoSpringJPA.entity.Login;

public interface LoginRepo extends CrudRepository<Login, Long> {

	Login findByName(String name);
	
}
