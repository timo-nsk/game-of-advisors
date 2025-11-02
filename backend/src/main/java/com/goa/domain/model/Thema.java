package com.goa.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Thema {
	private String titel;
	private String beschreibung;
	private Set<Veranstaltung> anforderungen;
	private Set<String> fachgebiete;
	private Set<Link> links;
	private Set<Datei> dateien;
}
