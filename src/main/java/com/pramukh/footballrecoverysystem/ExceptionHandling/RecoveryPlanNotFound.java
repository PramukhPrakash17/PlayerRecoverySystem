package com.pramukh.footballrecoverysystem.ExceptionHandling;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class RecoveryPlanNotFound extends RuntimeException {
    public RecoveryPlanNotFound(String message) {
        super(message);
    }
}
