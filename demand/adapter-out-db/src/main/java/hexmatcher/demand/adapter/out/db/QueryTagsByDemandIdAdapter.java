package hexmatcher.demand.adapter.out.db;

import hexmatcher.demand.application.port.QueryTagsByDemandIdPort;
import hexmatcher.demand.domain.valueobject.DemandId;
import hexmatcher.demand.domain.valueobject.TagId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
@RequiredArgsConstructor
class QueryTagsByDemandIdAdapter implements QueryTagsByDemandIdPort {
    private final DemandRepository demandRepository;
    @Override
    public Optional<Set<TagId>> findTagsByDemandId(DemandId demandId) {
        return Optional.of(demandRepository.queryTagsByDemandId(demandId));
    }
}
