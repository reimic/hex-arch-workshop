package hexmatcher.employee.application.usecase;

import hexmatcher.employee.application.port.QueryAssignableEmployeeCharacteristicsPort;
import hexmatcher.employee.domain.valueobject.EmployeeId;
import hexmatcher.employee.domain.valueobject.TagId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class QueryAssignableEmployeeCharacteristicsUseCase {

    private final QueryAssignableEmployeeCharacteristicsPort queryAssignableEmployeeCharacteristicsPort;
    public Map<EmployeeId, Set<TagId>> query(){
        return  queryAssignableEmployeeCharacteristicsPort.findEmployeesTags();
    }
}
