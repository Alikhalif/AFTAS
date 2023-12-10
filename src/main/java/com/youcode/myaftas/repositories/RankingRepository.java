package com.youcode.myaftas.repositories;

import com.youcode.myaftas.Utils.RankingId;
import com.youcode.myaftas.entities.Ranking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RankingRepository extends JpaRepository<Ranking, RankingId> {


}
