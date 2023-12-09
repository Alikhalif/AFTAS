package com.youcode.myaftas.service;

import com.youcode.myaftas.dto.CompetitionDto;
import com.youcode.myaftas.dto.rasponseDTO.CompetitionRespDto;

import java.util.List;

public interface CompititionService {
    CompetitionDto create(CompetitionDto competitionDto);
    void delete(String id);
    CompetitionDto getOne(String id);
    List<CompetitionRespDto> getAll();
    CompetitionDto update(String code, CompetitionDto competitionDto);
}
