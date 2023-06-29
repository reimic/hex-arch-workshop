package hexmatcher.demand.adapter.in.web;

import hexmatcher.demand.application.usecase.AcceptCandidateUseCase;
import hexmatcher.demand.application.usecase.AcceptCandidateUseCase.AcceptCandidateCommand;
import hexmatcher.demand.domain.valueobject.CandidateId;
import hexmatcher.demand.domain.valueobject.DemandId;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@Slf4j
@RestController
@RequiredArgsConstructor
class AcceptCandidateRestAdapter {

    private final AcceptCandidateUseCase acceptCandidateUseCase;

    @PostMapping("demands/accept-candidate")
    void acceptCandidate(@RequestBody AcceptCandidateRequest request){
        log.info("Got request with body: {}",request);
        AcceptCandidateCommand acceptCandidateCommand = new AcceptCandidateCommand(
                new DemandId(UUID.fromString(request.demandId())),
                new CandidateId(UUID.fromString(request.candidateId()))
        );
        acceptCandidateUseCase.handle(acceptCandidateCommand);
    }

    record AcceptCandidateRequest(String demandId, String candidateId
    ) {
    }

}
