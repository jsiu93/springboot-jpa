package com.xzh.repository;

import com.xzh.pojo.Film;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmRepository extends JpaRepository<Film, String> {

    

}
