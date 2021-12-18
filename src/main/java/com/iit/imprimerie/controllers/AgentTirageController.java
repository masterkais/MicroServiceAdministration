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

import com.iit.imprimerie.entities.AgentTirage;
import com.iit.imprimerie.entities.Enseignant;
import com.iit.imprimerie.entities.Matiere;
import com.iit.imprimerie.services.AgentTirageService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api("/ApiAgentTirage")
public class AgentTirageController {
	@Autowired
	AgentTirageService ag;
	@ApiOperation(value = "Ajouter objet", notes = "cette methode permet au enseignant d'ajouter un objet ", response = AgentTirage.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "l'objet  est ajouter"),
			@ApiResponse(code = 400, message = "l'objet  n'est pas valide") })
	@PostMapping("/AgentTirage")
	public void AjouterAgentTirageDao(@RequestBody AgentTirage m) {
		ag.AjouterAgentTirageDao(m);
	}
	@ApiOperation(value = "supprimer objet", notes = "cette methode permet de supprimer un objet par son id qui existe dans le base de donnée", response = AgentTirage.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "l'objet est supprimer"),
			@ApiResponse(code = 204, message = "l'objet est supprimer avec sucée"),
			@ApiResponse(code = 401, message = "requée necessite le client doit identifier"),
			@ApiResponse(code = 403, message = "le serveur n'est pas autorisé pour cette requéte") })
	@DeleteMapping("/AgentTirage/{id}")
	public void supprimerAgentTirageDao(@PathVariable int id) {
		ag.supprimerAgentTirageDao(id);
	}
	@ApiOperation(value = "Modifier objet", notes = "cette methode permet de modifier un objet ", response = AgentTirage.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "l'objet est modifer "),
			@ApiResponse(code = 400, message = "l'objet  n'est pas valide") })
	@PutMapping("/AgentTirage")
	public void modifierAgentTirageDao(AgentTirage m) {
		ag.modifierAgentTirageDao(m);
	}
	@ApiOperation(value = "chercher un objet", notes = "cette methode permet de chercher un objet par son id qui existe dans le base de donnée", response = AgentTirage.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "l'objet est trouvée"),
			@ApiResponse(code = 404, message = "aucun objet existe dans la base avec ce id"),
			@ApiResponse(code = 500, message = "aucun objet existe dans la base de donnée avec ce id") })
	@GetMapping("/AgentTirage/{id}")
	public AgentTirage getAgentTirageDao(@PathVariable int id) {
		AgentTirage m = ag.getAgentTirageDao(id);
		return m;
	}
	@ApiOperation(value = "renvoie la liste des objets", notes = "cette methode permet de renvoyer la liste des objet qui existe dans le base de donnée", responseContainer = "List<AgentTirage>")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "la liste des objet / une liste vide"), })
	@GetMapping("/GetAllAgentTirage")
	public List<AgentTirage> getAllNAgentTirageDao() {
		return ag.getAllNAgentTirageDao();
	}
	@ApiOperation(value = "renvoyer un agentTirage pas sont login et password ", notes = "cette methode permet de renvoyer un enseignant pas sont login et password ", response = AgentTirage.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "le agentTirage est trouvé"),
			@ApiResponse(code = 404, message = "aucun agentTirage existe dans la base de donnée avec ce login et paswword"),
			@ApiResponse(code = 500,message = "aucun agentTirage existe dans la base de donnée avec ce login et paswword" )
			}
			)
	@GetMapping("/AgentTirage/{login}/{password}")
	public AgentTirage getUtilisateurByLoginPassword(@PathVariable String login, @PathVariable String password) {
		AgentTirage u = null;
		u = ag.getUtilisateurByLoginPassword(login, password);

		return u;

	}
}
