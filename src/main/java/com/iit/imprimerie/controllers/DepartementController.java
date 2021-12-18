package com.iit.imprimerie.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.iit.imprimerie.entities.Departement;
import com.iit.imprimerie.entities.Enseignant;
import com.iit.imprimerie.services.DepartementService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api("/ApiDepartement")
public class DepartementController {
	@Autowired
	DepartementService dps;

	@ApiOperation(value = "Ajouter un departement", notes = "cette methode permet d'ajouter l'objet dans la base", response = Departement.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "l'objet  est creé !"),
			@ApiResponse(code = 400, message = "l'objet  n'est pas valide !"),
			@ApiResponse(code = 409, message = "un objet dans la base posséde les mémes caracteristique ! ")
	})
	@PostMapping("/Departement")
	public void AjouterDepartement(@RequestBody Departement m) {
		dps.AjouterDepartement(m);
	}

	@ApiOperation(value = "supprimer un departement", notes = "cette methode permet de supprimer un departement pas son id qui existe dans le base de donnée", response = Departement.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "le departement est supprimer"),
			@ApiResponse(code = 204, message = "le departement est supprimer avec sucée"),
			@ApiResponse(code = 401, message = "requée necessite le client doit identifier"),
			@ApiResponse(code = 403, message = "le serveur n'est pas autorisé pour cette requéte")
	})
	@DeleteMapping("/Departement/{id}")
	public void supprimerDepartement(@PathVariable int id) {
		dps.supprimerDepartement(id);
	}

	@ApiOperation(value = "Modifier departement", notes = "cette methode permet de modifier une departement ", response = Enseignant.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "l'objet est modifer "),
			@ApiResponse(code = 400, message = "l'objet  n'est pas valide") })
	@PutMapping("/Departement")
	public void modifierDepartement(@RequestBody Departement m) {
		dps.modifierDepartement(m);
	}

	@ApiOperation(value = "Rechercher une departement", notes = "cette methode permet de rechercher une departement par sont id", response = Departement.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "le departement est trouvé"),
			@ApiResponse(code = 404, message = "aucun departement existe dans la base de donnée avec ce id"),
			@ApiResponse(code = 500,message = "aucun departement existe dans la base de donnée avec ce id" )
			}
			)
	@GetMapping("/Departement/{id}")
	public Optional<Departement> getDepartement(@PathVariable int id) {
		Optional<Departement> departement = dps.getDepartement(id);
		return departement;
	}

	@ApiOperation(value = "renvoie la liste des departements", notes = "cette methode permet de renvoyer la liste des article qui existe dans le base de donnée", responseContainer = "List<Departement>")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "la liste des article / une liste vide"), })
	@GetMapping("/GetAllDepartement")
	public List<Departement> getAllDepartement() {
		//throw new ApiRequestException("cannot get all departement");
		 return dps.getAllDepartement();

	}
	
}
