package hexmatcher.employee.application.usecase;

import hexmatcher.employee.domain.valueobject.EmployeeId;
import hexmatcher.employee.domain.valueobject.ProjectId;
import jakarta.validation.constraints.NotBlank;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode(callSuper = false)
public class AssignEmployeeToProjectCommand extends SelfValidating<AssignEmployeeToProjectCommand>{
    @NotBlank
    private final EmployeeId employeeId;
    @NotBlank
    private final ProjectId projectId;

    public AssignEmployeeToProjectCommand(
            EmployeeId employeeId,
            ProjectId projectId
    ){
        this.employeeId = employeeId;
        this.projectId = projectId;
        this.validateSelf();
    }
}
