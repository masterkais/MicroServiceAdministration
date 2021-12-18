package com.iit.imprimerie.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.iit.imprimerie.entities.Matiere;
import com.iit.imprimerie.entities.Niveau;
import com.iit.imprimerie.services.NiveauService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api("ApiNiveau")
public class NiveauController {
	@Autowired
	NiveauService nivs;

	@ApiOperation(value = "Ajouter objet", notes = "cette methode permet au enseignant d'ajouter un objet ", response = Niveau.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "l'objet  est ajouter"),
			@ApiResponse(code = 400, message = "l'objet  n'est pas valide") })
	@PostMapping("/Niveau")
	public void AjouterNiveau(@RequestBody Niveau m) {
		nivs.AjouterNiveau(m);
	}

	@ApiOperation(value = "supprimer objet", notes = "cette methode permet de supprimer un objet par son id qui existe dans le base de donnée", response = Niveau.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "l'objet est supprimer"),
			@ApiResponse(code = 204, message = "l'objet est supprimer avec sucée"),
			@ApiResponse(code = 401, message = "requée necessite le client doit identifier"),
			@ApiResponse(code = 403, message = "le serveur n'est pas autorisé pour cette requéte") })
	@DeleteMapping("/Niveau/{id}")
	public void supprimerNiveau(int id) {
		nivs.supprimerNiveau(id);
	}

	@ApiOperation(value = "Modifier objet", notes = "cette methode permet de modifier un objet ", response = Niveau.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "l'objet est modifer "),
			@ApiResponse(code = 400, message = "l'objet  n'est pas valide") })
	@PutMapping("/Niveau")
	public void modifierNiveau(@RequestBody Niveau m) {
		nivs.modifierNiveau(m);
	}

	@ApiOperation(value = "chercher un objet", notes = "cette methode permet de chercher un objet par son id qui existe dans le base de donnée", response = Niveau.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "l'objet est trouvée"),
			@ApiResponse(code = 404, message = "aucun objet existe dans la base avec ce id"),
			@ApiResponse(code = 500, message = "aucun objet existe dans la base de donnée avec ce id") })
	@GetMapping("/Niveau/{id}")
	public Niveau getNiveau(@PathVariable int id) {
		Niveau m = nivs.getNiveau(id);
		return m;
	}

	@ApiOperation(value = "renvoie la liste des objets", notes = "cette methode permet de renvoyer la liste des objet qui existe dans le base de donnée", responseContainer = "List<Niveau>")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "la liste des objet / une liste vide"), })
	@GetMapping("/GetAllNiveau")
	public List<Niveau> getAllNiveau() {
		return nivs.getAllNiveau();
	}
}
