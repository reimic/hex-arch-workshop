package hexmatcher.demand.adapter.in.web;

import hexmatcher.demand.application.usecase.RejectCandidateUseCase;
import hexmatcher.demand.application.usecase.RejectCandidateUseCase.RejectCandidateCommand;
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
class RejectCandidateRestAdapter {

    private final RejectCandidateUseCase rejectCandidateUseCase;

    @PostMapping("demands/reject-candidate")
    void acceptCandidate(@RequestBody RejectCandidateRequest request){
        log.info("Got request with body: {}",request);
        RejectCandidateCommand rejectCandidateCommand = new RejectCandidateCommand(
                new DemandId(UUID.fromString(request.demandId())),
                new CandidateId(UUID.fromString(request.candidateId()))
        );
        rejectCandidateUseCase.handle(rejectCandidateCommand);
    }

    record RejectCandidateRequest(String demandId, String candidateId
    ) {
    }

}
