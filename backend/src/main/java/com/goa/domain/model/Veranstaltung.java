package com.goa.domain.model;

import java.util.EnumMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Veranstaltung {
	COMPILERBAU("Compilerbau"),
	PROGRAMMIERUNG("Programmierung"),
	RECHNERARCHITEKTUR("Rechnerarchitektur"),
	ALGORITHMEN_UND_DATENSTRUKTUREN("Algorithmen und Datenstrukturen");

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

