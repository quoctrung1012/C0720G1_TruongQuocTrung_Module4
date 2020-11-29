package com.codegym.blog_manager.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "blog")
@Data //Khởi tạo getter, setter
@NoArgsConstructor //constructor ko đối số
@AllArgsConstructor // constructor có đối số
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    @Column(columnDefinition = "LONGTEXT")
    private String content;
    private String author;
    private String introduce;
    @Column(name = "data_update", columnDefinition = "DATE")
    private String dateUpdate;
}
