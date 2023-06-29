package hexmatcher.employee.application.usecase;

import hexmatcher.employee.domain.valueobject.EmployeeId;
import hexmatcher.employee.domain.valueobject.TagId;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode(callSuper = false)
public class RegisterCharacteristicCommand extends SelfValidating<RegisterCharacteristicCommand> {

    private final TagId tagId;
    private final EmployeeId employeeId;
    public RegisterCharacteristicCommand(
            EmployeeId employeeId,
            TagId tagId
    ){
        this.employeeId = employeeId;
        this.tagId = tagId;
        this.validateSelf();
    }
}
