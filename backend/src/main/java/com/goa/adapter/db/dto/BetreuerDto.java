package com.goa.adapter.db.dto;

import com.goa.adapter.db.mapper.ThemaMapper;
import com.goa.domain.model.Thema;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "betreuer")
@ToString
public class BetreuerDto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "betreuer_id")
	private Long betreuerId;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private String email;

	@ElementCollection
	@CollectionTable(name = "betreuer_fachgebiete", joinColumns = @JoinColumn(name = "betreuer_id"))
	@Column(name = "fachgebiet")
	private Set<String> fachgebiete;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(
			name = "betreuer_datei",
			joinColumns = @JoinColumn(name = "betreuer_id"),
			inverseJoinColumns = @JoinColumn(name = "datei_id")
	)
	private Set<DateiDto> dateien;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(
			name = "betreuer_thema",
			joinColumns = @JoinColumn(name = "betreuer_id"),
			inverseJoinColumns = @JoinColumn(name = "thema_id")
	)
	private Set<ThemaDto> themen;

	public void themaHinzufügen(Thema t) {
		themen.add(ThemaMapper.toDto(t));
	}


}
