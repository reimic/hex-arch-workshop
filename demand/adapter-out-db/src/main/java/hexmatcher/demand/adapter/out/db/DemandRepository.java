package hexmatcher.demand.adapter.out.db;

import hexmatcher.demand.application.usecase.QueryNumberOfProposedCandidatesForDemandUseCase;
import hexmatcher.demand.domain.entity.Demand;
import hexmatcher.demand.domain.valueobject.DemandId;
import hexmatcher.demand.domain.valueobject.TagId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.Set;

interface DemandRepository extends JpaRepository<Demand, DemandId> {

    @Query("""
            select 
                new hexmatcher.demand.application.usecase.QueryNumberOfProposedCandidatesForDemandUseCase$CountProposedCandidateForDemandView(d.demandId ,
                sum (
                        case 
                            when c.candidateStatus = hexmatcher.demand.domain.entity.CandidateStatus.PROPOSED then 1 
                            else 0
                        end
                    )
                )
            from Demand d
            left join d.candidates c
            where d.demandId = :demandId 
            group by d.demandId
            """)
    Optional<QueryNumberOfProposedCandidatesForDemandUseCase.CountProposedCandidateForDemandView> queryForProposedBy(@Param("demandId") DemandId demandId);

    @Query("""
            select 
                d.demandId as demandId ,
                sum (
                        case 
                            when c.candidateStatus = hexmatcher.demand.domain.entity.CandidateStatus.PROPOSED then 1 
                            else 0
                        end
                    ) as proposedCandidates
                
            from Demand d
            left join d.candidates c
            where d.demandId = :demandId 
            group by d.demandId
            """)
    Optional<QueryNumberOfProposedCandidatesForDemandUseCase.CountProposedCandidateForDemandProjection> queryForProposedByProjection(@Param("demandId") DemandId demandId);
    @Query("""
        select s.tagId
        from Demand d
        join d.specifications s
        where d.demandId = :demandId
        """)
    Set<TagId> queryTagsByDemandId(@Param("demandId") DemandId demandId);

}
