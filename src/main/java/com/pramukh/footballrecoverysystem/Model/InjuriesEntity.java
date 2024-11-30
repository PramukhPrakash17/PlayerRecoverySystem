package com.pramukh.footballrecoverysystem.Model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InjuriesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int injury_id;

    @Column(nullable = false)
    private String injury_name;

    @Column(nullable = false)
    private String severity;

    @Column(nullable = false)
    private Date date_reported;

    @Column(nullable = false)

    private String recovery_status="Pending";

    @ManyToOne
    @JoinColumn(name="player_id")
    private PlayersEntity playersEntity;

}
