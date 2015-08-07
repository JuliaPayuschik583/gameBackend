package game.tictactoe.validate;

import game.tictactoe.domain.User;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.List;

/**
 * @author julia
 */
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {JustTwoUsers.Validator.class})
public @interface JustTwoUsers {

    class Validator implements ConstraintValidator<JustTwoUsers, List<User>> {

        private final int amountOfusers = 2;

        @Override
        public void initialize(final JustTwoUsers justTwoUsers) {

        }

        @Override
        public boolean isValid(final List<User> users, final ConstraintValidatorContext constraintValidatorContext) {
            if (users == null || users.isEmpty() || users.size() != amountOfusers) {
                return false;
            }
            for (User user : users) {
                if (user == null || user.getId() == null || user.getLogin() == null || user.getPassword() == null) {
                    return false;
                }
            }
            return true;
        }
    }
}
