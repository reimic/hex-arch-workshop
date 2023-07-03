package hexmatcher.employee.application.usecase;

import hexmatcher.employee.application.port.QueryEmployeeByIdPort;
import hexmatcher.employee.application.port.SaveEmployeePort;
import hexmatcher.employee.domain.entity.Employee;
import hexmatcher.employee.domain.valueobject.EmployeeId;
import hexmatcher.employee.domain.valueobject.ProjectId;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

@Service
@RequiredArgsConstructor
@Validated
public class AssignEmployeeToProjectUseCase {
    private final QueryEmployeeByIdPort queryEmployeeByIdPort;
    private final SaveEmployeePort saveEmployeePort;

    @Transactional
    public boolean apply(final AssignEmployeeToProjectCommand assignEmployeeCommand){
        Employee employee = queryEmployeeByIdPort.queryBy(assignEmployeeCommand.employeeId).orElseThrow(
                EntityNotFoundException::new
        );
        employee.acceptProject(assignEmployeeCommand.projectId);
        return saveEmployeePort.save(employee).equals(employee.getEmployeeId().value());
    }

    public record AssignEmployeeToProjectCommand(@NotNull EmployeeId employeeId, ProjectId projectId){

    }
}
