package hexmatcher.employee.domain.valueobject;

import hexmatcher.employee.domain.converter.ValueObject;

import java.util.UUID;

public record EmployeeId(UUID value) implements ValueObject<UUID> {
}
