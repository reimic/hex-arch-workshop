package hexmatcher.demand.adapter.out.db;

import hexmatcher.demand.application.port.QueryNumberOfProposedCandidatesForDemandPort;
import hexmatcher.demand.application.usecase.QueryNumberOfProposedCandidatesForDemandUseCase.CountProposedCandidateForDemandView;
import hexmatcher.demand.domain.valueobject.DemandId;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
class QueryNumberOfProposedCandidatesForDemandAdapter implements QueryNumberOfProposedCandidatesForDemandPort {
    private static final String DEMAND_WITH_ID_DOES_NOT_EXIST = "Demand with ID=%s does not exist.";

    private final DemandRepository demandRepository;
    @Override
    public CountProposedCandidateForDemandView queryBy(DemandId demandId) {
        CountProposedCandidateForDemandView countProposedCandidateForDemandView = demandRepository.queryBy(demandId);
        if (countProposedCandidateForDemandView.demandId()==null){
            throw new EntityNotFoundException(DEMAND_WITH_ID_DOES_NOT_EXIST.formatted(demandId.value()));
        }
        return countProposedCandidateForDemandView;
    }
}
