package hexmatcher.employee.adapter.in.web;

import hexmatcher.employee.application.usecase.QueryAllEmployeesUseCase;
import hexmatcher.employee.application.usecase.QueryAllEmployeesUseCase.EmployeeFullView;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
class GetAllEmployeesRestAdapter {
    private final QueryAllEmployeesUseCase queryAllEmployeesUseCase;

    @GetMapping("employees")
    @ResponseStatus(HttpStatus.OK)
    List<EmployeeFullView> getAllEmployees(){
        return queryAllEmployeesUseCase.query();
    }
}
