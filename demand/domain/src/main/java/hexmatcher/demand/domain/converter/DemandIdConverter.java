package hexmatcher.demand.domain.converter;

import hexmatcher.demand.domain.valueobject.DemandId;

import java.util.UUID;

public class DemandIdConverter extends UuidValueObjectConverter<DemandId> {
    @Override
    public DemandId convertToEntityAttribute(UUID dbData) {
        return new DemandId(dbData);
    }
}
