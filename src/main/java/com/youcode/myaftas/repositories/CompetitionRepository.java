package com.youcode.myaftas.repositories;

import com.youcode.myaftas.entities.Competition;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompetitionRepository extends JpaRepository<Competition, String> {
}
