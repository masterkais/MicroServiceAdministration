package com.iit.imprimerie.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.iit.imprimerie.entities.Admin;
import com.iit.imprimerie.entities.AgentTirage;
import com.iit.imprimerie.services.AdminService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api("/ApiAdmin")
public class AdminController {
	@Autowired
	AdminService ensd;
	@ApiOperation(value = "chercher un objet", notes = "cette methode permet de chercher un objet par son login et password qui existe dans le base de donnée", response = AgentTirage.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "l'objet est trouvée"),
			@ApiResponse(code = 404, message = "aucun objet existe dans la base avec ce id"),
			@ApiResponse(code = 500, message = "aucun objet existe dans la base de donnée avec ce id") })
	@GetMapping("/Admin/{login}/{password}")
	public Admin getUtilisateurByLoginPassword(@PathVariable String login, @PathVariable String password) {
		Admin u = null;
		u = ensd.getUtilisateurByLoginPassword(login, password);

		return u;

	}
}
