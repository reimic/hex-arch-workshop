package hexmatcher.demand.adapter.out.db;

import hexmatcher.demand.application.port.QueryNumberOfProposedCandidatesForDemandPort;
import hexmatcher.demand.application.usecase.QueryNumberOfProposedCandidatesForDemandUseCase.CountProposedCandidateForDemandDto;
import hexmatcher.demand.domain.valueobject.DemandId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
class QueryNumberOfProposedCandidatesForDemandAdapter implements QueryNumberOfProposedCandidatesForDemandPort {

    private final DemandRepository demandRepository;
    @Override
    public CountProposedCandidateForDemandDto queryBy(DemandId demandId) {
        return demandRepository.queryBy(demandId);
    }
}
