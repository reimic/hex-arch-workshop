package hexmatcher.employee.adapter.in.web;

record EmployeeCreationRequest(
        String globalId,
        String internalId,
        String firstName,
        String lastName,
        String description
) {
}
