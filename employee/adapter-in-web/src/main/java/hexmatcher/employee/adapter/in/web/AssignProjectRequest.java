package hexmatcher.employee.adapter.in.web;

import hexmatcher.employee.domain.valueobject.EmployeeId;
import hexmatcher.employee.domain.valueobject.ProjectId;

record AssignProjectRequest(
        EmployeeId employeeId,
        ProjectId projectId
) {
}
