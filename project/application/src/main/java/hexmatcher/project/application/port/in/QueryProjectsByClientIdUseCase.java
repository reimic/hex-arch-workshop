package hexmatcher.project.application.port.in;

import hexmatcher.project.domain.valueobject.ClientId;

import java.util.List;

@FunctionalInterface
public interface QueryProjectsByClientIdUseCase {
    List<ProjectsByClientIdView> queryBy(ClientId clientId);
}
