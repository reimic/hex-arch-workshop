package hexmatcher.demand.application.usecase;

import hexmatcher.demand.application.port.QueryDemandByIdPort;
import hexmatcher.demand.domain.entity.Demand;
import hexmatcher.demand.domain.valueobject.DemandId;
import hexmatcher.demand.domain.valueobject.EmployeeId;
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
public class ProposeCandidateUseCase {

    private static final String DEMAND_WITH_ID_NOT_FOUND = "Demand with ID='%s' not found.";
    private final QueryDemandByIdPort queryDemandByIdPort;

    @Transactional
    public String handle(@Valid ProposeCandidateCommand proposeCandidateCommand){
        DemandId demandId = proposeCandidateCommand.demandId();
        Demand demand = queryDemandByIdPort.queryBy(demandId)
                .orElseThrow(()->new EntityNotFoundException(DEMAND_WITH_ID_NOT_FOUND.formatted(demandId.value())));
        return demand.proposeCandidate(proposeCandidateCommand.employeeId()).value().toString();
    }

    public record ProposeCandidateCommand(@NotNull DemandId demandId, @NotNull EmployeeId employeeId) {
    }
}
