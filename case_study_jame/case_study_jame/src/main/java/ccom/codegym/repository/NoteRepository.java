package ccom.codegym.repository;

import ccom.codegym.entity.Note;
import ccom.codegym.entity.NoteType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository<Note, Long> {
    Page<Note> findByTitleContaining(String string, Pageable pageable);
    Page<Note> findByTitleContainingAndAndNoteType_NameContaining(String input_01, String input_02, Pageable pageable);
    Iterable<Note> findByNoteType(NoteType noteType);
}
