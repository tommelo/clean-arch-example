package com.itgorillaz.core.command;

import java.util.Optional;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

public class Guard {

    private static Validator validator = Validation
        .buildDefaultValidatorFactory()
        .getValidator();
    
    public static <T> Optional<Set<ConstraintViolation<T>>> constraints(T target) {
        return Optional.ofNullable(validator.validate(target));
    }
    
}
