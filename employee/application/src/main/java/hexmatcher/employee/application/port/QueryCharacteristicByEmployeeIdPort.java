package hexmatcher.employee.application.port;

import hexmatcher.employee.application.usecase.QueryCharacteristicByEmployeeIdUseCase;
import hexmatcher.employee.domain.valueobject.EmployeeId;

import java.util.List;

@FunctionalInterface
public interface QueryCharacteristicByEmployeeIdPort {
    List<QueryCharacteristicByEmployeeIdUseCase.CharacteristicsByEmployeeIdView> queryBy(EmployeeId employeeId);
}
