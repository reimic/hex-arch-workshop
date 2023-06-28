package hexmatcher.project.application.port;

import hexmatcher.project.domain.entity.Client;
import hexmatcher.project.domain.valueobject.ClientId;

import java.util.Optional;

@FunctionalInterface
public interface QueryClientByIdPort {
    Optional<Client> queryBy(ClientId clientId);
}
