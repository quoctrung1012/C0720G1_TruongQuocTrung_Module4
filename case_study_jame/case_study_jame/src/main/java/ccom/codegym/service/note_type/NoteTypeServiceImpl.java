package ccom.codegym.service.note_type;

import ccom.codegym.entity.NoteType;
import ccom.codegym.repository.NoteTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class NoteTypeServiceImpl implements NoteTypeService {
    @Autowired
    private NoteTypeRepository noteTypeRepository;
    @Override
    public List<NoteType> findAll() {
        return noteTypeRepository.findAll();
    }
}
