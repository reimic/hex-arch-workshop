package hexmatcher.employee.application.usecase;

import hexmatcher.employee.application.port.QueryEmployeeByIdPort;
import hexmatcher.employee.application.port.SaveCharacteristicPort;
import hexmatcher.employee.domain.entity.Characteristic;
import hexmatcher.employee.domain.entity.Employee;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class RegisterCharacteristicUseCase {
    private final SaveCharacteristicPort saveCharacteristicPort;
    private final QueryEmployeeByIdPort queryEmployeeByIdPort;

    @Transactional
    public String handle(RegisterCharacteristicCommand registerCharacteristicCommand){
        Employee employee = queryEmployeeByIdPort.queryBy(registerCharacteristicCommand.getEmployeeId())
                .orElseThrow(EntityNotFoundException::new);
        Characteristic characteristic = Characteristic.createNew(
                employee,
                registerCharacteristicCommand.getTagId()
        );
        return saveCharacteristicPort.save(characteristic).toString();
    }
}
