package com.pramukh.footballrecoverysystem.Repository;

import com.pramukh.footballrecoverysystem.Model.PlayerEntity.PlayersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PlayerRepo extends JpaRepository<PlayersEntity,Integer> {

    @Query("SELECT p FROM PlayersEntity p WHERE p.name = ?1")
    List<PlayersEntity> findByplayerName(String name);
}
