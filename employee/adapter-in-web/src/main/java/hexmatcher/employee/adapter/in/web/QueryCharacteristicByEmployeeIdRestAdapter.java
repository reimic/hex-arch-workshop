package hexmatcher.employee.adapter.in.web;

import hexmatcher.employee.application.usecase.QueryCharacteristicByEmployeeIdUseCase;
import hexmatcher.employee.application.usecase.QueryCharacteristicByEmployeeIdUseCase.CharacteristicsByEmployeeIdView;
import hexmatcher.employee.domain.valueobject.EmployeeId;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;
@RestController
@RequiredArgsConstructor
class QueryCharacteristicByEmployeeIdRestAdapter {
    private final QueryCharacteristicByEmployeeIdUseCase queryCharacteristicByEmployeeIdUseCase;

    @GetMapping("characteristics/{employeeId}")
    List<CharacteristicsByEmployeeIdView> getCharacteristicsByEmployeeId(@PathVariable String employeeId){
        return queryCharacteristicByEmployeeIdUseCase.queryBy(new EmployeeId(UUID.fromString(employeeId)));
    }
}
