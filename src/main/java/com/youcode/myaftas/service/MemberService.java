package com.youcode.myaftas.service;

import com.youcode.myaftas.dto.MemberDto;

import java.util.List;

public interface MemberService {
    MemberDto create(MemberDto memberDto);
    void delete(Integer id);
    MemberDto getOne(Integer id);
    List<MemberDto> getAll();
    MemberDto update(Integer id, MemberDto memberDto);

}
