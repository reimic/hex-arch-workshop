package hexmatcher.employee.adapter.out.db;

import hexmatcher.employee.application.port.SaveEmployeePort;
import hexmatcher.employee.domain.entity.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
@RequiredArgsConstructor
class SaveEmployeeAdapter implements SaveEmployeePort {
    private final EmployeeRepository employeeRepository;
    @Override
    public UUID save(Employee employee) {
        return employeeRepository.save(employee).getEmployeeId().value();
    }
}
