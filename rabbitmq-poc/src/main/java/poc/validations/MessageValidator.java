package poc.validations;

import poc.controller.request.ChangeStatusRequest;
import poc.controller.request.MessageRequest;

import javax.validation.*;
import java.util.Arrays;
import java.util.Set;

public class MessageValidator implements ConstraintValidator<ChangeStatusValidate, MessageRequest> {


    @Override
    public boolean isValid(MessageRequest objectToValidate, ConstraintValidatorContext context) {

        boolean isValid = Arrays.stream(ChangeStatusValidationRule.values())
                    .filter(filter ->  {

                        return filter.getDescription().equalsIgnoreCase(objectToValidate.getChangeStatusRequest().getStatus()) &&
                                filter.apply(objectToValidate);

                            }
                    ).findAny().isPresent();

                ;

        return isValid;
    }

    public static void main(String[] args) {

        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();

        ChangeStatusRequest changeStatusDto = ChangeStatusRequest.builder()
                .status("Created")
                .motive("Created")
                .build();

        MessageRequest dto = MessageRequest
                .builder()
                .name("name")
                .description("description")
                .changeStatusRequest(changeStatusDto)
                .build();

        Set<ConstraintViolation<MessageRequest>> violations = validator.validate(dto);

        System.out.println("----------------------");
        System.out.println("-------- "+ violations.size() +" -----------");
        System.out.println("----------------------");


    }
}
