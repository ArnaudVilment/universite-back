package fr.vilment.universite.etudiant.controller.impl;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.vilment.universite.etudiant.controller.IEtudiantController;
import fr.vilment.universite.etudiant.domain.Etudiant;
import fr.vilment.universite.etudiant.service.impl.EtudiantServiceImpl;

@RestController
public class EtudiantControllerImpl implements IEtudiantController {
	
	@Autowired
	EtudiantServiceImpl etudiantService;

	@Override
	@GetMapping("/etudiants")
	public List<Etudiant> findAll() {
		List<Etudiant> listeEtudiants = etudiantService.selectAll();
		return listeEtudiants;
	}

	@Override
	@GetMapping("/etudiants/{id}")
	public Etudiant findOne(@PathVariable Integer id) {
		Etudiant etudiant = etudiantService.selectOn(id);
		return etudiant;
	}

	@Override
	@PostMapping("/etudiants")
	public Etudiant save(@RequestBody Etudiant etudiant) {
		Etudiant e = etudiantService.newEtudiant(etudiant);
		return e;
	}

}