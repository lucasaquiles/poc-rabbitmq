package poc.controller.request;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ChangeStatusRequest {

    private String status;
    private LocalDateTime updatedAt;
}
