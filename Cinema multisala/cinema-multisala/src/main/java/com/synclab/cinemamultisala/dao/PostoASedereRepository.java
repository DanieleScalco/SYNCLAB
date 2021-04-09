package com.synclab.cinemamultisala.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.synclab.cinemamultisala.entity.PostoASedere;
import com.synclab.cinemamultisala.entity.IdPosto;

public interface PostoASedereRepository extends JpaRepository<PostoASedere, IdPosto> {

}
