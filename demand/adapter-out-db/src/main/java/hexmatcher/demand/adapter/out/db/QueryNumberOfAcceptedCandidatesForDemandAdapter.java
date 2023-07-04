package hexmatcher.demand.adapter.out.db;

import hexmatcher.demand.application.port.QueryNumberOfAcceptedCandidatesForDemandPort;
import hexmatcher.demand.application.usecase.QueryNumberOfAcceptedCandidatesForDemandUseCase.CountAcceptedCandidateForDemandView;
import hexmatcher.demand.domain.valueobject.DemandId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
class QueryNumberOfAcceptedCandidatesForDemandAdapter implements QueryNumberOfAcceptedCandidatesForDemandPort {

    private final DemandRepository demandRepository;
    @Override
    public Optional<CountAcceptedCandidateForDemandView> queryBy(DemandId demandId) {
        return demandRepository.queryForAcceptedBy(demandId);
    }
}
