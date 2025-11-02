package com.goa.adapter.db.dao;

import com.goa.adapter.db.dto.BetreuerDto;
import com.goa.domain.model.Veranstaltung;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Set;

public interface BetreuerDao extends JpaRepository<BetreuerDto, Long> {
	BetreuerDto findByBetreuerId(Long betreuerId);
	BetreuerDto findByEmail(String email);

	@Query(value = """
    SELECT DISTINCT b.*
    FROM betreuer b
    LEFT JOIN betreuer_fachgebiete bf ON b.betreuer_id = bf.betreuer_id
    LEFT JOIN betreuer_thema bt ON b.betreuer_id = bt.betreuer_id
    LEFT JOIN thema_anforderungen ta ON bt.thema_id = ta.thema_id
    WHERE (bf.fachgebiet IN :fachgebiete)
       OR (ta.anforderungen IN :anforderungen)
    """,
			nativeQuery = true)
	List<BetreuerDto> findByFachgebieteOderAnforderungen(
			@Param("fachgebiete") Set<String> fachgebiete,
			@Param("anforderungen") Set<Veranstaltung> anforderungen);
}
