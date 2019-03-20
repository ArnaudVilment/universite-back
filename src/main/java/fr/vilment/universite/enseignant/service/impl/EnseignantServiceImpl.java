package fr.vilment.universite.enseignant.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.vilment.universite.enseignant.domain.Enseignant;
import fr.vilment.universite.enseignant.repository.IEnseignantRepository;
import fr.vilment.universite.enseignant.service.IEnseignantService;
import fr.vilment.universite.matiere.domain.Matiere;
import fr.vilment.universite.matiere.repository.IMatiereRepository;

@Service
public class EnseignantServiceImpl implements IEnseignantService {

	@Autowired
	private IEnseignantRepository eR;
	@Autowired
	private IMatiereRepository mR;

	@Override
	public List<Enseignant> selectAll() {
		// TODO Auto-generated method stub
		List<Enseignant> lE = eR.findAll();
		checkPhoto(lE);
		return lE;
	}

	@Override
	public Enseignant selectOn(int id) {
		// TODO Auto-generated method stub
		Enseignant ens = eR.getOne(id);

		return ens;
	}

	@Override
	public void deleteOne(int id) {
		// TODO Auto-generated method stub
		eR.deleteById(id);
	}

	@Override
	public Enseignant newEnseignant(Enseignant ens) {
		// TODO Auto-generated method stub
		return eR.save(ens);
	}

	@Override
	public void editEnseignant(Enseignant ens) {
		// TODO Auto-generated method stub
		eR.save(ens);
	}
	
	@Override
	public List<Enseignant> findAllByOrderByNom() {
		// TODO Auto-generated method stub
		List<Enseignant> lE = eR.findAllByOrderByNom();
		checkPhoto(lE);
		return lE;
	}

	@Override
	public List<Enseignant> findAllByOrderByNomDesc() {
		// TODO Auto-generated method stub
		List<Enseignant> lE = eR.findAllByOrderByNomDesc();
		checkPhoto(lE);
		return lE;
	}

	@Override
	public List<Enseignant> checkPhoto(List<Enseignant> lE) {
		// Vérifier l'image pour chaque enseignant, si il ne possède pas d'image, on lui en donne une par defaut
		// http://bibliotheque.sciencespo-lyon.fr/wp-content/uploads/2018/10/des-enseignants-de-lecture_318-28655.jpg
		for(Enseignant ens : lE) {
			if(ens.getPhoto() == null || ens.getPhoto().equals("")) {
				ens.setPhoto("/images/ens.jpg");
			}
			
		}
		return lE;
	}

	@Override
	public Enseignant checkPhoto(Enseignant ens) {
		// TODO Auto-generated method stub
		if(ens.getPhoto() == null || ens.getPhoto().equals("")) {
			ens.setPhoto("/images/ens.jpg");
		}
		return ens;
	}

	@Override
	public List<Enseignant> findEnseignantByNom(String nom) {
		// TODO Auto-generated method stub
		List<Enseignant> lE = eR.findByNomStartingWith(nom);
		if(lE.size() == 1) {
			Enseignant e = lE.get(0);
			checkPhoto(e);
		} else {
			checkPhoto(lE);
		}
		
		return lE;
	}
}
