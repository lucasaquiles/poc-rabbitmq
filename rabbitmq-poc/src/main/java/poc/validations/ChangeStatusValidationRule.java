package poc.validations;

import org.springframework.util.StringUtils;
import poc.controller.request.MessageRequest;

public enum ChangeStatusValidationRule implements Validavel<MessageRequest> {

    CREATED("created") {
        @Override
        public boolean apply(MessageRequest validable) {
            return !StringUtils.isEmpty(validable.getChangeStatusRequest().getMotive());
        }
    },
    WAITING("Waiting") {
        @Override
        public boolean apply(MessageRequest validable) {
            return true;
        }
    },
    FINISHED("Finished") {
        @Override
        public boolean apply(MessageRequest validable) {
            return true;
        }
    },
    CANCELED("Canceled") {
        @Override
        public boolean apply(MessageRequest validable) {
            return true;
        }
    };

    private String description;

    ChangeStatusValidationRule(String description) {

        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    abstract public boolean apply(MessageRequest validatable);

}
