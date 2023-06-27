package hexmatcher.project.application.service;

import hexmatcher.project.application.port.in.RegisterClientCommand;
import hexmatcher.project.application.port.in.RegisterClientUseCase;
import hexmatcher.project.application.port.out.SaveClientPort;
import hexmatcher.project.domain.entity.Client;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
class RegisterClientService implements RegisterClientUseCase {

    private final SaveClientPort saveClientPort;

    @Transactional
    @Override
    public String handle(RegisterClientCommand registerClientCommand) {
        Client client = Client.createNew(
                registerClientCommand.getName(),
                registerClientCommand.getMarketUnit()
        );
        return saveClientPort.save(client).toString();
    }
}
