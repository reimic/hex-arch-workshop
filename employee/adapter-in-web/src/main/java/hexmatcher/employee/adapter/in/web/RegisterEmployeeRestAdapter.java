package hexmatcher.employee.adapter.in.web;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RegisterEmployeeRestAdapter {

    private final RegisterEmployeeUseCase registerEmployeeUseCase;

    @PostMapping("employess")
    @ResponseStatus(HttpStatus.CREATED)
    String registerEmployee(@RequestBody EmployeeCreationRequest request){


        return null;
    }
}
