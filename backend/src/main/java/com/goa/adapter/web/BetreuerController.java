package com.goa.adapter.web;

import com.goa.application.service.BetreuerService;
import com.goa.domain.model.Betreuer;
import com.goa.domain.model.Thema;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RequestMapping("/api/person")
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class BetreuerController {

	private final BetreuerService betreuerService;

	public BetreuerController(BetreuerService betreuerService) {
		this.betreuerService = betreuerService;
	}

	@GetMapping("/get-all-personen")
	public ResponseEntity<List<Betreuer>> getAllPersonen() {
		 var l = betreuerService.findAll();
		return ResponseEntity.ok(l);
	}

	@GetMapping("/get-themen-by-email/{email}")
	public ResponseEntity<Set<Thema>> getThemenByEmail(@PathVariable String email) {
		Betreuer b = betreuerService.findByEmail(email);
		return ResponseEntity.ok(b.getThemen());
	}

}
