/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recruitment.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import recruitment.business.ValidationException;

/**
 *
 * @author Oskar
 */
public class PasswordValidator implements ConstraintValidator<Password, String>{

    @Override
    public void initialize(Password constraintAnnotation) {}

    @Override
    public boolean isValid(String password, ConstraintValidatorContext context) {
        boolean charCheck = true;
        
        // Password validation
        for(int i = 0; i < password.length(); i++)
            if(!(Character.isDigit(password.charAt(i)) || Character.isLetter(password.charAt(i))))
               charCheck = false; //throw new ValidationException("Passwords may only contain letters A-Z, a-z or numbers 0-9");
        
        return password.length() > 6  && charCheck;
    }
    
}
