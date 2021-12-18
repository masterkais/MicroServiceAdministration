package com.iit.imprimerie.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iit.imprimerie.entities.Departement;

@Repository
public interface DepartementDao extends JpaRepository<Departement, Integer> {

	public Departement findByLib(String lib);
}
