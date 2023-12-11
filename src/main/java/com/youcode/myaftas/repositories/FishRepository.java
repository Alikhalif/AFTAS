package com.youcode.myaftas.repositories;

import com.youcode.myaftas.entities.Competition;
import com.youcode.myaftas.entities.Fish;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FishRepository extends JpaRepository<Fish, String> {
    Optional<Fish> findByName(String name);
}
