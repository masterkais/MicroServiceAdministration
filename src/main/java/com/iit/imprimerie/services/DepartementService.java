package com.iit.imprimerie.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iit.imprimerie.dao.DepartementDao;
import com.iit.imprimerie.entities.Departement;
import com.iit.imprimerie.exception.ConflitException;
import com.iit.imprimerie.exception.NoException;
import com.iit.imprimerie.exception.NotFoundException;

@Service
public class DepartementService {
	@Autowired
	DepartementDao dps;

	public void AjouterDepartement(Departement m) {
		if (dps.findByLib(m.getLib()) != null) {
			throw new ConflitException("le departement existe deja dans la base");
		} else {
			dps.saveAndFlush(m);
			throw new NoException("l'objet est ajouter avec sucée");
		}
	}

	public void supprimerDepartement(int id) {
		try {
			dps.deleteById(id);
		} catch (Exception e) {
			// TODO: handle exception
			throw new NotFoundException("no recod with the id " + id + " was found in daabase ");
		}
	}

	public void modifierDepartement(Departement m) {
		if (dps.findByLib(m.getLib()) != null) {
			throw new ConflitException("le departement existe deja dans la base");
		} else {
			dps.saveAndFlush(m);
		}
	}

	public Optional<Departement> getDepartement(int id) {
		try {
			Optional<Departement> m = Optional.of(dps.findById(id).get());
			return m;
		} catch (Exception e) {
			// TODO: handle exception
			throw new NotFoundException("no recod with the id " + id + " was found in daabase ");
		}
	}

	public List<Departement> getAllDepartement() {
		return dps.findAll();
	}
}
