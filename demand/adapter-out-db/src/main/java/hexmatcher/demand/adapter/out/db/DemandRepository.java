package hexmatcher.demand.adapter.out.db;

import hexmatcher.demand.domain.entity.Demand;
import hexmatcher.demand.domain.valueobject.DemandId;
import hexmatcher.demand.domain.valueobject.TagId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Set;

interface DemandRepository extends JpaRepository<Demand, DemandId> {


    @Query("""
        select s.tagId
        from Demand d
        join d.specifications s
        where d.demandId = :demandId
        """)
    Set<TagId> queryTagsByDemandId(@Param("demandId") DemandId demandId);

}
