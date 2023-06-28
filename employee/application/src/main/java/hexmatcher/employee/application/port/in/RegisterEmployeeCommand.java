package hexmatcher.employee.application.port.in;

import hexmatcher.employee.domain.entity.Unit;
import jakarta.validation.constraints.NotBlank;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode(callSuper = false)
public class RegisterEmployeeCommand extends SelfValidating<RegisterEmployeeCommand> {

    @NotBlank
    private final String firstName;
    @NotBlank
    private final String lastName;
    @NotBlank
    private final Unit unit;
    public RegisterEmployeeCommand(String firstName, String lastName, Unit unit){
        this.firstName = firstName;
        this.lastName = lastName;
        this.unit = unit;
        this.validateSelf();
    }
}
