package hexmatcher.demand.domain.converter;

import hexmatcher.demand.domain.valueobject.DemandDescription;
import jakarta.persistence.AttributeConverter;

public class DemandDescriptionConverter implements AttributeConverter<DemandDescription, String> {
    @Override
    public String convertToDatabaseColumn(DemandDescription attribute) {
        if (attribute == null) {
            return null;
        }
        return attribute.value();
    }

    @Override
    public DemandDescription convertToEntityAttribute(String dbData) {
        return new DemandDescription(dbData);
    }
}
