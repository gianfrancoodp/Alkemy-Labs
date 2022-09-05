package com.alkemy.disneyapi.entities;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "genres")
@Getter
@Setter
@SQLDelete(sql = "UPDATE genres SET deleted = true WHERE genre_id=?")
@Where(clause = "deleted=false")
public class GenreEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "genre_id", nullable = false)
    private Long genreId;

    @Column(nullable = false)
    private String name;

    private String image;

    private boolean deleted = Boolean.FALSE;

    @OneToMany(mappedBy = "genre")
    private Set<MovieEntity> movies;
}