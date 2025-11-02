package com.goa.domain.model;

import com.goa.ThemaMother;
import com.goa.adapter.db.dao.ThemaDao;
import com.goa.adapter.db.impl.ThemaRepositoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@DataJpaTest
public class ThemaRepositoryTest {

	@Autowired
	ThemaDao themaDao;

	ThemaRepository themaRepository;

	@BeforeEach
	void setUp() {
		themaRepository = new ThemaRepositoryImpl(themaDao);
	}

	@Test
	@DisplayName("Ein Thema wird erfolgreich in der Datenbank gespeichert")
	void test1() {
		Thema t = ThemaMother.initDefaultThema();
		assertDoesNotThrow(() -> {
			themaRepository.save(t);
		});
	}

	@Test
	@DisplayName("Ein Thema wird anhand seiner Id erfolgreich aus der Datenbank geholt")
	void test2() {
		Thema t = ThemaMother.initDefaultThema();
		themaRepository.save(t);

		Thema found = themaRepository.findByThemaId(1L);

		assertThat(found.getTitel()).isEqualTo("Titel1");
		assertThat(found.getFachgebiete().contains("Informatik")).isTrue();
	}

}
