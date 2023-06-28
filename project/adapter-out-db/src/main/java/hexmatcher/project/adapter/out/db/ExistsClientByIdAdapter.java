package hexmatcher.project.adapter.out.db;

import hexmatcher.project.application.port.ExistsClientByIdPort;
import hexmatcher.project.domain.valueobject.ClientId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
class ExistsClientByIdAdapter implements ExistsClientByIdPort {

    private final ClientRepository clientRepository;
    @Override
    public boolean existsById(ClientId clientId) {
        return clientRepository.existsById(clientId);
    }
}
