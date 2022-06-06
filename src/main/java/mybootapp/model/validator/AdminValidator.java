package mybootapp.model.validator;

import mybootapp.model.user.UserApp;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class AdminValidator implements Validator{
    @Override
    public boolean supports(Class<?> clazz) {
        return UserApp.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserApp user = (UserApp) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstname",
                "user.firstname", "Field name is required.");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastname",
                "user.lastname", "Field name is required.");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email",
                "user.email", "Field description is required.");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password",
                "user.password", "Field type is required.");

        if (!(user.getAdmin().getKey() > 999)) {
            errors.rejectValue("securekey", "user.securekey.too.low",
                    "Price too low");
        }
    }
}
