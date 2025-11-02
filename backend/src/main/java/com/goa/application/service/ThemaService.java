package com.goa.application.service;

import com.goa.domain.model.Thema;
import com.goa.domain.model.ThemaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ThemaService {

	private final ThemaRepository themaRepository;

	public ThemaService(ThemaRepository themaRepository) {
		this.themaRepository = themaRepository;
	}

	public List<Thema> findAll() {
		return themaRepository.findAll();
	}

	public void save(Thema entity) {
		themaRepository.save(entity);
	}
}
