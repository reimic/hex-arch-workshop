package hexmatcher.demand.application.port;

import hexmatcher.demand.domain.valueobject.DemandId;
import hexmatcher.demand.domain.valueobject.TagId;

import java.util.Optional;
import java.util.Set;

@FunctionalInterface
public interface QueryTagsByDemandIdPort {
    Optional<Set<TagId>> findTagsByDemandId(DemandId demandId);
}
