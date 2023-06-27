package hexmatcher.project.domain.converter;

import hexmatcher.project.domain.valueobject.ProjectId;

import java.util.UUID;

public class ProjectIdConverter extends UuidValueObjectConverter<ProjectId> {
    @Override
    public ProjectId convertToEntityAttribute(UUID dbData) {
        return new ProjectId(dbData);
    }
}
