package fr.vilment.universite.note.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;

import fr.vilment.universite.note.domain.Note;

public interface INoteController {

	public List<Note> finAll();
	public Note selectNote(@PathVariable int id_etudiant, @PathVariable int id_matiere);
	public Note save(Note note);
}
