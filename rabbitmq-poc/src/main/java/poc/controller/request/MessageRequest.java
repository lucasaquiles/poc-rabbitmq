package poc.controller.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class MessageRequest {

    @NotBlank
    private String name;

    @NotBlank
    private String description;
}
