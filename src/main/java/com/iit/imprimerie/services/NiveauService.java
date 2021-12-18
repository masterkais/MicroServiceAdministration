package com.iit.imprimerie.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iit.imprimerie.dao.NiveauDao;
import com.iit.imprimerie.entities.AgentTirage;
import com.iit.imprimerie.entities.Niveau;
import com.iit.imprimerie.exception.NotFoundException;

@Service
public class NiveauService {
	@Autowired
	NiveauDao nivs;

	public void AjouterNiveau(Niveau m) {
		nivs.saveAndFlush(m);
	}

	public void supprimerNiveau(int id) {

		try {
			nivs.deleteById(id);
		} catch (Exception e) {
			// TODO: handle exception
			throw new NotFoundException("no recod with the id " + id + " was found in daabase ");
		}
	}

	public void modifierNiveau(Niveau m) {
		nivs.saveAndFlush(m);
	}

	public Niveau getNiveau(int id) {
	
		try {
			Niveau m = nivs.findById(id).get();
			return m;
		} catch (Exception e) {
			// TODO: handle exception
			throw new NotFoundException("no recod with the id " + id + " was found in daabase ");
		}
	}

	public List<Niveau> getAllNiveau() {
		return nivs.findAll();
	}
}
