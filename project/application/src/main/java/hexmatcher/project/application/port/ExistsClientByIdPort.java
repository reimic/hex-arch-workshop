package hexmatcher.project.application.port;

import hexmatcher.project.domain.valueobject.ClientId;

@FunctionalInterface
public interface ExistsClientByIdPort {
    boolean existsById(ClientId clientId);
}
