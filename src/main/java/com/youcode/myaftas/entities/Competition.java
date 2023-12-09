package com.youcode.myaftas.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "competition")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Competition {
    @Id
    @NotNull(message = "Code Should Not Be Null")
    @Pattern(regexp = "[A-Za-z]{3}-\\d{8}", message = "Code should follow the pattern '3 letters - 8 digits'")
    private String code;

    @NotNull(message = "Date Should Not Be Null")
    private LocalDate date;

    @NotNull(message = "Start Time Should Not Be Null")
    private LocalDateTime startTime;

    @NotNull(message = "End Time Should Not Be Null")
    private LocalDateTime endTime;

    @Positive(message = "number Of Participants should be a positive value")
    private Integer numberOfParticipants;

    @NotBlank(message = "Location Should Not Be Empty")
    private String location;

    @NotNull(message = "Amount Should Not Be Null")
    private Double amount;

    @OneToMany(mappedBy = "competition", fetch = FetchType.LAZY, orphanRemoval = true, cascade = CascadeType.ALL)
    private List<Ranking> rankingList;

    @OneToMany(mappedBy = "competition", fetch = FetchType.LAZY, orphanRemoval = true, cascade = CascadeType.ALL)
    private List<Hunting> huntingList;

}
