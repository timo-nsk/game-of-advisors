package com.goa.application.service;

import com.goa.domain.model.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class MatchService {

	private final BetreuerRepository betreuerRepository;

	public MatchService(BetreuerRepository betreuerRepository) {
		this.betreuerRepository = betreuerRepository;
	}


	public List<Betreuer> findMatches(Set<Veranstaltung> anforderungen, Set<String> fachgebiete) {
		return betreuerRepository.findByFachgebieteOderAnforderungen(fachgebiete, anforderungen);
	}
}
