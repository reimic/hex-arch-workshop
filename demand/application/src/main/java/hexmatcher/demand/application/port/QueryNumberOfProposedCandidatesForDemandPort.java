package hexmatcher.demand.application.port;

import hexmatcher.demand.application.usecase.QueryNumberOfProposedCandidatesForDemandUseCase.CountProposedCandidateForDemandDto;
import hexmatcher.demand.domain.valueobject.DemandId;

@FunctionalInterface
public interface QueryNumberOfProposedCandidatesForDemandPort {
    CountProposedCandidateForDemandDto queryBy(DemandId demandId);
}
