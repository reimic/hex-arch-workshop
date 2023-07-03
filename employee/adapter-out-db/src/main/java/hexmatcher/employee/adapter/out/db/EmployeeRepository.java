package hexmatcher.employee.adapter.out.db;

import hexmatcher.employee.application.usecase.QueryAllEmployeesUseCase.EmployeeFullView;
import hexmatcher.employee.domain.entity.Employee;
import hexmatcher.employee.domain.valueobject.EmployeeId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

interface EmployeeRepository extends JpaRepository<Employee, EmployeeId>, CustomEmployeeRepository {
    @Query("""
                select
                   e.employeeId as employeeId,
                   e.firstName as employeeFirstName,
                   e.lastName as employeeLastName
                from Employee e
            """)
    List<EmployeeFullView> query();

}
