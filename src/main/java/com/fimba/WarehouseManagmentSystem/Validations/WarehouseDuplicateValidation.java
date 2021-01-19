package com.fimba.WarehouseManagmentSystem.Validations;

import com.fimba.WarehouseManagmentSystem.Dao.WarehouseRepository.WarehouseOperationRepository;
import lombok.RequiredArgsConstructor;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
@RequiredArgsConstructor
public class WarehouseDuplicateValidation implements ConstraintValidator<NotExist, String> {
    private final WarehouseOperationRepository warehouseOperationRepository;


    @Override
    public void initialize(NotExist constraintAnnotation) {

    }

    @Override
    public boolean isValid(String code, ConstraintValidatorContext constraintValidatorContext) {
        return !warehouseOperationRepository.hasExistSameWarehouseCode(code);
    }
}
