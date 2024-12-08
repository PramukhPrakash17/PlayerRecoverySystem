package com.pramukh.footballrecoverysystem.Service;

import com.pramukh.footballrecoverysystem.ExceptionHandling.InjuryNotFoundException;
import com.pramukh.footballrecoverysystem.ExceptionHandling.RecoveryPlanNotFound;
import com.pramukh.footballrecoverysystem.Model.InjuryEntity.InjuryEntity;
import com.pramukh.footballrecoverysystem.Model.RecoveryPlanEnitty.CreateRecoveryPlanDto;
import com.pramukh.footballrecoverysystem.Model.RecoveryPlanEnitty.RecoveryPlanEntity;
import com.pramukh.footballrecoverysystem.Model.RecoveryPlanEnitty.UpdatePlanDTO;
import com.pramukh.footballrecoverysystem.Repository.RecoveryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecoveryPlanService {
    @Autowired
    private RecoveryRepo recoveryRepo;

    @Autowired
    private  InjuryService injuryService;

    public RecoveryPlanEntity createRecoveryPlan(CreateRecoveryPlanDto createRecoveryPlanDto) {
        InjuryEntity injuryEntity = injuryService.getInjuryById(createRecoveryPlanDto.getInjury_id());
        if(injuryEntity == null) {
            throw new InjuryNotFoundException("Injury not found");
        } else {
            RecoveryPlanEntity recoveryPlanEntity = new RecoveryPlanEntity();
            recoveryPlanEntity.setDescription(createRecoveryPlanDto.getDescription());
            recoveryPlanEntity.setExpected_return_date(createRecoveryPlanDto.getExpected_return_date());
            recoveryPlanEntity.setInjuryEntity(injuryEntity);
            return  recoveryRepo.save(recoveryPlanEntity);

        }
    }

    public RecoveryPlanEntity getRecoveryPlanById(int id) {
        return recoveryRepo.findById(id).orElseThrow(() -> new RecoveryPlanNotFound("Recovery Plan not found"));
    }


    public RecoveryPlanEntity getRecoveryPlansByInjuryId(int id) {
        InjuryEntity injuryEntity = injuryService.getInjuryById(id);
        if(injuryEntity == null) {
            throw new InjuryNotFoundException("Injury not found");
        } else {
            return recoveryRepo.findById(id).orElseThrow(() -> new RecoveryPlanNotFound("Recovery Plan not found"));
        }
    }

    public List<RecoveryPlanEntity> getRecoveryPlans() {
        return recoveryRepo.findAll();
    }

    public RecoveryPlanEntity updateRecoveryPlan(UpdatePlanDTO updatePlanDTO, int planid) {
        RecoveryPlanEntity recoveryPlanEntity = recoveryRepo.findById(planid).orElseThrow(() -> new RecoveryPlanNotFound("Recovery Plan not found"));
        recoveryPlanEntity.setStatus(updatePlanDTO.getStatus());
        recoveryPlanEntity.setActual_return_date(updatePlanDTO.getActual_return_date());
        return recoveryRepo.save(recoveryPlanEntity);
    }
}
