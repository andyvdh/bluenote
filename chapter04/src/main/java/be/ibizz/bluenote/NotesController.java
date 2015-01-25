package be.ibizz.bluenote;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notes")
public class NotesController {
	
	@Autowired
	private NotesRepository notesRepository;
	
	@RequestMapping
	public List<Note> list() {
		return notesRepository.findAll();
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public Note add(@RequestBody final Note note) {
		notesRepository.save(note);
		return note;
	}
	
}
