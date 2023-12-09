package com.youcode.myaftas.repositories;

import com.youcode.myaftas.entities.Ranking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RankingRepository extends JpaRepository<Ranking, Integer> {

}
