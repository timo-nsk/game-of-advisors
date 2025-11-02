package com.goa.domain.model;

import com.goa.adapter.db.dao.BetreuerDao;
import com.goa.adapter.db.impl.BetreuerRepositoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@DataJpaTest
@ActiveProfiles("test")
public class BetreuerRepositoryTest {

	@Autowired
	BetreuerDao betreuerDao;

	private BetreuerRepository betreuerRepository;

	@BeforeEach
	void setUp() {
		this.betreuerRepository = new BetreuerRepositoryImpl(betreuerDao);
	}

	@Test
	@DisplayName("Ein Betreuer wird erfolgreich in der Datenbank gespeichert")
	void test1() {
		Datei datei = new Datei(null, "Max Mustermann", LocalDateTime.now(), "Titel", "Beschreibung");
		Set<Datei> dateien = Set.of(datei);

		Set<String> fachgebiete = Set.of("Informatik", "Mathematik");
		Set<Thema> themaSet1 = Set.of(new Thema(
				"Thema A",
				"cooles thema a",
				Set.of(), Set.of(), Set.of(), Set.of()
		));
		Betreuer b = new Betreuer("Max Mustermann", "max@mustermann.de", fachgebiete, dateien, themaSet1);

		assertDoesNotThrow(() -> {
			betreuerRepository.save(b);
		});
	}

	@Test
	@DisplayName("Ein Betreuer wird anhand seiner Id erfolgreich aus der Datenbank geholt")
	void test2() {
		Datei datei = new Datei(null, "Max Mustermann", LocalDateTime.now(), "Titel", "Beschreibung");
		Set<Datei> dateien = Set.of(datei);

		Set<Thema> themaSet1 = Set.of(new Thema(
				"Thema A",
				"cooles thema a",
				Set.of(), Set.of(), Set.of(), Set.of()
		));
		Set<String> fachgebiete = Set.of("Informatik", "Mathematik");
		Betreuer b = new Betreuer("Max Mustermann", "max@mustermann.de", fachgebiete, dateien, themaSet1);
		betreuerRepository.save(b);

		Betreuer found = betreuerRepository.findByBetreuerId(2L);

		assertThat(found).isNotNull();
		assertThat(found.getName()).isEqualTo("Max Mustermann");
		assertThat(found.getFachgebiete().contains("Informatik")).isTrue();
	}

	@Test
	@DisplayName("Alle Betreuer werden aus der Datenbank geholt")
	void test3() {
		Datei datei = new Datei(null, "Max Mustermann", LocalDateTime.now(), "Titel", "Beschreibung");
		Set<Datei> dateien = Set.of(datei);

		Set<String> fachgebiete1 = Set.of("Informatik", "Mathematik");
		Set<String> fachgebiete2 = Set.of("Informatik", "Mathematik", "Biologie");
		Set<Thema> themaSet1 = Set.of(new Thema(
				"Thema A",
				"cooles thema a",
				Set.of(), Set.of(), Set.of(), Set.of()
		));
		Set<Thema> themaSet2 = Set.of(new Thema(
				"Thema B",
				"cooles thema b",
				Set.of(), Set.of(), Set.of(), Set.of()
		));
		Betreuer b1 = new Betreuer("Max Mustermann", "max@mustermann.de", fachgebiete1, dateien, themaSet1);
		Betreuer b2 = new Betreuer("Petra Musterfrau", "petra@musterfrau.de", fachgebiete2, dateien, themaSet2);
		betreuerRepository.save(b1);
		betreuerRepository.save(b2);

		List<Betreuer> found = betreuerRepository.findAll();

		assertThat(found).hasSize(3);
	}

	@Sql("init_inserts_inti_database.sql")
	@Test
	@DisplayName("Für eine Match-Anfrage werden aus der Datenbank passende Results gefunden")
	void test4() {
		Set<Veranstaltung> anforderungenGewuenscht = Set.of(Veranstaltung.PROGRAMMIERUNG);
		Set<String> fachgebieteGewuenscht = Set.of("Programmierung", "Algorithmen");

		List<Betreuer> actual = betreuerRepository.findByFachgebieteOderAnforderungen(fachgebieteGewuenscht, anforderungenGewuenscht);

		assertThat(actual).hasSize(9);
	}

}
