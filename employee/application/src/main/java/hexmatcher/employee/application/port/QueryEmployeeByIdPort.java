package hexmatcher.employee.application.port;

import hexmatcher.employee.domain.entity.Employee;
import hexmatcher.employee.domain.valueobject.EmployeeId;

import java.util.Optional;

@FunctionalInterface
public interface QueryEmployeeByIdPort {
    Optional<Employee> queryBy(EmployeeId employeeId);
}
