package hexmatcher.employee.application.port.out;

import hexmatcher.employee.domain.entity.Employee;

import java.util.UUID;

@FunctionalInterface
public interface SaveEmployeePort {
    UUID save(Employee employee);
}
