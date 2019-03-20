package fr.vilment.universite.matiere.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import fr.vilment.universite.matiere.domain.Matiere;

@Repository
public interface IMatiereRepository extends JpaRepository<Matiere, Integer> {

	public List<Matiere> findAllByOrderByNom();
	public List<Matiere> findAllByOrderByNomDesc();	
	public List<Matiere> findMatiereByNomStartingWith(String nom);
	
	@Query(value="select * from t_matiere where id_enseignant != :id_enseignant or id_enseignant is null", nativeQuery=true)
	public List<Matiere> findAllMatiereNonEns(@Param("id_enseignant") int id_enseignant);
	
	@Query(value="select * from t_matiere where id_enseignant = :id_enseignant or id_enseignant is null", nativeQuery=true)
	public List<Matiere> findAllMatiereEns(@Param("id_enseignant") int id_enseignant);
}
