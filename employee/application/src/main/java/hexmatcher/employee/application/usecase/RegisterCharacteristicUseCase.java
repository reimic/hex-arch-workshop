package hexmatcher.employee.application.usecase;

import hexmatcher.employee.application.port.QueryEmployeeByIdPort;
import hexmatcher.employee.application.port.SaveCharacteristicPort;
import hexmatcher.employee.domain.entity.Characteristic;
import hexmatcher.employee.domain.entity.Employee;
import hexmatcher.employee.domain.valueobject.EmployeeId;
import hexmatcher.employee.domain.valueobject.TagId;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

@Service
@RequiredArgsConstructor
@Validated
public class RegisterCharacteristicUseCase {
    private final SaveCharacteristicPort saveCharacteristicPort;
    private final QueryEmployeeByIdPort queryEmployeeByIdPort;

    @Transactional
    public String handle(RegisterCharacteristicCommand registerCharacteristicCommand){
        Employee employee = queryEmployeeByIdPort.queryBy(registerCharacteristicCommand.employeeId())
                .orElseThrow(EntityNotFoundException::new);
        Characteristic characteristic = Characteristic.createNew(
                employee,
                registerCharacteristicCommand.tagId()
        );
        return saveCharacteristicPort.save(characteristic).toString();
    }

    public record RegisterCharacteristicCommand(@NotNull EmployeeId employeeId, @NotNull TagId tagId) {
    }
}
