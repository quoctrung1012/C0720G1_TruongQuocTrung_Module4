package ccom.codegym.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "note")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 11)
    private Long id;

    private String title;

    @Column(columnDefinition = "TEXT")
    private String content;

    @ManyToOne
    @JoinColumn(name = "note_type_id", referencedColumnName = "id")
    private NoteType noteType;

    public String getShortWord(){
        if(this.content.length()>30) {
            return this.content.substring(0,30).concat("......");
        } else {
            return this.content;
        }
    }
}
