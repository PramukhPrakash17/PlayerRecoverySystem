package com.pramukh.footballrecoverysystem.Controller;

import com.pramukh.footballrecoverysystem.ExceptionHandling.TeamExistsException;
import com.pramukh.footballrecoverysystem.ExceptionHandling.TeamNotFoundException;
import com.pramukh.footballrecoverysystem.Model.TeamEntities.TeamEntity;
import com.pramukh.footballrecoverysystem.Model.TeamEntities.UpdateDTO;
import com.pramukh.footballrecoverysystem.Service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/team")
public class TeamController {

    @Autowired
    private TeamService teamService;

    @PostMapping("/addTeam")
    public ResponseEntity<?> addTeam(@RequestBody TeamEntity teamentity){
        try
        {
            TeamEntity createdTeam = teamService.addTeam(teamentity);
            return ResponseEntity.status((HttpStatus.CREATED)).body(createdTeam);
        }
        catch (TeamExistsException e)
        {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }

        catch (Exception e)
        {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error while adding team");
        }

    }

    @GetMapping("/getAllTeams")
    public ResponseEntity<?> getAllTeams()
    {
        try
        {
            List<TeamEntity> teams = teamService.getallTeams();
            return ResponseEntity.status(HttpStatus.OK).body(teams);
        }
        catch (Exception e)
        {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error while fetching teams");
        }
    }

    @GetMapping("/getTeams")
    public ResponseEntity<?> getTeam(@RequestParam String name)
    {
        try
        {
            TeamEntity team = teamService.getTeam(name);
            return ResponseEntity.status(HttpStatus.OK).body(team);
        }
        catch (TeamNotFoundException e)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
        catch (Exception e)
        {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error while fetching team");
        }
    }

    @PutMapping("/updateTeam")
    public ResponseEntity<?> updateTeam(@RequestBody UpdateDTO updateDTO)
    {
        try
        {
            TeamEntity updatedTeam = teamService.updateTeam(updateDTO);
            return ResponseEntity.status(HttpStatus.OK).body(updatedTeam);
        }
        catch (TeamNotFoundException e)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
        catch (Exception e)
        {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error while updating team");
        }
    }

    @DeleteMapping("/deleteTeam")
    public ResponseEntity<?> deleteTeam(@RequestParam String name)
    {
        try
        {
            return ResponseEntity.status(HttpStatus.OK).body(teamService.deleteTeam(name));
        }
        catch (TeamNotFoundException e)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
        catch (Exception e)
        {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error while fetching team");
        }
    }


}
