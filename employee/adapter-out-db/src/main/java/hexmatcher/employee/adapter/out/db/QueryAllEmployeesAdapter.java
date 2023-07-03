package hexmatcher.employee.adapter.out.db;

import hexmatcher.employee.application.port.QueryAllEmployeesPort;
import hexmatcher.employee.application.usecase.QueryAllEmployeesUseCase.EmployeeFullView;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Component
@RequiredArgsConstructor
class QueryAllEmployeesAdapter implements QueryAllEmployeesPort {
    private final EmployeeRepository employeeRepository;
    @Override
    public List<EmployeeFullView> query() {
        return employeeRepository.query();
    }
}
