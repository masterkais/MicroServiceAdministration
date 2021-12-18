package com.iit.imprimerie.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.iit.imprimerie.entities.Admin;
import com.iit.imprimerie.entities.AgentTirage;

@Repository
public interface AdminDao extends JpaRepository<Admin,Integer >  {
	@Query("SELECT u FROM AgentTirage u WHERE u.login = :login and u.password= :password ")
	public Admin getUserByLoginAndPassword(@Param("login") String login, @Param("password") String password);

}
