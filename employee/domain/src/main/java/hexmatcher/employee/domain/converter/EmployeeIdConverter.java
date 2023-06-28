package hexmatcher.employee.domain.converter;

import hexmatcher.employee.domain.valueobject.EmployeeId;

import java.util.UUID;

public class EmployeeIdConverter extends UuidValueObjectConverter<EmployeeId> {
    @Override
    public EmployeeId convertToEntityAttribute(UUID dbData) {
        return new EmployeeId(dbData);
    }
}
