package hexmatcher.demand.adapter.in.web;

import hexmatcher.demand.application.usecase.ProposeCandidateUseCase;
import hexmatcher.demand.application.usecase.ProposeCandidateUseCase.ProposeCandidateCommand;
import hexmatcher.demand.domain.valueobject.DemandId;
import hexmatcher.demand.domain.valueobject.EmployeeId;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
class ProposeCandidateRestAdapter {

    private final ProposeCandidateUseCase proposeCandidateUseCase;

    @PostMapping("demands/propose-candidate")
    String proposeCandidate(@RequestBody ProposeCandidateRequest request){
        ProposeCandidateCommand proposeCandidateCommand = new ProposeCandidateCommand(
                new DemandId(UUID.fromString(request.demandId())),
                new EmployeeId(UUID.fromString(request.employeeId()))
        );
        return proposeCandidateUseCase.handle(proposeCandidateCommand);
    }
    record ProposeCandidateRequest(
            String demandId,
            String employeeId
    ) {
    }
}
