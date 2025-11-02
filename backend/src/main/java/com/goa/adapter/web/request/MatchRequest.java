package com.goa.adapter.web.request;

import com.goa.domain.model.Veranstaltung;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public record MatchRequest(
		Set<Veranstaltung> anforderungen,
		String fachgebiete
) {
	public Set<String> getFachgebiete() {
		String[] fachgebieteSplitted = fachgebiete.split(",");
		return new HashSet<>(List.of(fachgebieteSplitted));
	}
}
