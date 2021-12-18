package com.iit.imprimerie.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iit.imprimerie.dao.EnseignantDao;
import com.iit.imprimerie.entities.Enseignant;
import com.iit.imprimerie.exception.ConflitException;
import com.iit.imprimerie.exception.NoException;
import com.iit.imprimerie.exception.NotFoundException;

@Service
public class EnseignantService {
	@Autowired
	EnseignantDao ensd;
	Logger logger = LoggerFactory.getLogger(EnseignantService.class);
	public void AjouterEns(Enseignant e) {

		if (getUtilisateurByLoginPassword(e.getLogin(), e.getPassword()) != null) {
			throw new ConflitException("l'enseignant existe deja dans la base");
		} else {
			ensd.saveAndFlush(e);
			throw new NoException("l'objet est ajouter avec sucée");
		}
	}

	public Enseignant getEnseignant(int id) {
		logger.info("Inside getById " + id);
		try {
			return ensd.findById(id).get();
		} catch (Exception e) {
			// TODO: handle exception
			throw new NotFoundException("l'objet Enseignant avec l'id ="+id+" n'existe pas");
		}
	}

	public List<Enseignant> getAllEnseignant() {
		return ensd.findAll();
	}

	public String supprimerEnseignant(int id) {

		try {
			ensd.deleteById(id);
			return "suppression avec succée";
		} catch (Exception e) {
			// TODO: handle exception
			throw new NotFoundException("no recod with the id " + id + " was found in daabase ");
		}
	}

	public Enseignant modifierEnseignat(Enseignant e) {
		return ensd.saveAndFlush(e);
	}

	public Enseignant getUtilisateurByLoginPassword(String login, String password) {

		try {
			Enseignant u = null;
			u = ensd.getUserByLoginAndPassword(login, password);

			return u;
		} catch (Exception e) {
			// TODO: handle exception
			throw new NotFoundException("no recod with the login " + login + " was found in daabase ");
		}

	}

}
