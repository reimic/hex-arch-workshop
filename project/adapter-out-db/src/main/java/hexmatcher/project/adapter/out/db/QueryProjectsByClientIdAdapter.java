package hexmatcher.project.adapter.out.db;

import hexmatcher.project.application.port.in.ProjectsByClientIdView;
import hexmatcher.project.application.port.out.QueryProjectsByClientIdPort;
import hexmatcher.project.domain.valueobject.ClientId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
class QueryProjectsByClientIdAdapter implements QueryProjectsByClientIdPort {

    private final ProjectRepository projectRepository;

    @Override
    public List<ProjectsByClientIdView> queryBy(ClientId clientId) {
        return projectRepository.queryBy(clientId);
    }
}
