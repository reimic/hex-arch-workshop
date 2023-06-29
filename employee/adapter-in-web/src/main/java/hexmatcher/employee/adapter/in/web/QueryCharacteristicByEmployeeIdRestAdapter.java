package hexmatcher.employee.adapter.in.web;

import hexmatcher.employee.application.usecase.QueryCharacteristicByEmployeeIdUseCase;
import hexmatcher.employee.application.usecase.QueryAssignableEmployeeCharacteristicsUseCase;
import hexmatcher.employee.domain.valueobject.EmployeeId;
import hexmatcher.employee.domain.valueobject.TagId;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
@RestController
@RequiredArgsConstructor
class QueryCharacteristicByEmployeeIdRestAdapter {
    private final QueryCharacteristicByEmployeeIdUseCase queryCharacteristicByEmployeeIdUseCase;
    private final QueryAssignableEmployeeCharacteristicsUseCase queryAssignableEmployeeCharacteristicsUseCase;
    private final
    @GetMapping("characteristics/{employeeId}")
    List<QueryCharacteristicByEmployeeIdUseCase.CharacteristicsByEmployeeIdView> getCharacteristicsByEmployeeId(@PathVariable String employeeId){
        return queryCharacteristicByEmployeeIdUseCase.queryBy(new EmployeeId(UUID.fromString(employeeId)));
    }

    @GetMapping("employee")
    Map<EmployeeId, Set<TagId>> getAssignableEmployeesWithTags(){
        return queryAssignableEmployeeCharacteristicsUseCase.query();
    }
}
