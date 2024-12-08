package com.pramukh.footballrecoverysystem.Controller;

import com.pramukh.footballrecoverysystem.ExceptionHandling.PlayerNotFoundException;
import com.pramukh.footballrecoverysystem.ExceptionHandling.TeamNotFoundException;
import com.pramukh.footballrecoverysystem.Model.PlayerEntity.CreatePlayerDTO;
import com.pramukh.footballrecoverysystem.Model.PlayerEntity.PlayersEntity;
import com.pramukh.footballrecoverysystem.Model.PlayerEntity.UpdatePlayerDto;
import com.pramukh.footballrecoverysystem.Service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/player")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @PostMapping("/add")
    public ResponseEntity<?> addPlayer(@RequestBody CreatePlayerDTO playerDto) {
        try {
            PlayersEntity addedPLayer = playerService.addPlayer(playerDto);
            return ResponseEntity.ok(addedPLayer);
        } catch (TeamNotFoundException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error while adding player");
        }
    }

    @GetMapping("/getPlayers")
    public ResponseEntity<?> getPlayers() {
        try {
            return ResponseEntity.ok(playerService.getPlayers());
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error while fetching players");
        }
    }

    @GetMapping("/getPlayersById")
    public ResponseEntity<?> getPlayersById(@RequestParam int id) {
        try {
            return ResponseEntity.ok(playerService.getPlayerById(id));
        }
        catch (PlayerNotFoundException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
        catch (Exception e) {
            return ResponseEntity.status(500).body("Error while fetching players");
        }
    }

    @GetMapping("/getPlayerByName")
    public ResponseEntity<?> getPlayerByName(@RequestParam String name) {
        try {
            return ResponseEntity.ok(playerService.getPlayerByName(name));
        }
        catch (PlayerNotFoundException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
        catch (Exception e) {
            return ResponseEntity.status(500).body("Error while fetching players");
        }
    }

    @DeleteMapping("/deletePlayer")
    public ResponseEntity<?> deletePlayer(@RequestParam int id) {
        try {
            playerService.deletePlayer(id);
            return ResponseEntity.ok("Player deleted successfully");
        }
        catch (PlayerNotFoundException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
        catch (Exception e) {
            return ResponseEntity.status(500).body("Error while deleting player");
        }
    }

    @PutMapping("/updatePlayer")
    public ResponseEntity<?> updatePlayer(@RequestBody UpdatePlayerDto playerDto , @RequestParam int id) {
        try {
            PlayersEntity updatedPlayer = playerService.updatePlayer(playerDto, id);
            return ResponseEntity.ok(updatedPlayer);
        }catch (TeamNotFoundException | PlayerNotFoundException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
        catch (Exception e) {
            return ResponseEntity.status(500).body("Error while updating player");
        }
    }
}