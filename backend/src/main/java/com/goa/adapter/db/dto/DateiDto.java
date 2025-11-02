package com.goa.adapter.db.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@ToString
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name= "datei")
public class DateiDto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "datei_id")
	private Long dateiId;

	@Lob
	private byte[] daten; // bei markdown dateien muss der <script> tag verhindert werden

	@Column(nullable = false)
	private String dateiUploader;

	@Column(nullable = false)
	private LocalDateTime uploadDatum;

	@Column(nullable = false)
	private String titel;

	private String beschreibung;
}
