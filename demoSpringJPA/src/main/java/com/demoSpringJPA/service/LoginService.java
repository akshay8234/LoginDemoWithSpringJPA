package com.demoSpringJPA.service;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.demoSpringJPA.entity.Login;
import com.demoSpringJPA.repository.LoginRepo;

@Service
public class LoginService {

	@Autowired
	private LoginRepo loginRepo;

	public ResultMaker registration(String name, String password) {

		HashMap result = new HashMap();

		try {

			if (loginRepo.findByName(name) != null) {

				result.put("response", "exist");

				return new ResultMaker(result, null);

			}

			Login login = new Login();

			login.setName(name);

			login.setPassword(password);

			boolean save = loginRepo.save(login) == null ? false : true;

			if (save) {

				result.put("response", "success");

			}

			else {

				result.put("response", "failure");

			}

		}

		catch (Exception ex) {

			ex.printStackTrace();

			result.put("response", "failure");

		}

		return new ResultMaker(result, null);

	}

	public ResultMaker login(String name, String password,
			HttpServletRequest request) {

		HashMap result = new HashMap();

		Login login = loginRepo.findByName(name);

		if (login != null) {

			if (login.getPassword().equals(password)) {

				HttpSession session = request.getSession(true);

				session.setMaxInactiveInterval(-1);

				session.setAttribute("loginId", login.getLoginId());

				result.put("response", "success");

				result.put("jsessionid", session.getId());

				result.put("loginId", login.getLoginId());

				result.put("name", login.getName());
				
				

			}

			else {

				result.put("response", "wrongPassword");

			}
			
			return new ResultMaker(result, request);

		}
		
		else {
			
			result.put("response", "notExist");

			return new ResultMaker(result, request);
		
		}

	}

}
