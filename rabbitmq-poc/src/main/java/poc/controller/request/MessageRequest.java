package poc.controller.request;

import lombok.Builder;
import lombok.Data;
import poc.validations.ChangeStatusValidate;
import poc.validations.ChangeStatusValidationRule;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Builder
@ChangeStatusValidate(rule = ChangeStatusValidationRule.class)
public class MessageRequest {

    @NotBlank
    private String name;

    @NotBlank
    private String description;

    @NotNull
    private ChangeStatusRequest changeStatusRequest;
}
