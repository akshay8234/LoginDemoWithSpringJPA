package com.demoSpringJPA.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public class ResultMaker {

	private Map map;

	HttpServletRequest request;
	
	Object object;

	ResultMaker(Map map, HttpServletRequest request) {

		this.map = map;

		System.out.println("this is resultmaker");

		this.request = request;

	}
	
	public Map getResult() {

		if (request != null && request.getSession(false) != null) {
			
		}

		return map;

	}

}