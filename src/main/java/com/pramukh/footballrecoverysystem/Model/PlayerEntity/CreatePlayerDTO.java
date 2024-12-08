package com.pramukh.footballrecoverysystem.Model.PlayerEntity;

import lombok.Data;

@Data
public class CreatePlayerDTO {
    private String name;
    private int age;
    private String position;
    private int team_id;
}
