package hexmatcher.project.application.usecase;

import hexmatcher.project.application.port.SaveClientPort;
import hexmatcher.project.domain.entity.Client;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class RegisterClientUseCase {

    private final SaveClientPort saveClientPort;

    @Transactional
    public String handle(RegisterClientCommand registerClientCommand) {
        Client client = Client.createNew(
                registerClientCommand.getName(),
                registerClientCommand.getMarketUnit()
        );
        return saveClientPort.save(client).toString();
    }
}
