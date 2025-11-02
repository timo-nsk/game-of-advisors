package com.goa.application.service;

import com.goa.adapter.db.dto.BetreuerDto;
import com.goa.adapter.db.impl.BetreuerRepositoryImpl;
import com.goa.domain.model.Thema;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ThemaErstellenService {
	private final BetreuerRepositoryImpl betreuerRepository;

	private final Logger logger = LoggerFactory.getLogger(ThemaErstellenService.class);

	public ThemaErstellenService(BetreuerRepositoryImpl betreuerRepository) {
		this.betreuerRepository = betreuerRepository;
	}

	@Transactional
	public void saveThema(Thema t, Long betreuerId) {
		BetreuerDto b = betreuerRepository.findDtoByBetreuerId(betreuerId);
		b.themaHinzufügen(t);
		logger.info("Thema hinzugefügt zu Betreuer: " + b);
	}
}
