package org.geektimes.projects.user.validator.bean.validation;

import org.geektimes.projects.user.domain.User;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UserValidAnnotationValidator implements ConstraintValidator<UserValid, String> {

    private int idRange;

    private boolean chinesePhoneNumber;

    private String message;

    public void initialize(UserValid annotation) {
        this.idRange = annotation.idRange();
        this.chinesePhoneNumber = annotation.chinesePhoneNumber();
        this.message = annotation.message();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        if ( chinesePhoneNumber == false || value.matches("[0-9]{11}")) {
            return true;
        }

        // 获取模板信息
//        context.getDefaultConstraintMessageTemplate();

        context.disableDefaultConstraintViolation();
        context.buildConstraintViolationWithTemplate("Phone number error. (It should be a 11-digit integer.)").addConstraintViolation();

        return false;
    }
}
