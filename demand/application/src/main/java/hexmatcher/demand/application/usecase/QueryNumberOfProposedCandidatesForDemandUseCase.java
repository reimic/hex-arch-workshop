package hexmatcher.demand.application.usecase;

import hexmatcher.demand.application.port.QueryNumberOfProposedCandidatesForDemandPort;
import hexmatcher.demand.domain.valueobject.DemandId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class QueryNumberOfProposedCandidatesForDemandUseCase {


    private final QueryNumberOfProposedCandidatesForDemandPort queryNumberOfProposedCandidatesForDemandPort;

    public CountProposedCandidateForDemandView queryBy(DemandId demandId) {
        return queryNumberOfProposedCandidatesForDemandPort.queryBy(demandId);
    }

    public record CountProposedCandidateForDemandView(
            String demandId,
            long proposedCandidates
    ) {
        public CountProposedCandidateForDemandView(DemandId demandId, long proposedCandidates) {
            this(demandId == null ? null : demandId.value().toString(), proposedCandidates);
        }
    }
}
