package hexmatcher.employee.adapter.in.web;

import java.util.Set;

record EmployeeCreationRequest(
        String firstName,
        String lastName,
        String projectId,
        Set<String> tagIds
) {
}
