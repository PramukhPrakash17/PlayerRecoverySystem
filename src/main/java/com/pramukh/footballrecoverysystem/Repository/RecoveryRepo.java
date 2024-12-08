package com.pramukh.footballrecoverysystem.Repository;

import com.pramukh.footballrecoverysystem.Model.RecoveryPlanEnitty.RecoveryPlanEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecoveryRepo extends JpaRepository<RecoveryPlanEntity, Integer> {
}
