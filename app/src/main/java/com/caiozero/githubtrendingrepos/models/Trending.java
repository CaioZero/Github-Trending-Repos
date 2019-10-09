package com.caiozero.githubtrendingrepos.models;

import android.net.Uri;

import java.util.List;

public class Trending{
    /*Informations to be recovery by API*/
    private String author;
    private String name;
    private String stars;
    private String forks;
    private String avatar;
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    private List<Developers> builtyBy;

    public List<Developers> getBuiltyBy() {
        return builtyBy;
    }

    public void setBuiltyBy(List<Developers> builtyBy) {
        this.builtyBy = builtyBy;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStars() {
        return stars;
    }

    public void setStars(String stars) {
        this.stars = stars;
    }

    public String getForks() {
        return forks;
    }

    public void setForks(String forks) {
        this.forks = forks;
    }
}
