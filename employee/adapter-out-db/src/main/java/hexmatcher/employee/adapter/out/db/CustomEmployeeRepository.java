package hexmatcher.employee.adapter.out.db;

import hexmatcher.employee.domain.valueobject.EmployeeId;
import hexmatcher.employee.domain.valueobject.TagId;

import java.util.Map;
import java.util.Set;

interface CustomEmployeeRepository {
    Map<EmployeeId, Set<TagId>> getAllEmployeesWithTags();
}
