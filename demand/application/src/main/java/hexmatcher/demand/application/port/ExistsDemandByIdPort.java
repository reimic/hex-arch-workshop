package hexmatcher.demand.application.port;

import hexmatcher.demand.domain.valueobject.DemandId;

@FunctionalInterface
public interface ExistsDemandByIdPort {
    boolean existsById(DemandId demandId);
}
