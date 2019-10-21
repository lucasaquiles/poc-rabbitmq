package poc.controller.request;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class ChangeStatusRequest {

    private String status;
    private LocalDateTime updatedAt;
    private String motive;
}
