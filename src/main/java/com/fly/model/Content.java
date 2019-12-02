package com.fly.model;

import javax.persistence.*;

@Entity
//@Inheritance(strategy=InheritanceType.JOINED)
public abstract class Content implements java.io.Serializable  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private float rating;


    public Long getId() {
        return id;
    }

    public Content(float rating) {
        this.rating = rating;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public float getRating() {
        return rating;
    }

    public float getValue() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }
}
