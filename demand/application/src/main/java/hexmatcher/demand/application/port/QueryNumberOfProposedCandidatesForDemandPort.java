package hexmatcher.demand.application.port;

import hexmatcher.demand.application.usecase.QueryNumberOfProposedCandidatesForDemandUseCase.CountProposedCandidateForDemandView;
import hexmatcher.demand.domain.valueobject.DemandId;

@FunctionalInterface
public interface QueryNumberOfProposedCandidatesForDemandPort {
    CountProposedCandidateForDemandView queryBy(DemandId demandId);
}
