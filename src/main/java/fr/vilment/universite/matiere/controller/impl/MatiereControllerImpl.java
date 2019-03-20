package fr.vilment.universite.matiere.controller.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import fr.vilment.universite.enseignant.controller.impl.EnseignantControllerImpl;
import fr.vilment.universite.matiere.controller.IMatiereController;
import fr.vilment.universite.matiere.domain.Matiere;
import fr.vilment.universite.matiere.service.impl.MatiereServiceImpl;

@RestController
public class MatiereControllerImpl implements IMatiereController {

	// Logger
	Logger log = LoggerFactory.getLogger(EnseignantControllerImpl.class);
		
	@Autowired
	private MatiereServiceImpl mS;
	
	@Override
	@GetMapping(path="/matieres")
	public List<Matiere> selectAllMatiere() {
		return mS.selectAll();
	}
	
	@Override
	@GetMapping(path="/matieresEns/{idEns}")
	public List<Matiere> selectAllMatiereEns(@PathVariable int idEns) {
		return mS.selectAllMatiereEns(idEns);
	}
	
	@Override
	@GetMapping(path="/matieresNonEns/{idEns}")
	public List<Matiere> selectAllMatiereNonEns(@PathVariable int idEns) {
		return mS.selectAllMatiereNonEns(idEns);
	}
}
