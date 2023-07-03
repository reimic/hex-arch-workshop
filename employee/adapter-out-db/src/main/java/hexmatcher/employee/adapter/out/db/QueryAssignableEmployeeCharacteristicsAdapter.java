package hexmatcher.employee.adapter.out.db;

import hexmatcher.employee.application.port.QueryAssignableEmployeeCharacteristics;
import hexmatcher.employee.domain.valueobject.EmployeeId;
import hexmatcher.employee.domain.valueobject.TagId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.Set;

@Repository
@RequiredArgsConstructor
class QueryAssignableEmployeeCharacteristicsAdapter implements QueryAssignableEmployeeCharacteristics {
    private final EmployeeRepository employeeRepository;
    @Override
    public Map<EmployeeId, Set<TagId>> findEmployeesTags() {
        return employeeRepository.getAllEmployeesWithTags();
    }
}