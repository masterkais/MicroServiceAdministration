package com.iit.imprimerie.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
public class Matiere implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id_mat;
	private String lib;
	@ManyToOne
	@JoinColumn(name = "ID_ENS")
	Enseignant ens;

	@ManyToOne
	@JoinColumn(name = "ID_NIV")
	private Niveau niv;
	@ManyToOne
	@JoinColumn(name = "ID_DEP")
	private Departement dep;


	

}
