package com.iit.imprimerie.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

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
public class Departement implements Serializable {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private int id_dep;
private String lib;
@JsonIgnore
@OneToMany (mappedBy="dep", cascade = {CascadeType.PERSIST, CascadeType.REMOVE},fetch=FetchType.EAGER)
private List<Enseignant> ens;
@JsonIgnore
@OneToMany(mappedBy = "dep",fetch=FetchType.LAZY)
private List<Matiere> lmat;

}
