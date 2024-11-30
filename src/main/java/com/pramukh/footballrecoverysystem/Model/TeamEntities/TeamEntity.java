package com.pramukh.footballrecoverysystem.Model.TeamEntities;


import com.pramukh.footballrecoverysystem.Model.PlayersEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeamEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int team_id;

    @Column(name ="team_name", nullable = false,unique = true)
    private String name;

    @Column(nullable = false)
    private String coach;

    @Column(nullable = false)
    private String league;

    @OneToMany(mappedBy = "teamEntity", cascade = CascadeType.ALL)
    private List<PlayersEntity> playersEntityList;

}
