package hexmatcher.project.application.port;

import hexmatcher.project.application.usecase.QueryProjectsByClientIdUseCase.ProjectsByClientIdView;
import hexmatcher.project.domain.valueobject.ClientId;

import java.util.List;

@FunctionalInterface
public interface QueryProjectsByClientIdPort {
    List<ProjectsByClientIdView> queryBy(ClientId clientId);
}
