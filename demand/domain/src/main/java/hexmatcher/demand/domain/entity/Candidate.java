package hexmatcher.demand.domain.entity;

import hexmatcher.demand.domain.converter.CandidateIdConverter;
import hexmatcher.demand.domain.converter.EmployeeIdConverter;
import hexmatcher.demand.domain.valueobject.CandidateId;
import hexmatcher.demand.domain.valueobject.EmployeeId;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(name = "UniqueDemandAndEmployee",columnNames = {"demand_id","employee_id"}))
@Getter
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder(access = AccessLevel.PACKAGE)
@EqualsAndHashCode
@ToString
public class Candidate {

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
}
