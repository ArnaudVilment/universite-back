package fr.vilment.universite.enseignant.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import fr.vilment.universite.enseignant.domain.Enseignant;

public interface IEnseignantController {

	public List<Enseignant> selectAllEnseignant();
	public Enseignant getEnseignant(int id);
	public Enseignant saveEnseignant(@RequestBody Enseignant ens);
	public void delEnseignant(@PathVariable int id);
	public Enseignant updateEnseignant(@RequestBody Enseignant ens);
	public List<Enseignant> chercherEnseignant(@RequestBody String nom);
	public List<Enseignant> triEnseignantAsc();
	public List<Enseignant> triEnseignantDesc();
	
}
