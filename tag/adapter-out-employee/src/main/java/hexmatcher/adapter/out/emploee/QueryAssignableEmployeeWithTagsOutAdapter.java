package hexmatcher.adapter.out.emploee;


import hexmatcher.employee.adapter.in.tag.QueryAssignableEmployeeWithTagsInAdapter;
import hexmatcher.tag.application.port.GetEmployeesTagsPort;
import hexmatcher.tag.domain.valueobject.EmployeeId;
import hexmatcher.tag.domain.valueobject.TagId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
class QueryAssignableEmployeeWithTagsOutAdapter implements GetEmployeesTagsPort {
    private final QueryAssignableEmployeeWithTagsInAdapter queryAssignableEmployeeWithTagsInAdapter;
    @Override
    public Map<EmployeeId, Set<TagId>> findEmployeesTags() {
        Map<hexmatcher.employee.domain.valueobject.EmployeeId, Set<hexmatcher.employee.domain.valueobject.TagId>> employeesTags
                = queryAssignableEmployeeWithTagsInAdapter.findEmployeesTags();

       return employeesTags.entrySet()
                .stream()
                .collect(Collectors.toMap(
                        entry ->new EmployeeId(entry.getKey().value()),
                        entry -> entry.getValue().stream().map(tagId -> new TagId(tagId.value())).collect(Collectors.toSet())
                ));
    }
}
