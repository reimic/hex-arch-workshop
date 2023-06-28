package hexmatcher.tag.domain.converter;

import hexmatcher.tag.domain.valueobject.TagId;

import java.util.UUID;

public class TagIdConverter extends UuidValueObjectConverter<TagId> {

    @Override
    public TagId convertToEntityAttribute(UUID dbData) {
        return new TagId(dbData);
    }

}
