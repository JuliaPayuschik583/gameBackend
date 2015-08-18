package game.tictactoe.validate;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author julia
 */
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {Email.Validator.class})
public @interface Email {

    String REGEXP_EMAIL = "^[A-Za-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[A-Za-z0-9!#$%&'*+/=?^_`{|}~-]+)*@" +
            "(?:[A-Za-z0-9](?:[A-Za-z0-9-]*[A-Za-z0-9])?\\.)+[A-Za-z0-9](?:[A-Za-z0-9-]*[A-Za-z0-9])?$";

    boolean canBeNullOrEmpty() default false;

    class Validator implements ConstraintValidator<Email, String> {
        private boolean canBeNullOrEmpty;

        @Override
        public void initialize(final Email email) {
            canBeNullOrEmpty = email.canBeNullOrEmpty();
        }

        @Override
        public boolean isValid(final String email, final ConstraintValidatorContext constraintValidatorContext) {
            if (email == null || email.isEmpty()) {
                return canBeNullOrEmpty;
            }
            return email.matches(REGEXP_EMAIL);
        }
    }
}
