package com.mongo.films.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "films")
@CompoundIndex(def = "{'country':1, 'genre':-1}")
public class Film {
    private String id;
    private String name;
    private double rating;
    private List<String> starring;
    private List<String> genre;
    private String country;
    private int runningTime;

    protected Film() {
    }

    public Film(String id, String name, double rating, List<String> starring, List<String> genre, String country, int runningTime) {
        this.id = id;
        this.name = name;
        this.rating = rating;
        this.starring = starring;
        this.genre = genre;
        this.country = country;
        this.runningTime = runningTime;
    }

    @Id
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

    public List<String> getStarring() {
        return starring;
    }

    public void setStarring(List<String> starring) {
        this.starring = starring;
    }

    public List<String> getGenre() {
        return genre;
    }

    public void setGenre(List<String> genre) {
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