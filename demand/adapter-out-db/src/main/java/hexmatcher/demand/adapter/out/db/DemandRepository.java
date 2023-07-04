package hexmatcher.demand.adapter.out.db;

import hexmatcher.demand.application.usecase.QueryNumberOfAcceptedCandidatesForDemandUseCase.CountAcceptedCandidateForDemandView;
import hexmatcher.demand.application.usecase.QueryNumberOfProposedCandidatesForDemandUseCase.CountProposedCandidateForDemandProjection;
import hexmatcher.demand.application.usecase.QueryNumberOfProposedCandidatesForDemandUseCase.CountProposedCandidateForDemandView;
import hexmatcher.demand.domain.entity.Demand;
import hexmatcher.demand.domain.valueobject.DemandId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

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
    Optional<CountProposedCandidateForDemandView> queryForProposedBy(@Param("demandId") DemandId demandId);

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
    Optional<CountProposedCandidateForDemandProjection> queryForProposedByProjection(@Param("demandId") DemandId demandId);


    @Query("""
            select 
                new hexmatcher.demand.application.usecase.QueryNumberOfAcceptedCandidatesForDemandUseCase$CountAcceptedCandidateForDemandView(
                d.demandId ,
                    sum (
                        case 
                            when c.candidateStatus = hexmatcher.demand.domain.entity.CandidateStatus.ACCEPTED then 1 
                            else 0
                        end
                    )
                )
            from Demand d
            left join d.candidates c
            where d.demandId = :demandId 
            group by d.demandId
            """)
    Optional<CountAcceptedCandidateForDemandView> queryForAcceptedBy(@Param("demandId") DemandId demandId);
}
