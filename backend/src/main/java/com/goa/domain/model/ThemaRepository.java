package com.goa.domain.model;

import com.goa.adapter.db.dto.ThemaDto;

import java.util.List;

public interface ThemaRepository {
	void save(Thema thema);
	Thema findByThemaId(Long themaId);
	List<Thema> findAll();
}
