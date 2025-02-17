package com.mongo.films.services;

import com.mongo.films.Mapper;
import com.mongo.films.models.Film;
import com.mongo.films.models.FilmDTO;
import com.mongo.films.repositories.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class FilmServiceImpl implements FilmService {

    private FilmRepository filmRepository;
    private final Mapper mapper;

    public FilmServiceImpl(Mapper mapper) {
        this.mapper = mapper;
    }

    @Autowired
    public void setFilmRepository(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    @Override
    public long countFilms() {
        return filmRepository.count();
    }

    @Override
    public void createFilm(FilmDTO film) {
        Film mappedFilm = mapper.mapFilmDTOToFilm(film);
        System.out.println(mappedFilm.getGenre() + mappedFilm.getCountry() + mappedFilm.getName() + mappedFilm.getStarring());
        filmRepository.save(mappedFilm);
    }

    @Override
    public FilmDTO getFilm(String id) {
        return mapper.mapFilmToFilmDTO(filmRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Фильм с id " + id + " не найден")));
    }

    @Override
    public List<FilmDTO> getAllFilms() {
        return filmRepository.findAll().stream().map(mapper::mapFilmToFilmDTO).toList();
    }

    @Override
    @Cacheable("films")
    public Page<FilmDTO> getFilms(Pageable pageable) {
        return filmRepository.findAll(pageable).map(mapper::mapFilmToFilmDTO);
    }

    @Override
    public void deleteFilm(String id) {
        filmRepository.deleteById(id);
    }

    @Override
    public void deleteAllFilms() {
        filmRepository.deleteAll();
    }

    @Override
    public FilmDTO updateFilmRating(String id, double rating) {
        Film film = filmRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Фильм с id " + id + " не найден"));
        film.setRating(rating);
        return mapper.mapFilmToFilmDTO(filmRepository.save(film));
    }

    @Override
    public Page<FilmDTO> findFilmWithRunningTimeGreater(int runningTime, Pageable pageable) {
        return filmRepository.findFilmWithRunningTimeGreater(runningTime, pageable).map(mapper::mapFilmToFilmDTO);
    }
}
