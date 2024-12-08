package com.pramukh.footballrecoverysystem.Model.RecoveryPlanEnitty;

import lombok.Data;

import java.util.Date;

@Data
public class CreateRecoveryPlanDto {
    private String description;
    private Date expected_return_date;
    private int injury_id;
}
