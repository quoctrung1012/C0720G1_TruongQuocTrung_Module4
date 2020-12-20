package ccom.codegym.service.note;

import ccom.codegym.entity.Note;
import ccom.codegym.entity.NoteType;
import ccom.codegym.service.generic.ServiceGeneric;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface NoteService extends ServiceGeneric<Note> {
    Page<Note> findByTitleContainingAndAndNoteType_NameContaining(String input_01, String input_02, Pageable pageable);
    Iterable<Note> findByNoteType(NoteType noteType);
}
