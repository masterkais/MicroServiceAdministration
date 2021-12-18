package com.iit.imprimerie.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

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
public class DemandeTirageResponse {
	private int id_demande;
	private Date date_demande;
	private Date date_arrive;
	private int nbr_copie;   //limiter par nbr de classe
	private int type_tirage; // presentielle (reservation place pour turage) ou bien envoie pdf a distant
	private int etat_demande; //1 si la demande et préparé si non 0
	private List<Ligne_DemandeResponse> lc;
	private Enseignant ens;

	}
