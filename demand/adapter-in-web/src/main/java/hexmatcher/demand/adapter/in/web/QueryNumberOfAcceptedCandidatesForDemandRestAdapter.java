package hexmatcher.demand.adapter.in.web;

import hexmatcher.demand.application.usecase.QueryNumberOfAcceptedCandidatesForDemandUseCase;
import hexmatcher.demand.application.usecase.QueryNumberOfAcceptedCandidatesForDemandUseCase.CountAcceptedCandidateForDemandView;
import hexmatcher.demand.domain.valueobject.DemandId;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@Slf4j
@RestController
@RequiredArgsConstructor
class QueryNumberOfAcceptedCandidatesForDemandRestAdapter {

    private static final String DEMAND_WITH_ID_DOES_NOT_EXIST = "Demand with ID='%s' does not exist.";
    private final QueryNumberOfAcceptedCandidatesForDemandUseCase queryNumberOfAcceptedCandidatesForDemandUseCase;

    @GetMapping("demands/{demandId}/count-accepted-candidates")
    CountAcceptedCandidateForDemandView countProposedCandidates(@PathVariable String demandId){
        return queryNumberOfAcceptedCandidatesForDemandUseCase.queryBy(new DemandId(UUID.fromString(demandId)))
                .orElseThrow(()->new EntityNotFoundException(DEMAND_WITH_ID_DOES_NOT_EXIST.formatted(demandId)));
    }
}
