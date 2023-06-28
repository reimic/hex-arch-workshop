package hexmatcher.tag.domain.converter;

import hexmatcher.tag.domain.valueobject.ShortName;

public class ShortNameConverter extends StringValueObjectConverter<ShortName> {

    @Override
    public ShortName convertToEntityAttribute(String dbData) {
        return new ShortName(dbData);
    }

}
