package hexmatcher.employee.adapter.out.db;

import hexmatcher.employee.domain.entity.Employee;
import hexmatcher.employee.domain.valueobject.EmployeeId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

interface EmployeeRepository extends JpaRepository<Employee, EmployeeId> {
}
