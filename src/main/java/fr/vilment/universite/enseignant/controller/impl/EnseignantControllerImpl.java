package fr.vilment.universite.enseignant.controller.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.vilment.universite.enseignant.controller.IEnseignantController;
import fr.vilment.universite.enseignant.domain.Enseignant;
import fr.vilment.universite.enseignant.service.impl.EnseignantServiceImpl;
import fr.vilment.universite.matiere.domain.Matiere;
import fr.vilment.universite.matiere.service.impl.MatiereServiceImpl;

@RestController
public class EnseignantControllerImpl implements IEnseignantController {

	// Logger
	Logger log = LoggerFactory.getLogger(EnseignantControllerImpl.class);
	
	@Autowired
	private EnseignantServiceImpl eS;
	@Autowired
	private MatiereServiceImpl mS;
	
	@Override
	@GetMapping(path="/listEnseignant")
	public List<Enseignant> selectAllEnseignant() {
	
		return eS.selectAll();
	}
	
	@Override
	@GetMapping(value = "/Enseignant/{id}")
	public Enseignant getEnseignant(@PathVariable int id) {
		Enseignant ens =  eS.selectOn(id);
		List<Matiere> lM = mS.selectAllMatiereEns(id);
		ens.setListMatiere(lM);
		return ens;
	}
	
	@Override
	@PostMapping(value = "/saveEnseignant")
	public Enseignant saveEnseignant(@RequestBody Enseignant ens) {
		
		return eS.newEnseignant(ens);
	}
	
	@Override
	@PutMapping(value = "/updateEnseignant")
	public Enseignant updateEnseignant(@RequestBody Enseignant ens) {
		
		return eS.newEnseignant(ens);
	}
	
	@Override
	@DeleteMapping(value = "/delEnseignant/{id}")
	public void delEnseignant(@PathVariable int id) {
		
		eS.deleteOne(id);
	}
	
	@Override
	@GetMapping(value = "/enseignants/search/{search}")
	public List<Enseignant> chercherEnseignant(@PathVariable String search) {
		return eS.findEnseignantByNom(search);
	}
	
	@Override
	@GetMapping(value = "enseignants/triAsc")
	public List<Enseignant> triEnseignantAsc() {
		return eS.findAllByOrderByNom();
	}
	
	@Override
	@GetMapping(value = "enseignants/triDesc")
	public List<Enseignant> triEnseignantDesc() {
		return eS.findAllByOrderByNomDesc();
	}
}
