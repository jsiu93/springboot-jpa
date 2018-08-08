package com.xzh.repository;

import com.xzh.pojo.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FilmRepository extends JpaRepository<Film, String> {

    @Query(value = "select * from film a where a.stars =?1 and a.year =?2 ", nativeQuery = true)
    List<Film> findAllByStarsAndYear(String stars, String year);

}
