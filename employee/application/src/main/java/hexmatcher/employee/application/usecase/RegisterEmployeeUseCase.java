package hexmatcher.employee.application.usecase;

import hexmatcher.employee.application.port.SaveEmployeePort;
import hexmatcher.employee.domain.entity.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class RegisterEmployeeUseCase {
    private final SaveEmployeePort saveEmployeePort;
    @Transactional
    public String handle(RegisterEmployeeCommand registerEmployeeCommand){
        Employee employee = Employee.createNew(
                registerEmployeeCommand.getFirstName(),
                registerEmployeeCommand.getLastName(),
                Collections.emptyList()
        );
        return saveEmployeePort.save(employee).toString();
    }
}
