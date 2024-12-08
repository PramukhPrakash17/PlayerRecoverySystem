package com.pramukh.footballrecoverysystem.Model.InjuryEntity;

import lombok.Data;

import java.util.Date;

@Data
public class AddInjuryDto {
    private String injury_name;
    private String severity;
    private Date date_reported;
    private int player_id;
}
