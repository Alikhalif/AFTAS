package com.youcode.myaftas.repositories;

import com.youcode.myaftas.entities.Hunting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface HuntingRepository extends JpaRepository<Hunting, Integer> {

    @Query("SELECT h FROM Hunting h " +
            "WHERE h.competition.code = :competitionId " +
            "AND h.member.id = :memberId " +
            "AND h.fish.name = :fishId")
    Hunting findByCompetitionIdAndMemberIdAndFishId(
            @Param("competitionId") String competitionId,
            @Param("memberId") Integer memberId,
            @Param("fishId") String fishId
    );

}
