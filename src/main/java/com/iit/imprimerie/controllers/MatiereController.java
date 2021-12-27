package com.iit.imprimerie.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.iit.imprimerie.entities.Matiere;
import com.iit.imprimerie.services.MatiereService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api("/ApiMatiere")
public class MatiereController {
	@Autowired
	MatiereService mats;

	@ApiOperation(value = "Ajouter objet", notes = "cette methode permet d'ajouter un objet ", response = Matiere.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "l'objet  est ajouter"),
			@ApiResponse(code = 400, message = "l'objet  n'est pas valide") })
	@PostMapping("/Matiere")
	public void AjouterMatiere(@RequestBody Matiere m) {
		mats.AjouterMatiere(m);
	}

	@ApiOperation(value = "supprimer objet", notes = "cette methode permet de supprimer un objet par son id qui existe dans le base de donnée", response = Matiere.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "l'objet est supprimer"),
			@ApiResponse(code = 204, message = "l'objet est supprimer avec sucée"),
			@ApiResponse(code = 401, message = "requée necessite le client doit identifier"),
			@ApiResponse(code = 403, message = "le serveur n'est pas autorisé pour cette requéte") })
	@DeleteMapping("/Matiere/{id}")
	public void supprimerMat(@PathVariable int id) {
		mats.supprimerMat(id);
	}

	@ApiOperation(value = "Modifier objet", notes = "cette methode permet de modifier un objet ", response = Matiere.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "l'objet est modifer "),
			@ApiResponse(code = 400, message = "l'objet  n'est pas valide") })
	@PutMapping("/Matiere")
	public void modifierMat(@RequestBody Matiere m) {
		mats.modifierMat(m);
	}

	@ApiOperation(value = "chercher un objet", notes = "cette methode permet de chercher un objet par son id qui existe dans le base de donnée", response = Matiere.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "l'objet est trouvée"),
			@ApiResponse(code = 404, message = "aucun objet existe dans la base avec ce id"),
			@ApiResponse(code = 500, message = "aucun objet existe dans la base de donnée avec ce id") })
	@GetMapping(value="/Matiere/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	public Matiere getMatiere(@PathVariable int id) {
		Matiere m = mats.getMatiere(id);
		return m;
	}

	@ApiOperation(value = "renvoie la liste des objets", notes = "cette methode permet de renvoyer la liste des objet qui existe dans le base de donnée", responseContainer = "List<Matiere>")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "la liste des objet / une liste vide"), })
	@GetMapping(value="/GetAllMatiere",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Matiere> getAllMatiere() {
		return mats.getAllMatiere();

	}
}
