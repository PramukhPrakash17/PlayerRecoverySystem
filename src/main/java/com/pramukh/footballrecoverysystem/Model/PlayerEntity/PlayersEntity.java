package com.pramukh.footballrecoverysystem.Model.PlayerEntity;

import com.pramukh.footballrecoverysystem.Model.InjuryEntity.InjuryEntity;
import com.pramukh.footballrecoverysystem.Model.TeamEntities.TeamEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlayersEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int player_id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private  int age;

    @Column(nullable = false)
    private String position;

    @ManyToOne
    @JoinColumn(name="team_id")
    private TeamEntity teamEntity;

    @OneToMany(mappedBy = "playersEntity", cascade = CascadeType.ALL)
    private List<InjuryEntity> injuryEntityList;
}
