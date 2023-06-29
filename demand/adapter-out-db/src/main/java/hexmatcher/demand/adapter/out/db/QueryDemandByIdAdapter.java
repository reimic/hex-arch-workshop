package hexmatcher.demand.adapter.out.db;

import hexmatcher.demand.application.port.QueryDemandByIdPort;
import hexmatcher.demand.domain.entity.Demand;
import hexmatcher.demand.domain.valueobject.DemandId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
class QueryDemandByIdAdapter implements QueryDemandByIdPort {

    private final DemandRepository demandRepository;
    @Override
    public Optional<Demand> queryBy(DemandId demandId) {
        return demandRepository.findById(demandId);
    }
}
