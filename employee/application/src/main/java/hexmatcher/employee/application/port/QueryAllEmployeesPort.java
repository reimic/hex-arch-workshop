package hexmatcher.employee.application.port;

import hexmatcher.employee.application.usecase.QueryAllEmployeesUseCase.EmployeeFullView;

import java.util.List;

public interface QueryAllEmployeesPort {
    List<EmployeeFullView> query();
}
