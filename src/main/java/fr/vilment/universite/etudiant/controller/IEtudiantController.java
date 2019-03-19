package fr.vilment.universite.etudiant.controller;

import java.util.List;

import fr.vilment.universite.etudiant.domain.Etudiant;

public interface IEtudiantController {
	public List<Etudiant> findAll();
	
	public Etudiant findOne(Integer id);
	
	public Etudiant save(Etudiant etudiant);
}