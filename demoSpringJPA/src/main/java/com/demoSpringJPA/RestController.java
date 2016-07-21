package com.demoSpringJPA;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.demoSpringJPA.repository.LoginRepo;
import com.demoSpringJPA.service.LoginService;
import com.demoSpringJPA.service.ResultMaker;

@org.springframework.web.bind.annotation.RestController
public class RestController {
	
	@Autowired
	private LoginRepo loginRepo;
	
	@Autowired
	private LoginService loginService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ResponseEntity<String> connect() {
		return new ResponseEntity<String>(HttpStatus.OK);
	}
	
	@RequestMapping(value = "/registration", method = RequestMethod.POST, produces = "application/json")
	public ResultMaker registration(@RequestParam(value="name") String name, @RequestParam(value="password") String password) {
		
		return loginService.registration(name, password);
		
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST, produces = "application/json")
	public ResultMaker login(@RequestParam(value="name") String name, @RequestParam(value="password") String password, HttpServletRequest request) {
		
		return loginService.login(name, password, request);
		
	}

}
