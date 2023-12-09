package com.youcode.myaftas.repositories;

import com.youcode.myaftas.entities.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Integer> {
}
