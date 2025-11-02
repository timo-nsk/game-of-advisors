package com.goa.adapter.web;

import com.goa.adapter.db.dto.BetreuerDto;
import com.goa.adapter.db.impl.BetreuerRepositoryImpl;
import com.goa.adapter.web.request.NeuesThemaRequestDto;
import com.goa.application.service.BetreuerService;
import com.goa.application.service.ThemaErstellenService;
import com.goa.application.service.ThemaService;
import com.goa.domain.model.Betreuer;
import com.goa.domain.model.Thema;
import com.goa.domain.model.Veranstaltung;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/thema")
@CrossOrigin(origins = "http://localhost:4200")
public class ThemaController {

	private final ThemaService themaService;
	private final BetreuerService betreuerService;
	private final ThemaErstellenService themaErstellenService;

	public ThemaController(ThemaService themaService, BetreuerService betreuerService, ThemaErstellenService themaErstellenService) {
		this.themaService = themaService;
		this.betreuerService = betreuerService;
		this.themaErstellenService = themaErstellenService;
	}

	@GetMapping("/get-all-themen")
	public ResponseEntity<List<Thema>> getAllThemen() {
		return ResponseEntity.ok(themaService.findAll());
	}

	@GetMapping("/get-anforderungen")
	public ResponseEntity<Map<Veranstaltung, String>> getAnforderungen() {
		return ResponseEntity.ok(Veranstaltung.MAP);
	}

	@Transactional
	@PostMapping("/neues-thema-erstellen")
	public ResponseEntity<Void> neuesThemaErstellen(@RequestBody NeuesThemaRequestDto neuesThemaRequestDto) {
		Thema neuesThema = neuesThemaRequestDto.toEntity();
		themaErstellenService.saveThema(neuesThema, 1L);
		return ResponseEntity.ok().build();
	}
}
