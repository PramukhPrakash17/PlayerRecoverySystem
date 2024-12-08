package com.pramukh.footballrecoverysystem.Model.RecoveryPlanEnitty;

import lombok.Data;

import java.util.Date;

@Data
public class UpdatePlanDTO {
    private String status;
    private Date actual_return_date;
}
