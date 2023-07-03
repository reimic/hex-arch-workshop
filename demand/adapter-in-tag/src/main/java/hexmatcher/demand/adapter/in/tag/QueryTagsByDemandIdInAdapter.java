package hexmatcher.demand.adapter.in.tag;

import hexmatcher.demand.application.usecase.QueryTagsByDemandIdUseCase;
import hexmatcher.demand.domain.valueobject.DemandId;
import hexmatcher.demand.domain.valueobject.TagId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class QueryTagsByDemandIdInAdapter {
    private final QueryTagsByDemandIdUseCase queryTagsByDemandIdUseCase;

    public Optional<Set<TagId>> findTagsByDemandId(DemandId demandId) {
        return queryTagsByDemandIdUseCase.handle(demandId);
    }
}
