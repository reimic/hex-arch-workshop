package hexmatcher.project.domain.valueobject;

import hexmatcher.project.domain.converter.ValueObject;

import java.util.UUID;

public record ProjectId(UUID value) implements ValueObject<UUID> {
}
