package hexmatcher.employee.application.usecase;

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

    public RegisterEmployeeCommand(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
        this.validateSelf();
    }
}
