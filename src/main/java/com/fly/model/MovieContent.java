package com.fly.model;

import javax.persistence.*;

@Entity
public class MovieContent extends Content {

    String autor;
    String director;

    @ManyToOne
    private Channel channel;

    public MovieContent() {
        super(0f);
    }

    public MovieContent(float rating, String autor, String director) {
        super(rating);
        this.autor = autor;
        this.director = director;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }
}
