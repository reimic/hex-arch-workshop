package hexmatcher.demand.adapter.out.db;

import hexmatcher.demand.application.port.SaveDemandPort;
import hexmatcher.demand.domain.entity.Demand;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Slf4j
@Repository
@RequiredArgsConstructor
class SaveDemandAdapter implements SaveDemandPort {

    private final DemandRepository demandRepository;
    @Override
    public UUID save(Demand demand) {
        log.info("Saving demand: {}",demand);
        return demandRepository.save(demand).getDemandId().value();
    }
}
