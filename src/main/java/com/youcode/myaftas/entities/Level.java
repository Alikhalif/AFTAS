package com.youcode.myaftas.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Level {
    @Id
    @NotNull(message = "id should not be null")
    private Integer id;

    @NotBlank(message = "description should not be empty")
    private String description;

    @NotNull(message = "points should not be null")
    @PositiveOrZero(message = "points should not be negative")
    private Integer point;

    @OneToMany(mappedBy = "level", fetch = FetchType.LAZY, orphanRemoval = true, cascade = CascadeType.ALL)
    private List<Fish> fishList;

}

