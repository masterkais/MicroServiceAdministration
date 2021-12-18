package com.iit.imprimerie.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iit.imprimerie.entities.Niveau;

@Repository
public interface NiveauDao extends JpaRepository <Niveau, Integer>{

}
