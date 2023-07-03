package hexmatcher.demand.adapter.in.web;

import hexmatcher.demand.application.usecase.QueryNumberOfProposedCandidatesForDemandUseCase;
import hexmatcher.demand.application.usecase.QueryNumberOfProposedCandidatesForDemandUseCase.CountProposedCandidateForDemandView;
import hexmatcher.demand.domain.valueobject.DemandId;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@Slf4j
@RestController
@RequiredArgsConstructor
class QueryNumberOfProposedCandidatesForDemandRestAdapter {

    private final QueryNumberOfProposedCandidatesForDemandUseCase queryNumberOfProposedCandidatesForDemandUseCase;

    @GetMapping("demands/{demandId}/count-proposed-candidates")
    CountProposedCandidateForDemandView countProposedCandidates(@PathVariable String demandId){
        return queryNumberOfProposedCandidatesForDemandUseCase.queryBy(new DemandId(UUID.fromString(demandId)));
    }
}
