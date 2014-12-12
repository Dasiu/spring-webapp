package com.webapp.repository;

import com.icupad.repository.BaseRepository;
import com.webapp.domain.Movie;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends BaseRepository<Movie, Long>, MovieCustomRepository {
}
