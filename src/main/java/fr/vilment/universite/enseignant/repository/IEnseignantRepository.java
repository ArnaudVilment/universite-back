package fr.vilment.universite.enseignant.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import fr.vilment.universite.enseignant.domain.Enseignant;

@Repository
public interface IEnseignantRepository extends JpaRepository<Enseignant, Integer> {

	public List<Enseignant> findAllByOrderByNom();
	public List<Enseignant> findAllByOrderByNomDesc();
	@Query(value="select * from t_enseignant where nom like :nom%", nativeQuery=true)
	public List<Enseignant> findEnseignantByNom(@Param("nom") String nom);
	
}
