package hexmatcher.demand.adapter.in.web;

import hexmatcher.demand.domain.entity.DemandPriority;
import hexmatcher.demand.domain.entity.DemandType;

import java.time.LocalDate;
import java.util.Set;

record DemandCreationRequest(
        DemandPriority demandPriority,
        DemandType demandType,
        String projectId,
        LocalDate needDate,
        Long employeesRequired,
        String description,
        Set<String> tagIds
) {
}
