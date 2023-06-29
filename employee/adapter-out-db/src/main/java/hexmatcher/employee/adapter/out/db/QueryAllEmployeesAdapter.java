package hexmatcher.employee.adapter.out.db;

import hexmatcher.employee.application.port.QueryAllEmployeesPort;
import hexmatcher.employee.application.usecase.QueryAllEmployeesUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
class QueryAllEmployeesAdapter implements QueryAllEmployeesPort {
    private final EmployeeRepository employeeRepository;
    @Override
    public List<QueryAllEmployeesUseCase.EmployeeFullView> query() {
        return employeeRepository.query();
    }
}
