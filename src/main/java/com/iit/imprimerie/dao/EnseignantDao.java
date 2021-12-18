package com.iit.imprimerie.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.iit.imprimerie.entities.Enseignant;

@Repository
public interface EnseignantDao extends JpaRepository<Enseignant, Integer> {

	public Enseignant findByLoginAndPasswordLike(String login, String assword);

	@Query("SELECT u FROM Enseignant u WHERE u.login = :login and u.password= :password ")
	public Enseignant getUserByLoginAndPassword(@Param("login") String login, @Param("password") String password);
}
