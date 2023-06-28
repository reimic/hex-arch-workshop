package hexmatcher.tag.domain.valueobject;

import java.io.Serializable;
import java.util.UUID;

public record EmployeeId(UUID value) implements ValueObject<UUID>, Serializable {

    public EmployeeId {
        if (value == null) {
            throw new ValidationException("Employee id can not be null.");
        }
    }

}
