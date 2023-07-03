package hexmatcher.adapter.out.emploee;


import hexmatcher.employee.adapter.in.tag.QueryAssignableEmployeeWithTagsAdapter;
import hexmatcher.tag.application.port.GetEmployeesTagsPort;
import hexmatcher.tag.domain.valueobject.EmployeeId;
import hexmatcher.tag.domain.valueobject.TagId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Set;

@Component
@RequiredArgsConstructor
class QueryAssignableEmployeeAdapter implements GetEmployeesTagsPort {
    private final QueryAssignableEmployeeWithTagsAdapter queryAssignableEmployeeWithTagsAdapter;
    @Override
    public Map<EmployeeId, Set<TagId>> findEmployeesTags() {
        Map<hexmatcher.employee.domain.valueobject.EmployeeId, Set<hexmatcher.employee.domain.valueobject.TagId>> employeesTags
                = queryAssignableEmployeeWithTagsAdapter.findEmployeesTags();
        //new EmployeeId(employeesTags.)
        return null;
    }
}
