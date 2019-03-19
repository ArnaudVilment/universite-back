package fr.vilment.universite.note.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.vilment.universite.note.controller.INoteController;
import fr.vilment.universite.note.domain.Note;
import fr.vilment.universite.note.service.impl.NoteServiceImpl;

@RestController
public class NoteControllerImpl implements INoteController {

	@Autowired 
	NoteServiceImpl nS = new NoteServiceImpl();
	
	@Override
	@GetMapping("/listNote")
	public List<Note> finAll() {
		return nS.selectAll();
	}
	
	@Override
	@GetMapping("/note/{id_etudiant}/{id_matiere}")
	public Note selectNote(@PathVariable int id_etudiant, @PathVariable int id_matiere) {
		
		return nS.findOn(id_etudiant, id_matiere);
	}

	@Override
	@PostMapping("/note")
	public Note save(@RequestBody Note note) {
		Note n = nS.newNote(note);
		return n;
	}
	
	
}
