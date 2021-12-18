package com.iit.imprimerie.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iit.imprimerie.entities.Matiere;

@Repository
public interface MatiereDao extends JpaRepository <Matiere, Integer>{

}
