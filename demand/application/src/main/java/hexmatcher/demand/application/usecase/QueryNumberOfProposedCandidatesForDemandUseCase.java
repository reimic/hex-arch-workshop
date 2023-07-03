package hexmatcher.demand.application.usecase;

import hexmatcher.demand.application.port.ExistsDemandByIdPort;
import hexmatcher.demand.application.port.QueryNumberOfProposedCandidatesForDemandPort;
import hexmatcher.demand.domain.valueobject.DemandId;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class QueryNumberOfProposedCandidatesForDemandUseCase {

    private static final String DEMAND_WITH_ID_DOES_NOT_EXIST = "Demand with ID=%s does not exist.";

    private final QueryNumberOfProposedCandidatesForDemandPort queryNumberOfProposedCandidatesForDemandPort;
    private final ExistsDemandByIdPort existsDemandByIdPort;

    public CountProposedCandidateForDemandDto queryBy(DemandId demandId) {
        if (!existsDemandByIdPort.existsById(demandId)){
            throw new EntityNotFoundException(DEMAND_WITH_ID_DOES_NOT_EXIST.formatted(demandId.value()));
        }
        return queryNumberOfProposedCandidatesForDemandPort.queryBy(demandId);
    }

    public record CountProposedCandidateForDemandDto(
            String demandId,
            long proposedCandidates
    ) {
        public CountProposedCandidateForDemandDto(DemandId demandId, long proposedCandidates) {
            this(demandId == null ? null : demandId.value().toString(), proposedCandidates);
        }
    }
}
