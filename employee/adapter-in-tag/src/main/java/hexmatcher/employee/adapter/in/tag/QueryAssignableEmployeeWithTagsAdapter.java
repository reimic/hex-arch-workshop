package hexmatcher.employee.adapter.in.tag;

import hexmatcher.employee.application.usecase.QueryAssignableEmployeeWithTagsUseCase;
import hexmatcher.employee.domain.valueobject.EmployeeId;
import hexmatcher.employee.domain.valueobject.TagId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class QueryAssignableEmployeeWithTagsAdapter {
    private final QueryAssignableEmployeeWithTagsUseCase queryAssignableEmployeeWithTagsUseCase;


    public Map<EmployeeId, Set<TagId>> findEmployeesTags() {
        return queryAssignableEmployeeWithTagsUseCase.query();
    }
}
