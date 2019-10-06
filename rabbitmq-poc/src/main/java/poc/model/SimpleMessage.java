package poc.model;

import lombok.AllArgsConstructor;
import lombok.Builder;

import java.io.Serializable;

@AllArgsConstructor
@Builder
public class SimpleMessage  implements Serializable {

    private String name;
    private String description;
}
