package com.mongo.films.services;

import com.mongo.films.models.FilmDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface FilmService {
    long countFilms();
    void createFilm(FilmDTO film);
    FilmDTO getFilm(String id);
    List<FilmDTO> getAllFilms();
    Page<FilmDTO> getFilms(Pageable pageable);
    void deleteFilm(String id);
    void deleteAllFilms();
    FilmDTO updateFilmRating(String id, double rating);
    Page<FilmDTO> findFilmWithRunningTimeGreater(int runningTime, Pageable pageable);
}