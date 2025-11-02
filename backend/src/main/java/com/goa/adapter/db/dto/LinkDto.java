package com.goa.adapter.db.dto;

import jakarta.persistence.*;
import lombok.*;

@ToString
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "link")
public class LinkDto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "link_id")
	private Long linkId;

	@Column(nullable = false)
	private String url;

	@Column(length = 200)
	private String text;
}
