package be.ibizz.bluenote;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface NotesRepository extends MongoRepository<Note, Long> { 

}
