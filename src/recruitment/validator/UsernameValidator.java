/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recruitment.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 *
 * @author Marcus
 */
public class UsernameValidator implements ConstraintValidator<Username, String>{

    @Override
    public void initialize(Username constraintAnnotation) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        boolean valid;
        if(value.length() < 6)
            return valid = false;
        for(int i = 0; i < value.length(); i++){
            if(!(Character.isDigit(value.charAt(i)) || Character.isLetter(value.charAt(i))))
                return valid = false;
        }
        return valid = true;
    }
    
}