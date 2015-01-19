package be.ibizz.bluenote;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notes")
public class NotesController {

	private List<Note> notes = new ArrayList<Note>();
	
	@RequestMapping
	public List<Note> list() {
		return notes;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public Note add(@RequestBody final Note note) {
		notes.add(note);
		return note;
	}

}
