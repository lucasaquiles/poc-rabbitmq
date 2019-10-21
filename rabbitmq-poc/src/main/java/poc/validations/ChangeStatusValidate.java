package poc.validations;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Constraint(validatedBy = MessageValidator.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ChangeStatusValidate {

    Class<?> rule();
    String message() default "{application.message.default}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default{};
}
