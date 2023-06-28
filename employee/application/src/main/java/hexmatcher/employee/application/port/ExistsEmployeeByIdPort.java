package hexmatcher.employee.application.port;

import hexmatcher.employee.domain.valueobject.EmployeeId;

@FunctionalInterface
public interface ExistsEmployeeByIdPort {
    boolean existsById(EmployeeId employeeId);
}
