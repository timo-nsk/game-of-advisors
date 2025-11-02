package com.goa.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Betreuer {
	private String name;
	private String email;
	private Set<String> fachgebiete;
	private Set<Datei> dateien;
	private Set<Thema> themen;

	public void themaHinzufügen(Thema t) {
		themen.add(t);
	}
}
