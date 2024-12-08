package com.pramukh.footballrecoverysystem.Controller;

import com.pramukh.footballrecoverysystem.ExceptionHandling.InjuryNotFoundException;
import com.pramukh.footballrecoverysystem.Model.InjuryEntity.AddInjuryDto;
import com.pramukh.footballrecoverysystem.Model.InjuryEntity.UpdateInjuryDto;
import com.pramukh.footballrecoverysystem.Service.InjuryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/injury")
public class InjuryController {

    @Autowired
    private InjuryService injuryService;

    @PostMapping("/add")
    public ResponseEntity<?> addInjury(AddInjuryDto addInjuryDto) {
        try {
            injuryService.addInjury(addInjuryDto);
            return ResponseEntity.ok("Injury added successfully");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error while adding player");
        }
    }

    @GetMapping("/getInjuries")
    public ResponseEntity<?> getInjuries() {
        try {
            return ResponseEntity.ok(injuryService.getInjuries());
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error while fetching injuries");
        }
    }

    @GetMapping("/getInjuryById")
    public ResponseEntity<?> getInjury(@RequestParam int id) {
        try {
            return ResponseEntity.ok(injuryService.getInjuryById(id));
        }catch (InjuryNotFoundException e) {
            return ResponseEntity.status(500).body("Injury not found");
        }
        catch (Exception e) {
            return ResponseEntity.status(500).body("Error while fetching injuries");
        }
    }

    @PutMapping("/updateInjury")
    public ResponseEntity<?> updateInjury(UpdateInjuryDto updateInjuryDto) {
        try {
            injuryService.updateInjury(updateInjuryDto);
            return ResponseEntity.ok("Injury updated successfully");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error while updating injury");
        }
    }

    @GetMapping("/getInjuryByname")
    public ResponseEntity<?> getInjuryByname(@RequestParam String name) {
        try {
            return ResponseEntity.ok(injuryService.getInjuries());
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error while fetching injuries");
        }
    }
}