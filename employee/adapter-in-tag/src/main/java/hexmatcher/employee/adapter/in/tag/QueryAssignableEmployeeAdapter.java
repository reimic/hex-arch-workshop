package hexmatcher.employee.adapter.in.tag;

import hexmatcher.employee.application.port.QueryAssignableEmployeeCharacteristics;
import hexmatcher.employee.application.usecase.QueryAssignableEmployeeCharacteristicsUseCase;
import hexmatcher.employee.domain.valueobject.EmployeeId;
import hexmatcher.employee.domain.valueobject.TagId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class QueryAssignableEmployeeAdapter implements QueryAssignableEmployeeCharacteristics {
    private final QueryAssignableEmployeeCharacteristicsUseCase queryAssignableEmployeeCharacteristicsUseCase;

    @Override
    public Map<EmployeeId, Set<TagId>> findEmployeesTags() {
        return queryAssignableEmployeeCharacteristicsUseCase.query();
    }
}
