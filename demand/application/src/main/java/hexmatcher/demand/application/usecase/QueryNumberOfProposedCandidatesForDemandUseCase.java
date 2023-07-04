package hexmatcher.demand.application.usecase;

import hexmatcher.demand.application.port.QueryNumberOfProposedCandidatesForDemandPort;
import hexmatcher.demand.domain.valueobject.DemandId;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class QueryNumberOfProposedCandidatesForDemandUseCase {


    private final QueryNumberOfProposedCandidatesForDemandPort queryNumberOfProposedCandidatesForDemandPort;

    public Optional<CountProposedCandidateForDemandProjection> queryBy(DemandId demandId) {
        return queryNumberOfProposedCandidatesForDemandPort.queryBy(demandId);
    }

    public record CountProposedCandidateForDemandView(
            String demandId,
            long proposedCandidates
    ) {
        public CountProposedCandidateForDemandView(DemandId demandId, long proposedCandidates) {
            this(demandId.value().toString(), proposedCandidates);
        }
    }

    public interface CountProposedCandidateForDemandProjection{

        @Value("#{target.demandId.value().toString()}")
        String getDemandId();
        long getProposedCandidates();
    }
}
