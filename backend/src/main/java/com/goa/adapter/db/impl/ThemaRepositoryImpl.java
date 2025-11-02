package com.goa.adapter.db.impl;

import com.goa.adapter.db.dao.ThemaDao;
import com.goa.adapter.db.dto.ThemaDto;
import com.goa.adapter.db.mapper.ThemaMapper;
import com.goa.domain.model.Thema;
import com.goa.domain.model.ThemaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ThemaRepositoryImpl implements ThemaRepository {

	private final ThemaDao themaDao;

	public ThemaRepositoryImpl(ThemaDao themaDao) {
		this.themaDao = themaDao;
	}

	@Override
	public void save(Thema thema) {
		ThemaDto themaDto = ThemaMapper.toDto(thema);
		ThemaDto saved = themaDao.save(themaDto);

		if(saved.getThemaId() == null) {
			throw new RuntimeException("Fehler beim Speichern des Themas");
		}
	}

	@Override
	public Thema findByThemaId(Long themaId) {
		ThemaDto dto = themaDao.findByThemaId(themaId);
		return ThemaMapper.toEntity(dto);
	}

	@Override
	public List<Thema> findAll() {
		return themaDao.findAll().stream().map(ThemaMapper::toEntity).collect(Collectors.toList());
	}
}
