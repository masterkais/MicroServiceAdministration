package com.iit.imprimerie.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iit.imprimerie.dao.MatiereDao;
import com.iit.imprimerie.entities.AgentTirage;
import com.iit.imprimerie.entities.Matiere;
import com.iit.imprimerie.exception.NotFoundException;

@Service
public class MatiereService {
	@Autowired
	MatiereDao mats;
	public void AjouterMatiere(Matiere m ) {
		mats.saveAndFlush(m);
	}
	public void supprimerMat(int id) {
	
		try {
			mats.deleteById(id);		} catch (Exception e) {
			// TODO: handle exception
			throw new NotFoundException("no recod matiere with the id " + id + " was found in database ");
		}
	}
	public void modifierMat(Matiere m) {
	mats.saveAndFlush(m);
	}
	public Matiere getMatiere(int id) {
	
	try {
		Matiere m=mats.findById(id).get();
		return m;
	} catch (Exception e) {
		// TODO: handle exception
		throw new NotFoundException("no recod with the id " + id + " was found in daabase ");
	}
	}
	public List<Matiere> getAllMatiere(){
		return mats.findAll();
	}
}
