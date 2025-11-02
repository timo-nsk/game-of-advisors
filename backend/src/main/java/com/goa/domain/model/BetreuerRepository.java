package com.goa.domain.model;

import java.util.List;
import java.util.Set;

public interface BetreuerRepository {
	void save(Betreuer betreuer);
	Betreuer findByBetreuerId(Long betreuerId);
	List<Betreuer> findAll();

	Betreuer findByEmail(String email);

	List<Betreuer> findByFachgebieteOderAnforderungen(Set<String> fachgebiete, Set<Veranstaltung> anforderungen);
}
