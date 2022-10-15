package com.boshen.seckill.vo;

import com.boshen.seckill.utils.ValidatorUtil;
import com.boshen.seckill.validator.isMobile;
import org.thymeleaf.util.StringUtils;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class isMobileValidator implements ConstraintValidator<isMobile,String> {

    private boolean required = false;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (required){
            return ValidatorUtil.isMobile(value);
        }else{
            if(StringUtils.isEmpty(value)){
                return true;
            }else{
                return ValidatorUtil.isMobile(value);
            }
        }
    }

    @Override
    public void initialize(isMobile constraintAnnotation) {
        required = constraintAnnotation.required();
    }
}
