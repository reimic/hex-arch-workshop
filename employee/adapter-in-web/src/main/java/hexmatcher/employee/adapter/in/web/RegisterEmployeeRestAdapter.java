package hexmatcher.employee.adapter.in.web;

import hexmatcher.employee.application.usecase.RegisterEmployeeCommand;
import hexmatcher.employee.application.usecase.RegisterEmployeeUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
class RegisterEmployeeRestAdapter {

    private final RegisterEmployeeUseCase registerEmployeeUseCase;

    @PostMapping("employees")
    @ResponseStatus(HttpStatus.CREATED)
    String registerEmployee(@RequestBody EmployeeCreationRequest request){
        RegisterEmployeeCommand registerEmployeeCommand = new RegisterEmployeeCommand(
            request.firstName(),
            request.lastName()
        );
        return registerEmployeeUseCase.handle(registerEmployeeCommand);
    }
}
