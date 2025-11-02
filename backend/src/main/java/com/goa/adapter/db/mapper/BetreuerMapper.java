package com.goa.adapter.db.mapper;

import com.goa.adapter.db.dto.BetreuerDto;
import com.goa.adapter.db.dto.DateiDto;
import com.goa.adapter.db.dto.ThemaDto;
import com.goa.domain.model.Betreuer;
import com.goa.domain.model.Datei;
import com.goa.domain.model.Thema;

import java.util.Set;
import java.util.stream.Collectors;

public class BetreuerMapper {

	public static BetreuerDto toDto(Betreuer betreuer) {
		if (betreuer == null) {
			return null;
		}
		BetreuerDto dto = new BetreuerDto();
		dto.setName(betreuer.getName());
		dto.setEmail(betreuer.getEmail());
		dto.setFachgebiete(betreuer.getFachgebiete());
		Set<DateiDto> dtoDatei = betreuer.getDateien().stream().map(DateiMapper::toDto).collect(Collectors.toSet());
		dto.setDateien(dtoDatei);
		Set<ThemaDto> themen = betreuer.getThemen().stream().map(ThemaMapper::toDto).collect(Collectors.toSet());
		dto.setThemen(themen);

		return dto;
	}

	public static Betreuer toEntity(BetreuerDto dto) {
		if (dto == null) {
			return null;
		}
		else {
			Set<Datei> dateien = dto.getDateien().stream().map(DateiMapper::toEntity).collect(Collectors.toSet());
			Set<Thema> themen = dto.getThemen().stream().map(ThemaMapper::toEntity).collect(Collectors.toSet());
			return new Betreuer(
					dto.getName(),
					dto.getEmail(),
					dto.getFachgebiete(),
					dateien,
					themen
			);
		}
	}
}
