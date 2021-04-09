package com.synclab.cinemamultisala.service;

import java.util.List;

import com.synclab.cinemamultisala.entity.PostoASedere;
import com.synclab.cinemamultisala.entity.IdPosto;

public interface PostoASedereService {
	
	public List<PostoASedere> getPosti();
	
	public PostoASedere getPosto(IdPosto idPosto);
	
	public void salvaPosto(PostoASedere posto);
	
	public void eliminaPosto(IdPosto idPosto);
}
