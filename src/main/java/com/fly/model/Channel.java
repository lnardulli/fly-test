package com.fly.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="channel")
public class Channel  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String language;
    private String picture;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "subchannel_id", nullable = true)
    private List<Channel> subchannel;

    @OneToMany(cascade=CascadeType.ALL)
    private List<Content> contents;

    public Channel() {
    }

    public Channel(String title, String language, String picture) {
        this.title = title;
        this.language = language;
        this.picture = picture;
    }

    public Channel(String title, String language, String picture, List<Channel> subchannel) {
        this.title = title;
        this.language = language;
        this.picture = picture;
        this.subchannel = subchannel;
        //this.contentList = contentList;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    //@OneToOne(cascade = CascadeType.ALL, mappedBy="subchannel_id")
    public List<Channel> getSubchannel() {
        return subchannel;
    }

    public void setSubchannel(List<Channel> subchannel) {
        this.subchannel = subchannel;
    }

    public List<Content> getContentList() {
        return contents;
    }

    public void setContentList(List<Content> contentList) {
        this.contents = contentList;
    }

    @Override
    public String toString() {
        return "Channel{" +
                "title='" + title + '\'' +
                ", language='" + language + '\'' +
                ", picture='" + picture + '\'' +
                ", subchannel=" + subchannel +
                ", contentList=" + contents +
                '}';
    }
}
