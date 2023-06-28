package hexmatcher.employee.adapter.out.db;

import hexmatcher.employee.domain.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

interface EmployeeRepository extends JpaRepository<Employee, UUID> {
}
