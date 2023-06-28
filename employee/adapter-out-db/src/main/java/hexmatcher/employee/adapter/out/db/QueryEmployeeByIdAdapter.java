package hexmatcher.employee.adapter.out.db;

import hexmatcher.employee.application.port.QueryEmployeeByIdPort;
import hexmatcher.employee.domain.entity.Employee;
import hexmatcher.employee.domain.valueobject.EmployeeId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
class QueryEmployeeByIdAdapter implements QueryEmployeeByIdPort {
    private final EmployeeRepository employeeRepository;

    @Override
    public Optional<Employee> queryBy(EmployeeId employeeId) {
        return employeeRepository.findById(employeeId);
    }
}
