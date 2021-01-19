package com.fimba.WarehouseManagmentSystem.Validations;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;


@Constraint(validatedBy = WarehouseDuplicateValidation.class)
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
public @interface NotExist {
    String message() default "{Duplicate data}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}

