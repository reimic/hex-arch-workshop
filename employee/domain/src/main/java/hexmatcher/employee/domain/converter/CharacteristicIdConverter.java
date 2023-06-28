package hexmatcher.employee.domain.converter;

import hexmatcher.employee.domain.valueobject.TagId;

import java.util.UUID;

public class CharacteristicIdConverter extends UuidValueObjectConverter<TagId> {
    @Override
    public TagId convertToEntityAttribute(UUID dbData) {
        return new TagId(dbData);
    }
}
