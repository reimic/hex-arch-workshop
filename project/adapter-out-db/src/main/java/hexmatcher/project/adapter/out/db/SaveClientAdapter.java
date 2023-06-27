package hexmatcher.project.adapter.out.db;


import hexmatcher.project.application.port.out.SaveClientPort;
import hexmatcher.project.domain.entity.Client;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
@RequiredArgsConstructor
class SaveClientAdapter implements SaveClientPort {

    private final ClientRepository clientRepository;
    @Override
    public UUID save(Client client) {
//        return clientRepository.save(client).getClientId().value();
        return clientRepository.save(client).getClientId().value();
    }
}
