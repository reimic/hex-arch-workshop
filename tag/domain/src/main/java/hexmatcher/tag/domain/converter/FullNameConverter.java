package hexmatcher.tag.domain.converter;

import hexmatcher.tag.domain.valueobject.FullName;

public class FullNameConverter extends StringValueObjectConverter<FullName> {

    @Override
    public FullName convertToEntityAttribute(String dbData) {
        return new FullName(dbData);
    }

}
