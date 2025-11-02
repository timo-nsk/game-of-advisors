package com.goa.adapter.db.mapper;

import com.goa.adapter.db.dto.LinkDto;
import com.goa.domain.model.Link;

public class LinkMapper {
	public static LinkDto toDto(Link link) {
		if (link == null) {
			return null;
		}

		LinkDto dto = new LinkDto();
		dto.setUrl(link.getUrl());
		dto.setText(link.getText());

		return dto;
	}

	public static Link toEntity(LinkDto dto) {
		if (dto == null) {
			return null;
		}

		Link link = new Link();
		link.setUrl(dto.getUrl());
		link.setText(dto.getText());

		return link;
	}
}
