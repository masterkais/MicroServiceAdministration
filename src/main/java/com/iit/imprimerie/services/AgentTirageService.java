package com.iit.imprimerie.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iit.imprimerie.dao.AgentTirageDao;
import com.iit.imprimerie.entities.AgentTirage;
import com.iit.imprimerie.exception.ConflitException;
import com.iit.imprimerie.exception.NoException;
import com.iit.imprimerie.exception.NotFoundException;

@Service
public class AgentTirageService {
	@Autowired
	AgentTirageDao ag;

	public void AjouterAgentTirageDao(AgentTirage m) {

		if (getUtilisateurByLoginPassword(m.getLogin(), m.getPassword()) != null) {
			throw new ConflitException("l'agent existe deja dans la base");
		} else {
			ag.saveAndFlush(m);
			throw new NoException("l'objet est ajouter avec sucée");
		}
	}

	public void supprimerAgentTirageDao(int id) {

		try {
			ag.deleteById(id);
		} catch (Exception e) {
			// TODO: handle exception
			throw new NotFoundException("no recod with the id " + id + " was found in daabase ");
		}
	}

	public void modifierAgentTirageDao(AgentTirage m) {
		ag.saveAndFlush(m);
	}

	public AgentTirage getAgentTirageDao(int id) {

		try {
			AgentTirage m = ag.findById(id).get();
			return m;
		} catch (Exception e) {
			// TODO: handle exception
			throw new NotFoundException("no recod with the id " + id + " was found in daabase ");
		}

	}

	public List<AgentTirage> getAllNAgentTirageDao() {
		return ag.findAll();
	}

	public AgentTirage getUtilisateurByLoginPassword(String login, String password) {

		try {
			AgentTirage u = null;
			u = ag.getUserByLoginAndPassword(login, password);
			return u;
		} catch (Exception e) {
			// TODO: handle exception
			throw new NotFoundException("no recod with the login " + login + " was found in daabase ");
		}
	}

}
