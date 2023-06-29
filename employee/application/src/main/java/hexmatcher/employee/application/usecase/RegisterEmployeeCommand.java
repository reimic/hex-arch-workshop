package hexmatcher.employee.application.usecase;

import hexmatcher.employee.domain.valueobject.ProjectId;
import hexmatcher.employee.domain.valueobject.TagId;
import jakarta.validation.constraints.NotBlank;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.Set;

@Getter
@EqualsAndHashCode(callSuper = false)
public class RegisterEmployeeCommand extends SelfValidating<RegisterEmployeeCommand> {

    @NotBlank
    private final String firstName;
    @NotBlank
    private final String lastName;

    private final ProjectId projectId;

    private final Set<TagId> tags;

    public RegisterEmployeeCommand(
            String firstName,
            String lastName,
            ProjectId projectId,
            Set<TagId> tags
    ){
        this.firstName = firstName;
        this.lastName = lastName;
        this.projectId = projectId;
        this.tags = tags;
        this.validateSelf();
    }
}
