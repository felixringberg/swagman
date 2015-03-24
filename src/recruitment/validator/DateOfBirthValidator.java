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
 * @author Felix Ringberg
 */
public class DateOfBirthValidator  implements ConstraintValidator<DateOfBirth, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return !(value.charAt(4) != '-' || value.charAt(7) != '-');
    }

    @Override
    public void initialize(DateOfBirth constraintAnnotation) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
