package com.synclab.cinemamultisala.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.synclab.cinemamultisala.dao.PostoASedereRepository;
import com.synclab.cinemamultisala.entity.IdPosto;
import com.synclab.cinemamultisala.entity.PostoASedere;

@Service
public class PostoASedereImpl implements PostoASedereService {

	@Autowired
	PostoASedereRepository postoASedereRepository;
	
	@Override
	public List<PostoASedere> getPosti() {
		return postoASedereRepository.findAll();
	}

	@Override
	public PostoASedere getPosto(IdPosto idPosto) {
		Optional<PostoASedere> result = postoASedereRepository.findById(idPosto);
		
		PostoASedere posto = null;
		if (result.isPresent())
			posto = result.get();
		else {
			throw new RuntimeException("Posto a sedere non trovato per idPosto - " + idPosto);
		}
		
		return posto;
	}

	@Override
	public void salvaPosto(PostoASedere posto) {
		postoASedereRepository.save(posto);
	}

	@Override
	public void eliminaPosto(IdPosto idPosto) {
		postoASedereRepository.deleteById(idPosto);
	}

}
