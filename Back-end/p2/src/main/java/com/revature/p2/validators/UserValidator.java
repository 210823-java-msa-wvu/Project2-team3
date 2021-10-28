package com.revature.p2.validators;

import com.revature.p2.beans.DNDUser;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


@Component
public class UserValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return DNDUser.class.equals(aClass) ;
    }

    @Override
    public void validate(Object object, Errors errors) {
        DNDUser DNDUser = (DNDUser) object;
        if(DNDUser.getPassword().length() < 5){
            errors.rejectValue("password","Length", "Password must be at least 8 characters.");
        }
        if(!DNDUser.getPassword().equals(DNDUser.getConfirmPassword())){
            errors.rejectValue("confirmPassword", "Match", "Password must be Match");
        }
    }
}
