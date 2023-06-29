
package hexmatcher.demand.application.usecase;

import hexmatcher.demand.domain.entity.DemandPriority;
import hexmatcher.demand.domain.entity.DemandType;
import hexmatcher.demand.domain.valueobject.ProjectId;
import hexmatcher.demand.domain.valueobject.TagId;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.Set;

@Getter
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = false)
public class OpenDemandCommand extends SelfValidating<OpenDemandCommand> {

    @NotNull
    private final DemandPriority demandPriority;
    @NotNull
    private final DemandType demandType;
    @NotNull
    private final ProjectId projectId;
    @NotNull
    private final LocalDate needDate;
    private final Long employeesRequired;
    private final String description;
    private final Set<TagId> tags;

    public OpenDemandCommand(
            DemandPriority demandPriority,
            DemandType demandType,
            ProjectId projectId,
            LocalDate needDate,
            Long employeesRequired,
            String description,
            Set<TagId> tags
    ) {
        this.demandPriority = demandPriority;
        this.demandType = demandType;
        this.projectId = projectId;
        this.needDate = needDate;
        this.employeesRequired = employeesRequired;
        this.description = description;
        this.tags = tags;
        this.validateSelf();
    }
}
