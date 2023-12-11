package com.youcode.myaftas.service;

import com.youcode.myaftas.dto.HuntingDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface HuntingService {
    List<HuntingDto> create(List<HuntingDto> huntingDtos);
    void delete(Integer id);
    HuntingDto getOne(Integer id);
    List<HuntingDto> findAll();
    HuntingDto update(Integer id, HuntingDto huntingDto);
    Page<HuntingDto> findWithPagination(Pageable pageable);

}
