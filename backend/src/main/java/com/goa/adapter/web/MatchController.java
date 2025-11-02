package com.goa.adapter.web;

import com.goa.adapter.web.request.MatchRequest;
import com.goa.application.service.BetreuerService;
import com.goa.application.service.MatchService;
import com.goa.domain.model.Betreuer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/matching")
@CrossOrigin(origins = "http://localhost:4200")
public class MatchController {

	private final MatchService matchService;

	public MatchController(MatchService matchService) {
		this.matchService = matchService;
	}


	@PostMapping("/find-matches")
	public ResponseEntity<List<Betreuer>> findMatches(@RequestBody MatchRequest matchRequest) {
		List<Betreuer> matching = matchService.findMatches(matchRequest.anforderungen(), matchRequest.getFachgebiete());
		System.out.println(matching);
		return ResponseEntity.ok(matching);
	}
}
