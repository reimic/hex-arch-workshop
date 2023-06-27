package hexmatcher.project.application.service;

import hexmatcher.project.application.port.in.ProjectsByClientIdView;
import hexmatcher.project.application.port.in.QueryProjectsByClientIdUseCase;
import hexmatcher.project.application.port.out.QueryProjectsByClientIdPort;
import hexmatcher.project.domain.valueobject.ClientId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
class QueryProjectsByClientIdService implements QueryProjectsByClientIdUseCase {

    private final QueryProjectsByClientIdPort queryProjectsByClientIdPort;
    @Override
    public List<ProjectsByClientIdView> queryBy(ClientId clientId) {
        return queryProjectsByClientIdPort.queryBy(clientId);
    }
}
