package hexmatcher.employee.application.usecase;

import hexmatcher.employee.application.port.QueryAllEmployeesPort;
import hexmatcher.employee.domain.valueobject.EmployeeId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QueryAllEmployeesUseCase {
    private final QueryAllEmployeesPort queryAllEmployeesPort;


    public List<EmployeeFullView> query(){
        return queryAllEmployeesPort.query();
    }


    public interface EmployeeFullView {
        EmployeeId getEmployeeId();
        String getEmployeeFirstName();
        String getEmployeeLastName();
    }
}

