package com.synclab.cinemamultisala.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.synclab.cinemamultisala.entity.Prenotazione;

public interface PrenotazioneRepository extends JpaRepository<Prenotazione, Integer> {

}
