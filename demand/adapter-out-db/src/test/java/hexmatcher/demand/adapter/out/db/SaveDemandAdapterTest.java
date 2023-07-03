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
import java.util.Set;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

@DataJpaTest
class SaveDemandAdapterTest {

    @Autowired
    private TestEntityManager testEntityManager;
    @Autowired
    private DemandRepository demandRepository;
    private SaveDemandAdapter saveDemandAdapter;

    @BeforeEach
    void setUp(){
        saveDemandAdapter = new SaveDemandAdapter(demandRepository);
    }
    @Test
    void shouldPersistDemandInDb(){
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
        //when
        UUID demandId = saveDemandAdapter.save(demand);
        //then
        assertAll(
                ()->assertThat(demandId).isNotNull(),
                ()->assertThat(testEntityManager.find(Demand.class,new DemandId(demandId)))
                        .isNotNull()
        );

    }


}
