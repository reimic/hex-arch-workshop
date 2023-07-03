package hexmatcher.demand.adapter.out.db;

import hexmatcher.demand.domain.entity.Demand;
import hexmatcher.demand.domain.entity.DemandPriority;
import hexmatcher.demand.domain.entity.DemandType;
import hexmatcher.demand.domain.valueobject.DemandId;
import hexmatcher.demand.domain.valueobject.ProjectId;
import hexmatcher.demand.domain.valueobject.TagId;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.time.LocalDate;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class QueryDemandByIdAdapterTest {

    @Autowired
    private TestEntityManager testEntityManager;
    @Autowired
    private DemandRepository demandRepository;
    private QueryDemandByIdAdapter queryDemandByIdAdapter;

    @BeforeEach
    void setUp(){
        queryDemandByIdAdapter = new QueryDemandByIdAdapter(demandRepository);
    }

    @Test
    void shouldReturnEmptyOptional(){
        //given
        DemandId demandId = new DemandId(UUID.randomUUID());
        //when
        Optional<Demand> result = queryDemandByIdAdapter.queryBy(demandId);
        //then
        assertThat(result).isEmpty();
    }

    @Test
    void shouldReturnDemand(){
        //given
        Demand demand = Demand.createNew(
                DemandPriority.ONE,
                DemandType.REAL,
                new ProjectId(UUID.randomUUID()),
                LocalDate.now(),
                2L,
                "Demand description",
                Set.of(new TagId(UUID.randomUUID()), new TagId(UUID.randomUUID()))
        );
        testEntityManager.persist(demand);
        //when
        Optional<Demand> result = queryDemandByIdAdapter.queryBy(demand.getDemandId());
        //then
        assertThat(result).isNotEmpty();
    }

}
