package hexmatcher.demand.domain.entity;

import hexmatcher.demand.domain.converter.DemandIdConverter;
import hexmatcher.demand.domain.converter.ProjectIdConverter;
import hexmatcher.demand.domain.valueobject.DemandId;
import hexmatcher.demand.domain.valueobject.ProjectId;
import hexmatcher.demand.domain.valueobject.TagId;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder(access = AccessLevel.PACKAGE)
@EqualsAndHashCode
@ToString
public class Demand {

    @Id
    @Convert(converter = DemandIdConverter.class)
    private DemandId demandId;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private DemandPriority demandPriority;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private DemandType demandType;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private DemandStatus demandStatus;
    @Convert(converter = ProjectIdConverter.class)
    @Column(nullable = false)
    private ProjectId projectId;
    @Column(nullable = false)
    private LocalDate needDate;
    private Long employeesRequired;
    private String description;
    @OneToMany(mappedBy = "demand", cascade = CascadeType.ALL)
    private Set<Candidate> candidates = new HashSet<>();
    @OneToMany(mappedBy = "demand", cascade = CascadeType.ALL)
    private Set<Specification> specifications = new HashSet<>();

    public static Demand createNew(
            DemandPriority demandPriority,
            DemandType demandType,
            ProjectId projectId,
            LocalDate needDate,
            Long employeesRequired,
            String description,
            Set<TagId> tags
    ) {
        Demand demand = new Demand();
        demand.demandId = new DemandId(UUID.randomUUID());
        demand.demandPriority = demandPriority;
        demand.demandType = demandType;
        demand.demandStatus = DemandStatus.OPENED;
        demand.projectId = projectId;
        demand.needDate = needDate;
        demand.employeesRequired = employeesRequired == null ? 1 : employeesRequired;
        demand.description = description;
        demand.specifications = (tags == null || tags.isEmpty()) ? null : tags.stream().map(tagId -> Specification.createNew(demand, tagId)).collect(Collectors.toSet());
        return demand;
    }

}
