package hexmatcher.demand.domain.converter;

import hexmatcher.demand.domain.valueobject.EmployeeId;

import java.util.UUID;

public class EmployeeIdConverter extends UuidValueObjectConverter<EmployeeId> {
    @Override
    public EmployeeId convertToEntityAttribute(UUID dbData) {
        return new EmployeeId(dbData);
    }
}
