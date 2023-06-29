package hexmatcher.employee.application.port;

import hexmatcher.employee.application.usecase.QueryCharacteristicByEmployeeIdUseCase.CharacteristicsByEmployeeIdView;
import hexmatcher.employee.domain.valueobject.EmployeeId;

import java.util.List;

@FunctionalInterface
public interface QueryCharacteristicByEmployeeIdPort {
    List<CharacteristicsByEmployeeIdView> queryBy(EmployeeId employeeId);
}
