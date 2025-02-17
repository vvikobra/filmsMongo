package com.mongo.films;

import com.mongo.films.models.Film;
import com.mongo.films.models.FilmDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Mapper {

    public Film mapFilmDTOToFilm(FilmDTO filmDTO) {
        return new Film(filmDTO.getId(), filmDTO.getName(), filmDTO.getRating(),
                List.of(filmDTO.getGenre().split(", ")),
                List.of(filmDTO.getStarring().split(", ")),
                filmDTO.getCountry(), filmDTO.getRunningTime());
    }

    public FilmDTO mapFilmToFilmDTO(Film film) {
        return new FilmDTO(film.getId(), film.getName(), film.getRating(),
                String.join(", ", film.getGenre()), String.join(", ",
                film.getStarring()), film.getCountry(), film.getRunningTime());
    }
}
