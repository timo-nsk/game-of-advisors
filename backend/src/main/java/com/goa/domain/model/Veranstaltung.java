package com.goa.domain.model;

import java.util.EnumMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Veranstaltung {
	COMPILERBAU("Compilerbau"),
	PROGRAMMIERUNG("Programmierung"),
	RECHNERARCHITEKTUR("Rechnerarchitektur"),
	ALGORITHMEN_UND_DATENSTRUKTUREN("Algorithmen und Datenstrukturen"),
	MATHEMATIK_FÜR_INFORMATIKER_1("Mathematik für Informatiker 1"),
	MATHEMATIK_FÜR_INFORMATIKER_2("Mathematik für Informatiker 2"),
	MATHEMATIK_FÜR_INFORMATIKER_3("Mathematik für Informatiker 3");

	private final String displayName;

	Veranstaltung(String displayName) {
		this.displayName = displayName;
	}

	public String getDisplayName() {
		return displayName;
	}

	public static final Map<Veranstaltung, String> MAP =
			Stream.of(values())
					.collect(Collectors.toMap(v -> v, Veranstaltung::getDisplayName));

}

