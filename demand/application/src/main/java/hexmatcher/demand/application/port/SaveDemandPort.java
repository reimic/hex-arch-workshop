package hexmatcher.demand.application.port;

import hexmatcher.demand.domain.entity.Demand;

import java.util.UUID;

@FunctionalInterface
public interface SaveDemandPort {
    UUID save(Demand demand);
}
