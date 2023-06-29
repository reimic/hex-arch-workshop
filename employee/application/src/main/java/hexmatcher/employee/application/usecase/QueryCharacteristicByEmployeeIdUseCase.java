package hexmatcher.employee.application.usecase;

import hexmatcher.employee.application.port.ExistsEmployeeByIdPort;
import hexmatcher.employee.application.port.QueryCharacteristicByEmployeeIdPort;
import hexmatcher.employee.domain.valueobject.EmployeeId;
import hexmatcher.employee.domain.valueobject.TagId;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class QueryCharacteristicByEmployeeIdUseCase {
    private static final String EMPLOYEE_WITH_ID_NOT_FOUND = "Employee with ID=%s not found.";
    private final QueryCharacteristicByEmployeeIdPort queryCharacteristicsByEmployeeIdPort;
    private final ExistsEmployeeByIdPort existsEmployeeByIdPort;

    public List<CharacteristicsByEmployeeIdView> queryBy(EmployeeId employeeId){
        if(!existsEmployeeByIdPort.existsById(employeeId)){
            throw new EntityNotFoundException(EMPLOYEE_WITH_ID_NOT_FOUND.formatted(employeeId.value()));
        }

        return queryCharacteristicsByEmployeeIdPort.queryBy(employeeId);
    }

    public interface CharacteristicsByEmployeeIdView{
        TagId getTagId();
    }
}
