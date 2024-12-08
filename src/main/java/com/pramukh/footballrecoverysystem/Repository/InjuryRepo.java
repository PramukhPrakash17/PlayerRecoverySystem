package com.pramukh.footballrecoverysystem.Repository;

import com.pramukh.footballrecoverysystem.Model.InjuryEntity.InjuryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InjuryRepo extends JpaRepository<InjuryEntity,Integer> {

    @Query("SELECT i FROM InjuryEntity i WHERE LOWER(i.injury_name) = LOWER(:name)")
    InjuryEntity findByInjury_name(String name);
}
