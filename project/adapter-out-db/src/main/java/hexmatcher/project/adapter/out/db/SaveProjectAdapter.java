package hexmatcher.project.adapter.out.db;

import hexmatcher.project.application.port.SaveProjectPort;
import hexmatcher.project.domain.entity.Project;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
@RequiredArgsConstructor
class SaveProjectAdapter implements SaveProjectPort {

    private final ProjectRepository projectRepository;
    @Override
    public UUID save(Project project) {
        return projectRepository.save(project).getProjectId().value();
    }
}
