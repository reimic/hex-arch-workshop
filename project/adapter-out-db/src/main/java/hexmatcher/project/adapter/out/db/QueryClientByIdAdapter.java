package hexmatcher.project.adapter.out.db;

import hexmatcher.project.application.port.out.QueryClientByIdPort;
import hexmatcher.project.domain.entity.Client;
import hexmatcher.project.domain.valueobject.ClientId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
class QueryClientByIdAdapter implements QueryClientByIdPort {

    private final ClientRepository clientRepository;
    @Override
    public Optional<Client> queryBy(ClientId clientId) {
        return clientRepository.findById(clientId);
    }
}
