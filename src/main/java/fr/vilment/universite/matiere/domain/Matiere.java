package fr.vilment.universite.matiere.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import fr.vilment.universite.enseignant.domain.Enseignant;
import fr.vilment.universite.note.domain.Note;

@Entity
@Table(name = "T_MATIERE")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Matiere implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;
	@Column(name = "NUMERO_MATIERE")
	private int numero_matiere;
	@Column(name = "NOM")
	private String nom;
	@Column(name = "COEF")
	private int coef;
	
	@ManyToOne
	@JoinColumn(name = "ID_ENSEIGNANT", insertable=true, updatable=true)
	private Enseignant enseignant;
	
	@OneToMany(mappedBy="matiere")
	private List<Note> listNote;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNumero_matiere() {
		return numero_matiere;
	}
	public void setNumero_matiere(int numero_matiere) {
		this.numero_matiere = numero_matiere;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getCoef() {
		return coef;
	}
	public void setCoef(int coef) {
		this.coef = coef;
	}
	public Enseignant getEnseignant() {
		return enseignant;
	}
	public void setEnseignant(Enseignant enseignant) {
		this.enseignant = enseignant;
	}
}
