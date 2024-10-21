package com.gilasoftware.notification_api.domain.utils;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.Arrays;

public class EnumValidator implements ConstraintValidator<CategoryValidator, Enum<?>> {

    private Class<? extends Enum<?>> enumClass;

    @Override
    public void initialize(CategoryValidator annotation) {
        this.enumClass = annotation.enumClass();
    }

    @Override
    public boolean isValid(Enum<?> value, ConstraintValidatorContext context) {
        if (value == null) {
            return true; // `@NotNull` deve ser usado para validar null
        }

        return Arrays.stream(enumClass.getEnumConstants())
                     .anyMatch(e -> e.equals(value));
    }
}
