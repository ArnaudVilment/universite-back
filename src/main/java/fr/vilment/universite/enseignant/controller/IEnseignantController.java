package fr.vilment.universite.enseignant.controller;

import java.util.List;

import fr.vilment.universite.enseignant.domain.Enseignant;

public interface IEnseignantController {

	public List<Enseignant> selectAllEnseignant();
	public Enseignant getEnseignant(int id);
	
}
