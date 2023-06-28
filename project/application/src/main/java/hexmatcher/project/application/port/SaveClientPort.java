package hexmatcher.project.application.port;

import hexmatcher.project.domain.entity.Client;

import java.util.UUID;

@FunctionalInterface
public interface SaveClientPort {
    UUID save(Client client);
}
