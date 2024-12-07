package com.pramukh.footballrecoverysystem.Model.RecoveryPlanEnitty;

import com.pramukh.footballrecoverysystem.Model.InjuryEntity.InjuryEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecoveryPlanEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int plan_id;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String expected_return_date;

    private String actual_return_date;

    @Column(nullable = false)
    private String status="InProgress";

    @OneToOne
    @JoinColumn(name="injury_id")
    private InjuryEntity injuryEntity;
}
