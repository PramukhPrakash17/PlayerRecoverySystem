package com.pramukh.footballrecoverysystem.Controller;

import com.pramukh.footballrecoverysystem.ExceptionHandling.InjuryNotFoundException;
import com.pramukh.footballrecoverysystem.Model.RecoveryPlanEnitty.CreateRecoveryPlanDto;
import com.pramukh.footballrecoverysystem.Model.RecoveryPlanEnitty.UpdatePlanDTO;
import com.pramukh.footballrecoverysystem.Service.RecoveryPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/recoveryPlan")
public class RecoveryPlanController {
    @Autowired
    private RecoveryPlanService recoveryPlanService;

    @PostMapping("/createRecoveryPlan")
    public ResponseEntity<?> createRecoveryPlan(@RequestBody CreateRecoveryPlanDto createRecoveryPlanDto) {
        try
        {
            return ResponseEntity.ok(recoveryPlanService.createRecoveryPlan(createRecoveryPlanDto));
        }
        catch (Exception e)
        {
            return ResponseEntity.status(500).body("Error while creating recovery plan");
        }
    }

    @GetMapping("/getRecoveryPlanById")
    public ResponseEntity<?> getRecoveryPlanById(@RequestParam int id) {
        try {
            return ResponseEntity.ok(recoveryPlanService.getRecoveryPlanById(id));
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error while fetching recovery plan");
        }
    }

    @GetMapping("/getRecoveryPlans/injury/")
    public ResponseEntity<?> getRecoveryPlansByInjuryId(@RequestParam int id) {
        try {
            return ResponseEntity.ok(recoveryPlanService.getRecoveryPlansByInjuryId(id));
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error while fetching recovery plans");
        }
    }

    @GetMapping("/getRecoveryPlans")
    public ResponseEntity<?> getRecoveryPlans() {
        try {
            return ResponseEntity.ok(recoveryPlanService.getRecoveryPlans());
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error while fetching recovery plans");
        }
    }

    @PutMapping("/updateRecoveryPlan")
    public ResponseEntity<?> updateRecoveryPlan(@RequestBody UpdatePlanDTO updatePlanDTO,@RequestParam int planid) {
        try {
            return ResponseEntity.ok(recoveryPlanService.updateRecoveryPlan(updatePlanDTO , planid));
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error while updating recovery plan");
        }
    }

}
