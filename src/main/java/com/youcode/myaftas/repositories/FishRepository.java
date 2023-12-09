package com.youcode.myaftas.repositories;

import com.youcode.myaftas.entities.Fish;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FishRepository extends JpaRepository<Fish, String> {
}
