package hexmatcher.demand.domain.converter;

import hexmatcher.demand.domain.valueobject.TagId;

import java.util.UUID;

public class TagIdConverter extends UuidValueObjectConverter<TagId> {
    @Override
    public TagId convertToEntityAttribute(UUID dbData) {
        return new TagId(dbData);
    }
}
