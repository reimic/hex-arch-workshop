package hexmatcher.employee.domain.valueobject;

import hexmatcher.employee.domain.converter.ValueObject;

import java.io.Serializable;
import java.util.UUID;

public record TagId(UUID value) implements ValueObject<UUID>, Serializable {
}
