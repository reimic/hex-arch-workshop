package hexmatcher.demand.application.port;

import hexmatcher.demand.domain.entity.Demand;
import hexmatcher.demand.domain.valueobject.DemandId;

import java.util.Optional;

@FunctionalInterface
public interface QueryDemandByIdPort {
    Optional<Demand> queryBy(DemandId demandId);
}
