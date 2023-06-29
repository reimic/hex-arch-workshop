package hexmatcher.employee.domain.converter;

import hexmatcher.employee.domain.valueobject.TagId;

import java.util.UUID;

public class TagIdConverter extends UuidValueObjectConverter<TagId>{
    @Override
    public TagId convertToEntityAttribute(UUID dbValue) {
        return new TagId(dbValue);
    }
}
