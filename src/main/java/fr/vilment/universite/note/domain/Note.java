package fr.vilment.universite.note.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import fr.vilment.universite.etudiant.domain.Etudiant;
import fr.vilment.universite.matiere.domain.Matiere;

@Entity
@Table(name = "T_NOTE")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Note implements Serializable {

	@EmbeddedId
    private NotePK notePK;
	
	@Column(name = "NOTE")
	private Double note;
	
	@ManyToOne
	@JoinColumn(name = "ID_ETUDIANT", insertable=false, updatable=false)
	private Etudiant etudiant;
	
	@ManyToOne
	@JoinColumn(name = "ID_MATIERE", insertable=false, updatable=false)
	private Matiere matiere;
	
	public NotePK getNotePK() {
		return notePK;
	}
	public void setNotePK(NotePK notePK) {
		this.notePK = notePK;
	}
	public Double getNote() {
		return note;
	}
	public void setNote(Double note) {
		this.note = note;
	}
	public Etudiant getEtudiant() {
		return etudiant;
	}
	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}
	public Matiere getMatiere() {
		return matiere;
	}
	public void setMatiere(Matiere matiere) {
		this.matiere = matiere;
	}
}
