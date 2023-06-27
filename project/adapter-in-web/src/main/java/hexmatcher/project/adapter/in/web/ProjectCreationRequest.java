package hexmatcher.project.adapter.in.web;

record ProjectCreationRequest(
        Double businessPriorityIndex,
        String name,
        String engagementManagerEmail,
        String description,
        String clientId
) {
}
