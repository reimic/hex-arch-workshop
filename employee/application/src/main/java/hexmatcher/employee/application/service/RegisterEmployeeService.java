package hexmatcher.employee.application.service;

import hexmatcher.employee.application.port.in.RegisterEmployeeCommand;
import hexmatcher.employee.application.port.in.RegisterEmployeeUseCase;
import hexmatcher.employee.application.port.out.SaveEmployeePort;
import hexmatcher.employee.domain.entity.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
class RegisterEmployeeService implements RegisterEmployeeUseCase {
    private final SaveEmployeePort saveEmployeePort;

    @Transactional
    @Override
    public String handle(RegisterEmployeeCommand registerEmployeeCommand){
        Employee employee = Employee.createNew(
          registerEmployeeCommand.getFirstName(),
          registerEmployeeCommand.getLastName(),
                registerEmployeeCommand.getUnit()
        );
        return saveEmployeePort.save(employee).toString();
    }
}
