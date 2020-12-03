package com.codegym.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.Set;

@Entity(name = "book")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
//    @NotBlank(message = "Please input, not empty")
//    @Pattern(regexp = "(^$[A-Z][a-z]+(\\s[A-Z][a-z]*)*)", message = "Please input character without accents")
    private String name;
//    @NotBlank(message = "Please input, not empty")
//    @Pattern(regexp = "(^$[A-Z][a-z]+(\\s[A-Z][a-z]*)*)", message = "Please input character without accents")
    private String author;
//    @NotBlank(message = "Please input, not empty")
//    @Pattern(regexp = "(^$|[0-9]*$)", message = "Please input numeric !!!")
    private Integer quality;

    @ManyToMany(mappedBy = "likedBooks")
    @JsonBackReference
    private Set<BorrowCard> borrowCard;

}
