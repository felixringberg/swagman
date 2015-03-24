/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recruitment.validator;

import java.lang.annotation.Documented;
import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import java.lang.annotation.Retention;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Target;
import static javax.persistence.AccessType.FIELD;
import javax.validation.Constraint;
import static javax.validation.ElementKind.METHOD;

/**
 *
 * @author Oskar
 */

@Constraint(validatedBy = PasswordValidator.class)
@Documented
@Target({ANNOTATION_TYPE, METHOD, FIELD})
@Retention(RUNTIME)
public @interface Password {
    String message() default "Not a valid password";
    java.lang.Class<?>[] groups() default {};
    java.lang.Class<? extends Payload>[] payload() default {};
}
