package hexmatcher.employee.adapter.in.web;

public record EmployeeCreationRequest(
        String globalId,
        String internalId,
        String firstName,
        String lastName,
        String description
) {
}
