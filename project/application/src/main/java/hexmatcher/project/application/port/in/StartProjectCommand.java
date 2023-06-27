package hexmatcher.project.application.port.in;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode(callSuper = false)
public class StartProjectCommand extends SelfValidating<StartProjectCommand> {

    @Min(0)
    @Max(5)
    private final Double businessPriorityIndex;
    @NotBlank
    private final String name;
    private final String engagementManagerEmail;
    private final String description;
    @NotBlank
    private final String clientId;

    public StartProjectCommand(
            Double businessPriorityIndex,
            String name,
            String engagementManagerEmail,
            String description,
            String clientId
    ) {
        this.businessPriorityIndex = businessPriorityIndex;
        this.name = name;
        this.engagementManagerEmail = engagementManagerEmail;
        this.description = description;
        this.clientId = clientId;
        this.validateSelf();
    }
}
