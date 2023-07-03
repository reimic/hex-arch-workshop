package hexmatcher.employee.adapter.out.db;

import hexmatcher.employee.application.port.QueryCharacteristicByEmployeeIdPort;
import hexmatcher.employee.application.usecase.QueryCharacteristicByEmployeeIdUseCase;
import hexmatcher.employee.domain.valueobject.EmployeeId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
class QueryCharacteristicByEmployeeIdAdapter implements QueryCharacteristicByEmployeeIdPort {
    private final CharacteristicRepository characteristicRepository;
    @Override
    public List<QueryCharacteristicByEmployeeIdUseCase.CharacteristicsByEmployeeIdView> queryBy(EmployeeId employeeId) {
        return characteristicRepository.queryBy(employeeId);
    }
}
