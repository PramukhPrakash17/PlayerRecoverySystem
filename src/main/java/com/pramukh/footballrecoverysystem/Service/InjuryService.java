package com.pramukh.footballrecoverysystem.Service;

import com.pramukh.footballrecoverysystem.ExceptionHandling.InjuryNotFoundException;
import com.pramukh.footballrecoverysystem.ExceptionHandling.PlayerNotFoundException;
import com.pramukh.footballrecoverysystem.Model.InjuryEntity.AddInjuryDto;
import com.pramukh.footballrecoverysystem.Model.InjuryEntity.InjuryEntity;
import com.pramukh.footballrecoverysystem.Model.InjuryEntity.UpdateInjuryDto;
import com.pramukh.footballrecoverysystem.Model.PlayerEntity.PlayersEntity;
import com.pramukh.footballrecoverysystem.Repository.InjuryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InjuryService {
    @Autowired
    private InjuryRepo injuryRepo;

    @Autowired
    private PlayerService playerService;

    public InjuryEntity addInjury(AddInjuryDto addInjuryDto) {
        PlayersEntity player = playerService.getPlayerById(addInjuryDto.getPlayer_id());
        InjuryEntity injury = new InjuryEntity();
        injury.setInjury_name(addInjuryDto.getInjury_name());
        injury.setSeverity(addInjuryDto.getSeverity());
        injury.setDate_reported(addInjuryDto.getDate_reported());
        injury.setPlayersEntity(player);
        return injuryRepo.save(injury);
    }

    public List<InjuryEntity> getInjuries() {
        return injuryRepo.findAll();
    }

    public InjuryEntity getInjuryByName(String name) {
        return  injuryRepo.findByInjury_name(name);
    }

    public InjuryEntity updateInjury(UpdateInjuryDto updateInjuryDto)  {
            InjuryEntity injury = injuryRepo.findByInjury_name(updateInjuryDto.getInjury_name());
            if(injury == null) {
                throw new InjuryNotFoundException("Injury not found");
            }
            else {
                injury.setRecovery_status(updateInjuryDto.getRevocery_status());
                return injuryRepo.save(injury);
        }

    }

    public InjuryEntity getInjuryById(int id) {
        return injuryRepo.findById(id).orElseThrow(() -> new InjuryNotFoundException("Injury not found"));
    }
}
