package com.fly.model;

import javax.persistence.*;

/**
 * Created by user on 28/11/2019.
 */

@Entity
public class PdfContent extends Content {

    private String author;

    @ManyToOne
    private Channel channel;

    public PdfContent() {
        super(0f);
    }

    public PdfContent(float rating) {
        super(rating);
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
