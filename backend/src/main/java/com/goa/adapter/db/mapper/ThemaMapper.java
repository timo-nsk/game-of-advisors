package com.goa.adapter.db.mapper;

import com.goa.adapter.db.dto.DateiDto;
import com.goa.adapter.db.dto.LinkDto;
import com.goa.adapter.db.dto.ThemaDto;
import com.goa.domain.model.Datei;
import com.goa.domain.model.Link;
import com.goa.domain.model.Thema;

import java.util.Set;
import java.util.stream.Collectors;

public class ThemaMapper {

	public static ThemaDto toDto(Thema thema) {
		if (thema == null) {
			return null;
		}

		ThemaDto dto = new ThemaDto();
		dto.setTitel(thema.getTitel());
		dto.setBeschreibung(thema.getBeschreibung());
		dto.setAnforderungen(thema.getAnforderungen());
		dto.setFachgebiete(thema.getFachgebiete());
		Set<LinkDto> links = thema.getLinks().stream().map(LinkMapper::toDto).collect(Collectors.toSet());
		dto.setLinks(links);
		Set<DateiDto> dateien = thema.getDateien().stream().map(DateiMapper::toDto).collect(Collectors.toSet());
		dto.setDateien(dateien);

		return dto;
	}

	public static  Thema toEntity(ThemaDto dto) {
		if (dto == null) {
			return null;
		}

		Thema thema = new Thema();
		thema.setTitel(dto.getTitel());
		thema.setBeschreibung(dto.getBeschreibung());
		thema.setAnforderungen(dto.getAnforderungen());
		thema.setFachgebiete(dto.getFachgebiete());
		Set<Link> links = dto.getLinks().stream().map(LinkMapper::toEntity).collect(Collectors.toSet());
		thema.setLinks(links);
		Set<Datei> dateien = dto.getDateien().stream().map(DateiMapper::toEntity).collect(Collectors.toSet());
		thema.setDateien(dateien);

		return thema;
	}
}
