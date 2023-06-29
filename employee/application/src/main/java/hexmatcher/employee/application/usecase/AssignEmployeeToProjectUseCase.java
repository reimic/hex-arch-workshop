package hexmatcher.employee.application.usecase;

import hexmatcher.employee.application.port.QueryEmployeeByIdPort;
import hexmatcher.employee.application.port.SaveEmployeePort;
import hexmatcher.employee.domain.entity.Employee;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AssignEmployeeToProjectUseCase {
    private final QueryEmployeeByIdPort queryEmployeeByIdPort;
    private final SaveEmployeePort saveEmployeePort;

    @Transactional
    public boolean apply(final AssignEmployeeToProjectCommand assignEmployeeCommand){
        Employee employee = queryEmployeeByIdPort.queryBy(assignEmployeeCommand.getEmployeeId()).orElseThrow(
                EntityNotFoundException::new
        );
        employee.acceptProject(assignEmployeeCommand.getProjectId());
        return saveEmployeePort.save(employee).equals(employee.getEmployeeId().value());
    }
}
