package fr.vilment.universite.etudiant.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import fr.vilment.universite.etudiant.domain.Etudiant;

@Repository
public interface IEtudiantRepository extends JpaRepository<Etudiant, Integer> {

	public List<fr.vilment.universite.etudiant.domain.Etudiant> findAllByOrderByNom();
	public List<Etudiant> findAllByOrderByNomDesc();
	@Query(value="select * from t_etudiant where nom like :nom%", nativeQuery=true)
	public List<Etudiant> findEtudiantByNom(@Param("nom") String nom);
}
