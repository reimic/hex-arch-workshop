package hexmatcher.project.application.usecase;

import hexmatcher.project.application.port.QueryClientByIdPort;
import hexmatcher.project.application.port.SaveProjectPort;
import hexmatcher.project.domain.entity.Client;
import hexmatcher.project.domain.entity.Project;
import hexmatcher.project.domain.valueobject.ClientId;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Validated
public class StartProjectUseCase {

    private static final String CLIENT_WITH_ID_NOT_FOUND = "Client with ID=%s not found.";
    private final QueryClientByIdPort queryClientByIdPort;
    private final SaveProjectPort saveProjectPort;

    @Transactional
    public String handle(@Valid StartProjectCommand startProjectCommand) {
        String clientId = startProjectCommand.clientId();
        Client client = queryClientByIdPort.queryBy(new ClientId(
                UUID.fromString(clientId)
        )).orElseThrow(()->new EntityNotFoundException(CLIENT_WITH_ID_NOT_FOUND.formatted(clientId)));
        Project project = Project.createNew(
                startProjectCommand.businessPriorityIndex(),
                startProjectCommand.name(),
                startProjectCommand.engagementManagerEmail(),
                startProjectCommand.description(),
                client
        );
        return saveProjectPort.save(project).toString();
    }

    public record StartProjectCommand(
            @Min(0) @Max(5) Double businessPriorityIndex,
            @NotBlank String name,
            String engagementManagerEmail,
            String description,
            @NotBlank String clientId)
    {
    }
}
