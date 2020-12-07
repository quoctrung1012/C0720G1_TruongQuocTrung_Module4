package com.codegym.entity;

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
    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Category category;

    public String getShortWord(){
        if(this.introduce.length()>30) {
            return this.introduce.substring(0,30).concat("......");
        } else {
            return this.introduce;
        }
    }
}
