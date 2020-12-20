package ccom.codegym.service.note;

import ccom.codegym.entity.Note;
import ccom.codegym.entity.NoteType;
import ccom.codegym.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteServiceImpl implements NoteService {
    @Autowired
    private NoteRepository noteRepository;

    @Override
    public List<Note> findAll() {
        return noteRepository.findAll();
    }

    @Override
    public Note findById(Long id) {
        return noteRepository.findById(id).orElse(null);
    }

    @Override
    public Note save(Note note) {
        return noteRepository.save(note);
    }

    @Override
    public void remove(Long id) {
        noteRepository.deleteById(id);
    }

    @Override
    public Page<Note> findPageAll(Pageable pageable) {
        return noteRepository.findAll(pageable);
    }

    @Override
    public Page<Note> searchByName(String string, Pageable pageable) {
        return noteRepository.findByTitleContaining(string, pageable);
    }

    @Override
    public Page<Note> findByTitleContainingAndAndNoteType_NameContaining(String input_01, String input_02, Pageable pageable) {
        return noteRepository.findByTitleContainingAndAndNoteType_NameContaining(input_01, input_02,pageable);
    }

    @Override
    public Iterable<Note> findByNoteType(NoteType noteType) {
        return noteRepository.findByNoteType(noteType);
    }
}
