package hexmatcher.demand.application.port;

import hexmatcher.demand.application.usecase.QueryNumberOfProposedCandidatesForDemandUseCase.CountProposedCandidateForDemandProjection;
import hexmatcher.demand.domain.valueobject.DemandId;

import java.util.Optional;

@FunctionalInterface
public interface QueryNumberOfProposedCandidatesForDemandPort {
    Optional<CountProposedCandidateForDemandProjection> queryBy(DemandId demandId);
}
