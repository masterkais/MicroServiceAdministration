package com.iit.imprimerie.entities;

import java.io.Serializable;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Ligne_DemandeResponse implements Serializable {
	private int id;
	private DemandeTirageResponse demande;
	private DocumentResponse document;
	

}
