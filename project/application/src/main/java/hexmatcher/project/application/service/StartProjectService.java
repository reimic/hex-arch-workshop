package hexmatcher.project.application.service;

import hexmatcher.project.application.port.in.StartProjectCommand;
import hexmatcher.project.application.port.in.StartProjectUseCase;
import hexmatcher.project.application.port.out.QueryClientByIdPort;
import hexmatcher.project.application.port.out.SaveProjectPort;
import hexmatcher.project.domain.entity.Client;
import hexmatcher.project.domain.entity.Project;
import hexmatcher.project.domain.valueobject.ClientId;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
class StartProjectService implements StartProjectUseCase {

    private static final String CLIENT_WITH_ID_NOT_FOUND = "Client with ID=%s not found.";
    private final QueryClientByIdPort queryClientByIdPort;
    private final SaveProjectPort saveProjectPort;

    @Transactional
    @Override
    public String handle(StartProjectCommand startProjectCommand) {
        String clientId = startProjectCommand.getClientId();
        Client client = queryClientByIdPort.queryBy(new ClientId(
                UUID.fromString(clientId)
        )).orElseThrow(()->new EntityNotFoundException(CLIENT_WITH_ID_NOT_FOUND.formatted(clientId)));
        Project project = Project.createNew(
                startProjectCommand.getBusinessPriorityIndex(),
                startProjectCommand.getName(),
                startProjectCommand.getEngagementManagerEmail(),
                startProjectCommand.getDescription(),
                client
        );
        return saveProjectPort.save(project).toString();
    }
}
