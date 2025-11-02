package com.goa;

import com.goa.domain.model.Datei;
import com.goa.domain.model.Link;
import com.goa.domain.model.Thema;
import com.goa.domain.model.Veranstaltung;

import java.time.LocalDateTime;
import java.util.Set;

public class ThemaMother {

	public static Thema initDefaultThema() {
		Set<Veranstaltung> anforderungen = Set.of(Veranstaltung.PROGRAMMIERUNG);
		Set<String> fachgebiete = Set.of("Informatik", "Softwareentwicklung");
		Set<Link> links = Set.of(new Link("http://example.com", "Beispiel Link"));
		Datei datei = new Datei(null, "Max Mustermann", LocalDateTime.now(), "Titel", "Beschreibung");
		Set<Datei> dateien = Set.of(datei);
		return new Thema("Titel1", "Beschreibung1", anforderungen, fachgebiete, links, dateien);
	}
}
