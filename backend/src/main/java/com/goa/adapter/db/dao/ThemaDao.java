package com.goa.adapter.db.dao;

import com.goa.adapter.db.dto.ThemaDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ThemaDao extends JpaRepository<ThemaDto, Long> {
	ThemaDto findByThemaId(Long themaId);
}
