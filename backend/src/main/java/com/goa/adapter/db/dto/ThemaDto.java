package com.goa.adapter.db.dto;

import com.goa.domain.model.Veranstaltung;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "thema")
public class ThemaDto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long themaId;

	@Column(nullable = false)
	private String titel;

	@Column(length = 4000)
	private String beschreibung;

	@ElementCollection(targetClass = Veranstaltung.class)
	@Enumerated(EnumType.STRING)
	@CollectionTable(name = "thema_anforderungen", joinColumns = @JoinColumn(name = "thema_id"))
	@Column(name = "anforderungen")
	private Set<Veranstaltung> anforderungen;

	@ElementCollection
	@Column(name = "thema_dto_fachgebiete")
	private Set<String> fachgebiete;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(
			name = "thema_links",
			joinColumns = @JoinColumn(name = "thema_id"),
			inverseJoinColumns = @JoinColumn(name = "link_id")
	)
	private Set<LinkDto> links;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(
			name = "thema_dateien",
			joinColumns = @JoinColumn(name = "thema_id"),
			inverseJoinColumns = @JoinColumn(name = "datei_id")
	)
	private Set<DateiDto> dateien;
}
