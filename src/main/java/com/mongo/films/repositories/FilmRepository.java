package com.mongo.films.repositories;

import com.mongo.films.models.Film;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmRepository extends MongoRepository<Film, String> {

    @Query("{ 'running_time': { $gte: ?0 } }")
    Page<Film> findFilmWithRunningTimeGreater(double runningTime, Pageable pageable);

}
