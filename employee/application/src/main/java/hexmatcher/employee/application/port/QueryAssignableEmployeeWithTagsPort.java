package hexmatcher.employee.application.port;

import hexmatcher.employee.domain.valueobject.EmployeeId;
import hexmatcher.employee.domain.valueobject.TagId;

import java.util.Map;
import java.util.Set;

public interface QueryAssignableEmployeeWithTagsPort {
    Map<EmployeeId, Set<TagId>> findEmployeesTags();
}
