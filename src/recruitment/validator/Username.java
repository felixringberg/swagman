/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recruitment.validator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 *
 * @author Marcus
 */
@Constraint(validatedBy = UsernameValidator.class)
@Documented
@Target({ElementType.ANNOTATION_TYPE, ElementType.METHOD, ElementType.FIELD})
@Retention(RUNTIME)
public @interface Username {
    String message() default "Not a valid Username!";
    java.lang.Class<?>[] groups() default {};
    java.lang.Class<? extends Payload>[] payload() default {};
}