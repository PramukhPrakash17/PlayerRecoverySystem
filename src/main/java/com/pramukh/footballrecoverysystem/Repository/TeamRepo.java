package com.pramukh.footballrecoverysystem.Repository;

import com.pramukh.footballrecoverysystem.Model.TeamEntities.TeamEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeamRepo extends JpaRepository<TeamEntity,Integer> {
    Boolean existsByName(String teamName);

    @Query("SELECT t FROM TeamEntity t WHERE LOWER(t.name) = LOWER(:name)")
    TeamEntity findBynameIgnoreCase(String name);



}
