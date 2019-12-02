package com.fly.model;

import javax.persistence.*;

/**
 * Created by user on 28/11/2019.
 */

@Entity
@PrimaryKeyJoinColumn(name="content_id")
public class TextContent extends Content {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public TextContent() {
        super(0f);
    }

    public TextContent(float rating) {
        super(rating);
    }
}
