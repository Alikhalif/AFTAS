package com.youcode.myaftas.service;

import com.youcode.myaftas.Utils.RankingId;
import com.youcode.myaftas.dto.RankingDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface RankingService {
    RankingDto create(RankingDto rankingDto);
    void delete(String code, Integer id);
    RankingDto getOne(String code, Integer id);
    List<RankingDto> findAll();
    RankingDto update(String code, Integer id, RankingDto rankingDto);
    Page<RankingDto> findWithPagination(Pageable pageable);
}
