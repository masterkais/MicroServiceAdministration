package com.iit.imprimerie.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class AgentTirage implements Serializable {
	@Id@GeneratedValue(strategy = GenerationType.AUTO)
	private int id_agent;
	private String cin;
	private String prenom;
	private String nom;
	private String adress;
	private String email;
	private String phone;
	private String login;
	private String password;
	
}
