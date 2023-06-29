package hexmatcher.project.application.usecase;

import hexmatcher.project.application.port.SaveClientPort;
import hexmatcher.project.domain.entity.Client;
import hexmatcher.project.domain.entity.MarketUnit;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

@Service
@RequiredArgsConstructor
@Validated
public class RegisterClientUseCase {

    private final SaveClientPort saveClientPort;

    @Transactional
    public String handle(@Valid RegisterClientCommand registerClientCommand) {
        Client client = Client.createNew(
                registerClientCommand.name(),
                registerClientCommand.marketUnit()
        );
        return saveClientPort.save(client).toString();
    }

    public record RegisterClientCommand(@NotBlank String name, @NotNull MarketUnit marketUnit) {
    }
}
