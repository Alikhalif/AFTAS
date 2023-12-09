package com.youcode.myaftas.dto.rasponseDTO;

import com.youcode.myaftas.dto.FishDto;
import lombok.Data;

import java.util.List;

@Data
public class LevelRespDto {
    private Integer id;

    private String description;

    private Integer points;

    private List<FishDto> fishList;
}
