package com.iit.imprimerie.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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
public class DocumentResponse implements Serializable {
private int id_document;
private String path;
private String type; //pdf or image or world
private Enseignant ens;
private List<Ligne_DemandeResponse> lignedemande=new ArrayList<Ligne_DemandeResponse>();
private Matiere mat;

}
