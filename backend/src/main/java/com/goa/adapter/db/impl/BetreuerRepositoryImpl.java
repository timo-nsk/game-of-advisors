package com.goa.adapter.db.impl;

import com.goa.adapter.db.dao.BetreuerDao;
import com.goa.adapter.db.dto.BetreuerDto;
import com.goa.adapter.db.mapper.BetreuerMapper;
import com.goa.domain.model.Betreuer;
import com.goa.domain.model.BetreuerRepository;
import com.goa.domain.model.Veranstaltung;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Repository
public class BetreuerRepositoryImpl implements BetreuerRepository {

	private BetreuerDao betreuerDao;

	public BetreuerRepositoryImpl(BetreuerDao betreuerDao) {
		this.betreuerDao = betreuerDao;
	}

	@Override
	public void save(Betreuer betreuer) {
		BetreuerDto dto = BetreuerMapper.toDto(betreuer);
		BetreuerDto savedDto = betreuerDao.save(dto);

		if(savedDto.getBetreuerId() == null) {
			throw new RuntimeException("Fehler beim Speichern des Betreuers");
		}

	}

	@Override
	public Betreuer findByBetreuerId(Long betreuerId) {
		BetreuerDto dto = betreuerDao.findByBetreuerId(betreuerId);
		return BetreuerMapper.toEntity(dto);
	}

	public BetreuerDto findDtoByBetreuerId(Long betreuerId) {
		BetreuerDto dto = betreuerDao.findByBetreuerId(betreuerId);
		return dto;
	}

	@Override
	public List<Betreuer> findAll() {
		List<BetreuerDto> alleDtos = betreuerDao.findAll();
		return alleDtos.stream().map(BetreuerMapper::toEntity).collect(Collectors.toList());
	}

	@Override
	public Betreuer findByEmail(String email) {
		return BetreuerMapper.toEntity(betreuerDao.findByEmail(email));
	}

	@Override
	public List<Betreuer> findByFachgebieteOderAnforderungen(Set<String> fachgebiete, Set<Veranstaltung> anforderungen) {
		return betreuerDao.findByFachgebieteOderAnforderungen(fachgebiete, anforderungen)
				.stream().map(BetreuerMapper::toEntity).collect(Collectors.toList());
	}
}
