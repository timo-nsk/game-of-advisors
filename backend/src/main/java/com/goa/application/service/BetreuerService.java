package com.goa.application.service;

import com.goa.domain.model.Betreuer;
import com.goa.domain.model.BetreuerRepository;
import com.goa.domain.model.Thema;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BetreuerService {

	private BetreuerRepository betreuerRepository;

	public BetreuerService(BetreuerRepository betreuerRepository) {
		this.betreuerRepository = betreuerRepository;
	}

	public List<Betreuer> findAll() {
		return betreuerRepository.findAll();
	}

	public void save(Betreuer b) {
		betreuerRepository.save(b);
	}

	public Betreuer findByBetreuerId(Long l) {
		return betreuerRepository.findByBetreuerId(l);
	}

	public Betreuer findByEmail(String email) {
		return betreuerRepository.findByEmail(email);
	}
}
