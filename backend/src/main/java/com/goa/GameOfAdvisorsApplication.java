package com.goa;

import com.github.javafaker.Faker;
import com.goa.adapter.db.dao.BetreuerDao;
import com.goa.adapter.db.impl.BetreuerRepositoryImpl;
import com.goa.domain.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

@SpringBootApplication
public class GameOfAdvisorsApplication {

	@Value("${dummy-data.enable}")
	String withDummyDb;

	@Value("${dummy-data.sample-size}")
	String SAMPLE_SIZE;

	@Autowired
	BetreuerDao betreuerDao;

	BetreuerRepository betreuerRepository;

	Logger logger = LoggerFactory.getLogger(GameOfAdvisorsApplication.class);



	public static void main(String[] args) {
		SpringApplication.run(GameOfAdvisorsApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {
			BetreuerRepository repo = new BetreuerRepositoryImpl(betreuerDao);
			Betreuer b1 = new Betreuer("Timo Neske", "timo@neske.de", Set.of(), Set.of(), Set.of());
			repo.save(b1);

			if(Boolean.valueOf(withDummyDb)) {
				Faker faker = new Faker();
				String[] fachgebiete = {"Informatik", "Mathematik", "Chemie", "Biologie", "Psychologie", "Medizin", "Philosophie"};

				for(int i = 1; i < Integer.parseInt(SAMPLE_SIZE); i++) {
					int randomIndex = ThreadLocalRandom.current().nextInt(fachgebiete.length);
					String firstName = faker.name().firstName();
					String lastName = faker.name().lastName();
					String fullname = firstName + " " + lastName;
					String email = firstName + "." + lastName + "@gmail.com";

					Datei datei = new Datei(null, fullname, LocalDateTime.now(), "Ne Datei", "Ist halt ne Datei");
					Set<Datei> dateien = Set.of(datei);

					Set<Thema> themaSet = Set.of(
							new Thema(
									"Thema " + i,
									"auch cooles thema",
									Set.of(Veranstaltung.ALGORITHMEN_UND_DATENSTRUKTUREN), Set.of("Informatik"), Set.of(new Link("https://www.google.com/", "Google")), Set.of(datei)
							),
							new Thema(
									"Thema " + (i+1),
									"cooles thema c",
									Set.of(Veranstaltung.COMPILERBAU), Set.of("Informatik"), Set.of(new Link("https://www.google.com/", "Google")), Set.of(datei)
							));

					Set<String> fachgebiete1 = Set.of(fachgebiete[randomIndex]);
					Betreuer b = new Betreuer(fullname, email, fachgebiete1, dateien, themaSet);
					repo.save(b);
				}
				logger.info("Application started with dummy db: " + withDummyDb.toUpperCase());
			}

		};
	}



}
