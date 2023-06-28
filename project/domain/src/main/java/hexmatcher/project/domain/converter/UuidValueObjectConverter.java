package hexmatcher.project.domain.converter;

import hexmatcher.project.domain.valueobject.ValueObject;
import jakarta.persistence.AttributeConverter;

import java.util.UUID;

public abstract class UuidValueObjectConverter<T extends ValueObject<UUID>> implements AttributeConverter<T, UUID> {
    @Override
    public UUID convertToDatabaseColumn(T attribute) {
        if (attribute == null) {
            return null;
        }
        return attribute.value();
    }
}
