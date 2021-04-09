package com.synclab.cinemamultisala.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.synclab.cinemamultisala.entity.Film;
import com.synclab.cinemamultisala.entity.FilmId;

public interface FilmRepository extends JpaRepository<Film, FilmId> {

}
