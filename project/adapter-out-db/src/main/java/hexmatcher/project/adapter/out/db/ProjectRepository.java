package hexmatcher.project.adapter.out.db;

import hexmatcher.project.application.usecase.QueryProjectsByClientIdUseCase.ProjectsByClientIdView;
import hexmatcher.project.domain.entity.Project;
import hexmatcher.project.domain.valueobject.ClientId;
import hexmatcher.project.domain.valueobject.ProjectId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

interface ProjectRepository extends JpaRepository<Project, ProjectId> {

    @Query("""
            select 
                c.name as clientName,
                c.marketUnit as marketUnit,
                p.name as projectName,
                p.engagementManagerEmail as engagementManagerEmail,
                p.description as projectDescription
            from Project p
            join p.client c
            where c.clientId = :clientId
            """)
    List<ProjectsByClientIdView> queryBy(@Param("clientId") ClientId clientId);

}
