package com.goa.adapter.db.mapper;

import com.goa.adapter.db.dto.DateiDto;
import com.goa.domain.model.Datei;

public class DateiMapper {

	public static DateiDto toDto(Datei datei) {
		if (datei == null) {
			return null;
		}
		DateiDto dto = new DateiDto();
		dto.setDaten(datei.getDaten());
		dto.setDateiUploader(datei.getDateiUploader());
		dto.setUploadDatum(datei.getUploadDatum());
		dto.setTitel(datei.getTitel());
		dto.setBeschreibung(datei.getBeschreibung());
		return dto;
	}

	public static Datei toEntity(DateiDto dto) {
		if (dto == null) {
			return null;
		}
		Datei datei = new Datei();
		datei.setDaten(dto.getDaten());
		datei.setDateiUploader(dto.getDateiUploader());
		datei.setUploadDatum(dto.getUploadDatum());
		datei.setTitel(dto.getTitel());
		datei.setBeschreibung(dto.getBeschreibung());
		return datei;
	}
}
