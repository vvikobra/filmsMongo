package com.mongo.films.models;

import java.io.Serializable;

public class FilmDTO implements Serializable {
    private String id;
    private String name;
    private double rating;
    private String starring;
    private String genre;
    private String country;
    private int runningTime;

    public FilmDTO(String id, String name, double rating, String starring, String genre, String country, int runningTime) {
        this.id = id;
        this.name = name;
        this.rating = rating;
        this.starring = starring;
        this.genre = genre;
        this.country = country;
        this.runningTime = runningTime;
    }

    public FilmDTO() {}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getStarring() {
        return starring;
    }

    public void setStarring(String starring) {
        this.starring = starring;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getRunningTime() {
        return runningTime;
    }

    public void setRunningTime(int runningTime) {
        this.runningTime = runningTime;
    }
}