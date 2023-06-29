package hexmatcher.demand.application.usecase;

import hexmatcher.demand.application.port.QueryDemandByIdPort;
import hexmatcher.demand.domain.entity.Demand;
import hexmatcher.demand.domain.valueobject.CandidateId;
import hexmatcher.demand.domain.valueobject.DemandId;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

@Service
@RequiredArgsConstructor
@Validated
public class RejectCandidateUseCase {

    private static final String DEMAND_WITH_ID_NOT_FOUND = "Demand with ID='%s' not found.";
    private final QueryDemandByIdPort queryDemandByIdPort;

    @Transactional
    public void handle(@Valid RejectCandidateCommand rejectCandidateCommand){
        DemandId demandId = rejectCandidateCommand.demandId();
        Demand demand = queryDemandByIdPort.queryBy(demandId)
                .orElseThrow(()->new EntityNotFoundException(DEMAND_WITH_ID_NOT_FOUND.formatted(demandId.value())));
        demand.rejectCandidate(rejectCandidateCommand.candidateId());
    }

    public record RejectCandidateCommand(@NotNull DemandId demandId, @NotNull CandidateId candidateId) {
    }

}
