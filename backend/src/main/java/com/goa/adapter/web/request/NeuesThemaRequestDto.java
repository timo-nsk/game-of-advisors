package com.goa.adapter.web.request;

import com.goa.domain.model.Link;
import com.goa.domain.model.Thema;
import com.goa.domain.model.Veranstaltung;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public record NeuesThemaRequestDto(
		 String titel,
		 String beschreibung,
		 List<Veranstaltung> anforderungen,
		 String fachgebiet,
		 List<Link> links
) {
	public Thema toEntity() {

		return new Thema(titel, beschreibung, new HashSet<>(anforderungen), getFachgebiete(), new HashSet<>(links), Set.of());
	}

	private Set<String> getFachgebiete() {
		String[] fachgebiete = fachgebiet.split(",");
		return new HashSet<>(List.of(fachgebiete));
	}
}
