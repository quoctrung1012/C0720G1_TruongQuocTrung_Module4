package ccom.codegym.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity(name = "note_type")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NoteType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 11)
    private Long id;

    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    @OneToMany(mappedBy = "noteType", cascade = CascadeType.ALL)
    @JsonBackReference
    private List<Note> noteList;
}
