package com.synclab.cinemamultisala.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.synclab.cinemamultisala.entity.Prenotazione;

public interface PrenotazioneRepository extends JpaRepository<Prenotazione, Integer> {

}
