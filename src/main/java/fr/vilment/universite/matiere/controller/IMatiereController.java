package fr.vilment.universite.matiere.controller;

import java.util.List;

import fr.vilment.universite.matiere.domain.Matiere;

public interface IMatiereController {

	public List<Matiere> selectAllMatiere();
	public List<Matiere> selectAllMatiereEns(int id_Ens);
	public List<Matiere> selectAllMatiereNonEns(int idEns);
}
