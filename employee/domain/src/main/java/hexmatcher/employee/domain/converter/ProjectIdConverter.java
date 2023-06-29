package hexmatcher.employee.domain.converter;

import hexmatcher.employee.domain.valueobject.ProjectId;

import java.util.UUID;

public class ProjectIdConverter extends UuidValueObjectConverter<ProjectId>{
    @Override
    public ProjectId convertToEntityAttribute(UUID dbValue) {
        return new ProjectId(dbValue);
    }
}
