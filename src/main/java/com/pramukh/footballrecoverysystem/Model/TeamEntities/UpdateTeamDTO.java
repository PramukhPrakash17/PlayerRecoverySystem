package com.pramukh.footballrecoverysystem.Model.TeamEntities;


import lombok.Data;

@Data
public class UpdateTeamDTO {
    private String name;
    private String coach;
    private String league;
}
