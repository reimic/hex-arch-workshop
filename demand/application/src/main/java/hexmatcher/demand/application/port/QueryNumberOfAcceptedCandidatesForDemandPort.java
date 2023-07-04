package hexmatcher.demand.application.port;

import hexmatcher.demand.application.usecase.QueryNumberOfAcceptedCandidatesForDemandUseCase.CountAcceptedCandidateForDemandView;
import hexmatcher.demand.domain.valueobject.DemandId;

import java.util.Optional;

@FunctionalInterface
public interface QueryNumberOfAcceptedCandidatesForDemandPort {
    Optional<CountAcceptedCandidateForDemandView> queryBy(DemandId demandId);
}
