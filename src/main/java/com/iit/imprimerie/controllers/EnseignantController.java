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

import com.iit.imprimerie.entities.Enseignant;
import com.iit.imprimerie.services.EnseignantService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api("/ApiEnseignant")
public class EnseignantController {
	@Autowired
	EnseignantService ensd;

	@ApiOperation(value = "Ajouter enseignant", notes = "cette methode permet d'ajouter un enseignant ", response = Enseignant.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "l'objet enseignant est ajouter"),
			@ApiResponse(code = 400, message = "l'objet enseignant n'est pas valide") })
	@PostMapping("/Enseignant")
	public void AjouterEns(@RequestBody Enseignant e) {
		ensd.AjouterEns(e);

	}
	@ApiOperation(value = "chercher un enseignant", notes = "cette methode permet de chercher un enseignant par son id qui existe dans le base de donnée", response = Enseignant.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "l'enseignat est trouvée"),
	@ApiResponse(code = 404, message = "aucun enseignant existe dans la base avec ce id"),
	@ApiResponse(code = 500, message = "aucun enseignant existe dans la base de donnée avec ce id")
	})
	@GetMapping("/Enseignant/{id}")
	public Enseignant getEnseignant(@PathVariable int id) {
		return ensd.getEnseignant(id);
	}
	@ApiOperation(value = "renvoie la liste des enseigants", notes = "cette methode permet de renvoyer la liste des article qui existe dans le base de donnée", responseContainer = "List<Enseignant>")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "la liste des article / une liste vide"), })
	@GetMapping("/GeAllEnseignant")
	public List<Enseignant> getAllEnseignant() {
		return ensd.getAllEnseignant();

	}
	@ApiOperation(value = "supprimer un enseignant", notes = "cette methode permet de supprimer un enseignant par son id qui existe dans le base de donnée", response = Enseignant.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "l'objet est supprimer"),
			@ApiResponse(code = 204, message = "l'objet est supprimer avec sucée"),
			@ApiResponse(code = 401, message = "requée necessite le client doit identifier"),
			@ApiResponse(code = 403, message = "le serveur n'est pas autorisé pour cette requéte")
	})
	@DeleteMapping("/Enseignant/{id}")
	public String supprimerEnseignant(@PathVariable int id) {
		ensd.supprimerEnseignant(id);
		return "suppression avec succée";
	}
	@ApiOperation(value = "Modifier enseignant", notes = "cette methode permet de modifier l'enseignant ", response = Enseignant.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "l'objet est modifer "),
			@ApiResponse(code = 400, message = "l'objet  n'est pas valide") })
	@PutMapping("/Enseignant")
	public Enseignant modifierEnseignat(@RequestBody Enseignant e) {
		return ensd.modifierEnseignat(e);
	}
	@ApiOperation(value = "renvoyer un enseignant pas sont login et password ", notes = "cette methode permet de renvoyer un enseignant pas sont login et password ", response = Enseignant.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "le departement est trouvé"),
			@ApiResponse(code = 404, message = "aucun enseignant existe dans la base de donnée avec ce login et paswword"),
			@ApiResponse(code = 500,message = "aucun departement existe dans la base de donnée avec ce login et paswword" )
			}
			)
	@GetMapping("/Enseignant/{login}/{password}")
	public Enseignant getUtilisateurByLoginPassword(@PathVariable String login, @PathVariable String password) {
		Enseignant u = null;
		u = ensd.getUtilisateurByLoginPassword(login, password);

		return u;

	}
}
