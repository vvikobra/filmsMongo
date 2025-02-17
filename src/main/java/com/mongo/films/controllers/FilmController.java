package com.mongo.films.controllers;

import com.mongo.films.models.FilmDTO;
import com.mongo.films.services.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@EnableCaching
public class FilmController {
    private FilmService filmService;

    @Autowired
    public void setFilmService(FilmService filmService) {
        this.filmService = filmService;
    }

    @GetMapping("/films/all")
    @ResponseBody
    public List<FilmDTO> getAllFilms() {
        return filmService.getAllFilms();
    }

    @GetMapping("/films")
    @ResponseBody
    public Page<FilmDTO> getFilmsPage(@RequestParam(defaultValue = "0") Integer offset,
                                   @RequestParam(defaultValue = "10") Integer limit) {
        return filmService.getFilms(PageRequest.of(offset, limit));
    }

    @GetMapping("/films/running_time/{runningTime}")
    @ResponseBody
    public Page<FilmDTO> getFilmsWithRunningTime(@PathVariable Integer runningTime,
                                              @RequestParam(defaultValue = "0") Integer offset,
                                              @RequestParam(defaultValue = "10") Integer limit) {
        return filmService.findFilmWithRunningTimeGreater(runningTime, PageRequest.of(offset, limit));
    }

    @GetMapping("/films/{id}")
    @ResponseBody
    public FilmDTO getFilm(@PathVariable String id) {
        return filmService.getFilm(id);
    }

    @PostMapping("/films")
    public void postFilm(@RequestBody FilmDTO film) {
        filmService.createFilm(film);
    }

    @DeleteMapping("/films/all")
    public void deleteAllFilms() {
        filmService.deleteAllFilms();
    }

    @DeleteMapping("/films/{id}")
    public void deleteFilm(@PathVariable String id) {
        filmService.deleteFilm(id);
    }

    @PutMapping("/films/{id}")
    public FilmDTO putBook(@RequestBody FilmDTO newFilm, @PathVariable String id) {
        newFilm.setId(id);
        filmService.createFilm(newFilm);
        return newFilm;
    }

    @PutMapping("/films/rating/{id}/{rating}")
    public FilmDTO updateRating(@PathVariable String id,
                             @PathVariable double rating) {
        return filmService.updateFilmRating(id, rating);
    }
}
