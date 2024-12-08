package com.pramukh.footballrecoverysystem.Model.PlayerEntity;

import lombok.Data;

@Data
public class UpdatePlayerDto {
    private String name;
    private int age;
    private String position;
    private String teamName;
}
