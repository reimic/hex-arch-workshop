package hexmatcher.project.adapter.out.db;

import hexmatcher.project.domain.entity.Project;
import hexmatcher.project.domain.valueobject.ProjectId;
import org.springframework.data.jpa.repository.JpaRepository;

interface ProjectRepository extends JpaRepository<Project, ProjectId> {
}
