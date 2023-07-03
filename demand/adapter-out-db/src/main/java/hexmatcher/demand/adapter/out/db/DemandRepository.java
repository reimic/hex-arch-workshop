package hexmatcher.demand.adapter.out.db;

import hexmatcher.demand.application.usecase.QueryNumberOfProposedCandidatesForDemandUseCase.CountProposedCandidateForDemandView;
import hexmatcher.demand.domain.entity.Demand;
import hexmatcher.demand.domain.valueobject.DemandId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

interface DemandRepository extends JpaRepository<Demand, DemandId> {

    @Query("""
            select 
                new hexmatcher.demand.application.usecase.QueryNumberOfProposedCandidatesForDemandUseCase$CountProposedCandidateForDemandView(d.demandId ,count (c.candidateId))
            from Demand d
            left join d.candidates c
            where d.demandId = :demandId 
            and (c.candidateStatus = hexmatcher.demand.domain.entity.CandidateStatus.PROPOSED OR c.candidateStatus is NULL) 
            """)
    CountProposedCandidateForDemandView queryBy(@Param("demandId") DemandId demandId);
}
