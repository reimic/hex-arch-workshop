package hexmatcher.employee.application.port;

import hexmatcher.employee.domain.valueobject.EmployeeId;
import hexmatcher.employee.domain.valueobject.ProjectId;

public interface AssignEmployeeToProjectPort {
    boolean save(EmployeeId employeeId, ProjectId projectId);
}
