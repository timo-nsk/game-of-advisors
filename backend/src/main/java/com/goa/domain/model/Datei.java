package com.goa.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

// max 10MB
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Datei {
	private byte[] daten; // bei markdown dateien muss der <script> tag verhindert werden
	private String dateiUploader;
	private LocalDateTime uploadDatum;
	private String titel;
	private String beschreibung; // optional
}
