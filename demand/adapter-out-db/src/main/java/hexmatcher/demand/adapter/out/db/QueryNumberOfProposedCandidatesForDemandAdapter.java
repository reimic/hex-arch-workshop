package hexmatcher.demand.adapter.out.db;

import hexmatcher.demand.application.port.QueryNumberOfProposedCandidatesForDemandPort;
import hexmatcher.demand.application.usecase.QueryNumberOfProposedCandidatesForDemandUseCase.CountProposedCandidateForDemandProjection;
import hexmatcher.demand.domain.valueobject.DemandId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
class QueryNumberOfProposedCandidatesForDemandAdapter implements QueryNumberOfProposedCandidatesForDemandPort {

    private final DemandRepository demandRepository;
    @Override
    public Optional<CountProposedCandidateForDemandProjection> queryBy(DemandId demandId) {
        return demandRepository.queryForProposedByProjection(demandId);
    }
}
