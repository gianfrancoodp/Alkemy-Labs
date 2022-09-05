package com.alkemy.disneyapi.entities;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "movies")
@Getter
@Setter
@SQLDelete(sql = "UPDATE movies SET deleted = true WHERE movie_id=?") //TODO: Revisar esta Query
@Where(clause = "deleted=false")
public class MovieEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movie_id", nullable = false)
    private Long movieId;

    @Column(nullable = false)
    private String title;

    @Column(name = "creation_date")
    //TODO: @DateTimeFormat(pattern = "yyyy/MM/dd") NO FUNCIONA PARA EL JSON, ARREGLAR!!!
    //TODO: @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd") NO FUNCIONA PARA EL JSON, ARREGLAR!!!
    //TODO: @JsonFormat(pattern="yyyy/MM/dd") NO FUNCIONA PARA EL JSON, ARREGLAR!!!
    private Date creationDate;

    @Range(min = 1, max = 5)
    private Integer rating;

    private String image;

    private boolean deleted = Boolean.FALSE;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "characters_movies", joinColumns = @JoinColumn(name = "movie_id"), inverseJoinColumns = @JoinColumn(name = "character_id"))
    //@Column(nullable = false)
    private Set<CharacterEntity> characters = new HashSet<>();

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "genre_id", insertable = false, updatable = false)
    private GenreEntity genre;
}