package com.iit.imprimerie.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iit.imprimerie.dao.AdminDao;
import com.iit.imprimerie.entities.Admin;
import com.iit.imprimerie.exception.NotFoundException;

@Service
public class AdminService {
	@Autowired
	AdminDao ensd;

	public Admin getUtilisateurByLoginPassword(String login, String password) {

		try {
			Admin u = null;
			u = ensd.getUserByLoginAndPassword(login, password);

			return u;
		} catch (Exception e) {
			// TODO: handle exception
			throw new NotFoundException("no recod with the login " + login + " was found in daabase ");
		}

	}

}
