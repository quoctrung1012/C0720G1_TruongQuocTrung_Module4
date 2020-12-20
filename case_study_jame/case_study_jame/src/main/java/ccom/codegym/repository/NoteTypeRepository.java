package ccom.codegym.repository;

import ccom.codegym.entity.NoteType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteTypeRepository extends JpaRepository<NoteType, Long> {
}
