package com.pramukh.footballrecoverysystem.Service;

import com.pramukh.footballrecoverysystem.ExceptionHandling.TeamExistsException;
import com.pramukh.footballrecoverysystem.ExceptionHandling.TeamNotFoundException;
import com.pramukh.footballrecoverysystem.Model.TeamEntities.TeamEntity;
import com.pramukh.footballrecoverysystem.Model.TeamEntities.UpdateDTO;
import com.pramukh.footballrecoverysystem.Repository.TeamRepo;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamService {
    @Autowired
    private TeamRepo teamRepo;


    public TeamEntity addTeam(TeamEntity teamentity)  {
        if(teamRepo.existsByName((teamentity.getName())))
        {
            throw new TeamExistsException("Team already exists");
        }
        return teamRepo.save(teamentity);

    }

    public List<TeamEntity> getallTeams()
    {
        List<TeamEntity> teams = teamRepo.findAll();
        if(teams.isEmpty())
        {
            throw new TeamNotFoundException("No teams found");
        }
        return teams;
    }


    public TeamEntity getTeam(String name)
    {
        if(teamRepo.existsByName(name))
        {
            return teamRepo.findBynameIgnoreCase(name);
        }
        else
        {
            throw new TeamNotFoundException("Team not found");
        }
    }

    public TeamEntity updateTeam(UpdateDTO updateDTO) {
        String name = updateDTO.getName();
        if(teamRepo.existsByName(name))
        {
            TeamEntity team = teamRepo.findBynameIgnoreCase(name);
            if(updateDTO.getCoach()!=null){
                team.setCoach(updateDTO.getCoach());
            }
            if(updateDTO.getLeague()!=null){
                team.setCoach(updateDTO.getLeague());
            }
            if(updateDTO.getName()!=null){
                team.setCoach(updateDTO.getName());
            }
            return teamRepo.save(team);
        }
        else
        {
            throw new TeamNotFoundException("Team not found");
        }

    }

    public String deleteTeam(String name) {
        if(teamRepo.existsByName(name))
        {
            TeamEntity team = teamRepo.findBynameIgnoreCase(name);
            teamRepo.delete(team);
            return "Team deleted";
        }
        else
        {
            throw new TeamNotFoundException("Team not found");
        }
    }
}