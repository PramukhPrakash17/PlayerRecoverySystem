package com.pramukh.footballrecoverysystem.Service;

import com.pramukh.footballrecoverysystem.ExceptionHandling.PlayerNotFoundException;
import com.pramukh.footballrecoverysystem.ExceptionHandling.TeamNotFoundException;
import com.pramukh.footballrecoverysystem.Model.PlayerEntity.CreatePlayerDTO;
import com.pramukh.footballrecoverysystem.Model.PlayerEntity.PlayersEntity;
import com.pramukh.footballrecoverysystem.Model.PlayerEntity.UpdatePlayerDto;
import com.pramukh.footballrecoverysystem.Model.TeamEntities.TeamEntity;
import com.pramukh.footballrecoverysystem.Repository.PlayerRepo;
import com.pramukh.footballrecoverysystem.Repository.TeamRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {
    @Autowired
    private TeamRepo teamRepo;

    @Autowired
    private PlayerRepo playerRepo;

    @Autowired
    private TeamService teamService;

    public PlayersEntity addPlayer(CreatePlayerDTO playerDto) {
        TeamEntity team = teamRepo.findById(playerDto.getTeam_id()).orElseThrow(() -> new TeamNotFoundException("Team not found"));
        PlayersEntity player = new PlayersEntity();
        player.setName(playerDto.getName());
        player.setAge(playerDto.getAge());
        player.setPosition(playerDto.getPosition());
        player.setTeamEntity(team);
        return playerRepo.save(player);
        }

    public List<PlayersEntity> getPlayers() {
        return playerRepo.findAll();
    }

    public PlayersEntity getPlayerById(int id) {
        return playerRepo.findById(id).orElseThrow(() -> new PlayerNotFoundException("Player not found"));
    }

    public List<PlayersEntity> getPlayerByName(String name) {
        List<PlayersEntity> players = playerRepo.findByplayerName(name);
        if(players.isEmpty()) {
            throw new PlayerNotFoundException("Player not found");
        }
        return players;
    }

    public String deletePlayer(int id) {
        PlayersEntity player = playerRepo.findById(id).orElseThrow(() -> new PlayerNotFoundException("Player not found"));
        playerRepo.delete(player);
        return "Player deleted";
    }

    public PlayersEntity updatePlayer(UpdatePlayerDto playerDto , int id) {
        PlayersEntity player = playerRepo.findById(id).orElseThrow(() -> new PlayerNotFoundException("Player not found"));
        TeamEntity team = teamService.getTeam(playerDto.getTeamName());
        player.setName(playerDto.getName());
        player.setAge(playerDto.getAge());
        player.setPosition(playerDto.getPosition());
        player.setTeamEntity(team);
        return playerRepo.save(player);
    }
}

