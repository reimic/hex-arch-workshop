package hexmatcher.project.application.usecase;

import hexmatcher.project.application.port.ExistsClientByIdPort;
import hexmatcher.project.application.port.QueryProjectsByClientIdPort;
import hexmatcher.project.domain.entity.MarketUnit;
import hexmatcher.project.domain.valueobject.ClientId;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QueryProjectsByClientIdUseCase {

    private static final String CLIENT_WITH_ID_NOT_FOUND = "Client with ID=%s not found.";
    private final QueryProjectsByClientIdPort queryProjectsByClientIdPort;
    private final ExistsClientByIdPort existsClientByIdPort;

    public List<ProjectsByClientIdView> queryBy(ClientId clientId) {
        if (!existsClientByIdPort.existsById(clientId)){
            throw new EntityNotFoundException(CLIENT_WITH_ID_NOT_FOUND.formatted(clientId.value()));
        }
        return queryProjectsByClientIdPort.queryBy(clientId);
    }

    public interface ProjectsByClientIdView {
        String getClientName();
        MarketUnit getMarketUnit();
        String getProjectName();
        String getEngagementManagerEmail();
        String getProjectDescription();
    }
}
