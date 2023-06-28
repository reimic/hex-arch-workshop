package hexmatcher.employee.adapter.out.db;

import hexmatcher.employee.application.port.ExistsEmployeeByIdPort;
import hexmatcher.employee.domain.valueobject.EmployeeId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
class ExistsEmployeeByIdAdapter implements ExistsEmployeeByIdPort {
    private final EmployeeRepository employeeRepository;
    @Override
    public boolean existsById(EmployeeId employeeId) {
        return employeeRepository.existsById(employeeId);
    }
}
