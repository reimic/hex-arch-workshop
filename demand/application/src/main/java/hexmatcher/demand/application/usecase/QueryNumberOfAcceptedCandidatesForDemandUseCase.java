package hexmatcher.demand.application.usecase;

import hexmatcher.demand.application.port.QueryNumberOfAcceptedCandidatesForDemandPort;
import hexmatcher.demand.domain.valueobject.DemandId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class QueryNumberOfAcceptedCandidatesForDemandUseCase {


    private final QueryNumberOfAcceptedCandidatesForDemandPort queryNumberOfAcceptedCandidatesForDemandPort;

    public Optional<CountAcceptedCandidateForDemandView> queryBy(DemandId demandId) {
        return queryNumberOfAcceptedCandidatesForDemandPort.queryBy(demandId);
    }

    public record CountAcceptedCandidateForDemandView(
            String demandId,
            long acceptedCandidates
    ) {
        public CountAcceptedCandidateForDemandView(DemandId demandId, long acceptedCandidates) {
            this(demandId.value().toString(), acceptedCandidates);
        }
    }
}
