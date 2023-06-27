package hexmatcher.project.application.port.out;

import hexmatcher.project.domain.entity.Project;

import java.util.UUID;

@FunctionalInterface
public interface SaveProjectPort {
    UUID save(Project project);
}

