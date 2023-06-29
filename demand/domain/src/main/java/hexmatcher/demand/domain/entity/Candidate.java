package hexmatcher.demand.domain.entity;

import hexmatcher.demand.domain.converter.CandidateIdConverter;
import hexmatcher.demand.domain.converter.EmployeeIdConverter;
import hexmatcher.demand.domain.valueobject.CandidateId;
import hexmatcher.demand.domain.valueobject.EmployeeId;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(name = "UniqueDemandAndEmployee",columnNames = {"demand_id","employee_id"}))
@Getter
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder(access = AccessLevel.PACKAGE)
@EqualsAndHashCode
@ToString
public class Candidate {

    private static final String CAN_NOT_ACCEPT_CANDIDATE_WHEN_CURRENT_CANDIDATE_STATUS_DIFFER_FROM_PROPOSED = "Can not accept candidate when current candidate status differ from PROPOSED.";
    private static final String CAN_NOT_REJECT_CANDIDATE_WHEN_CURRENT_CANDIDATE_STATUS_DIFFER_FROM_PROPOSED = "Can not reject candidate when current candidate status differ from PROPOSED.";
    @Id
    @Convert(converter = CandidateIdConverter.class)
    private CandidateId candidateId;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CandidateStatus candidateStatus;
    @Convert(converter = EmployeeIdConverter.class)
    @Column(name = "employee_id",nullable = false)
    private EmployeeId employeeId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "demand_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Demand demand;

    public static Candidate createNew(
            Demand demand,
            EmployeeId employeeId
    ){
        Candidate candidate = new Candidate();
        candidate.candidateId=new CandidateId(UUID.randomUUID());
        candidate.candidateStatus=CandidateStatus.PROPOSED;
        candidate.demand=demand;
        candidate.employeeId=employeeId;
        return candidate;
    }

    public void acceptCandidate(){
        if (this.candidateStatus!=CandidateStatus.PROPOSED){
            throw new IllegalStateException(CAN_NOT_ACCEPT_CANDIDATE_WHEN_CURRENT_CANDIDATE_STATUS_DIFFER_FROM_PROPOSED);
        }
        this.candidateStatus=CandidateStatus.ACCEPTED;
    }

    public void rejectCandidate() {
        if (this.candidateStatus!=CandidateStatus.PROPOSED){
            throw new IllegalStateException(CAN_NOT_REJECT_CANDIDATE_WHEN_CURRENT_CANDIDATE_STATUS_DIFFER_FROM_PROPOSED);
        }
        this.candidateStatus=CandidateStatus.REJECTED;
    }
}
