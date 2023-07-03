package hexmatcher.employee.application.usecase;

import hexmatcher.employee.application.port.SaveEmployeePort;
import hexmatcher.employee.domain.entity.Employee;
import hexmatcher.employee.domain.valueobject.ProjectId;
import hexmatcher.employee.domain.valueobject.TagId;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class RegisterEmployeeUseCase {
    private final SaveEmployeePort saveEmployeePort;
    @Transactional
    public String handle(RegisterEmployeeCommand registerEmployeeCommand){
        Employee employee = Employee.createNew(
                registerEmployeeCommand.firstName(),
                registerEmployeeCommand.lastName(),
                registerEmployeeCommand.projectId(),
                registerEmployeeCommand.tags()
        );
        return saveEmployeePort.save(employee).toString();
    }

    public record RegisterEmployeeCommand(
            @NotBlank String firstName,
            @NotBlank String lastName,
            ProjectId projectId,
            Set<TagId> tags
    ){
    }
}
