package hexmatcher.demand.adapter.out.db;

import hexmatcher.demand.domain.entity.Demand;
import hexmatcher.demand.domain.valueobject.DemandId;
import org.springframework.data.jpa.repository.JpaRepository;

interface DemandRepository extends JpaRepository<Demand, DemandId> {
}
