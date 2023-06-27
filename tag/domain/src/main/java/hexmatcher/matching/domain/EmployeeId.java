package hexmatcher.matching.domain;

import java.util.UUID;

public record EmployeeId(UUID id) {

    public EmployeeId {
        if (id == null) {
            throw new ValidationException("Employee id can not be null.");
        }
    }

}
