package hexmatcher.demand.adapter.in.web;

import hexmatcher.demand.application.usecase.OpenDemandUseCase;
import hexmatcher.demand.application.usecase.OpenDemandUseCase.OpenDemandCommand;
import hexmatcher.demand.domain.entity.DemandPriority;
import hexmatcher.demand.domain.entity.DemandType;
import hexmatcher.demand.domain.valueobject.ProjectId;
import hexmatcher.demand.domain.valueobject.TagId;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequiredArgsConstructor
class OpenDemandRestAdapter {

    private final OpenDemandUseCase openDemandUseCase;

    @PostMapping("demands")
    @ResponseStatus(HttpStatus.ACCEPTED)
    String openDemand(@RequestBody DemandCreationRequest request){
        log.info("Got request with body: {}",request);
        OpenDemandCommand openDemandCommand = new OpenDemandCommand(
                request.demandPriority(),
                request.demandType(),
                new ProjectId(UUID.fromString(request.projectId())),
                request.needDate(),
                request.employeesRequired(),
                request.description(),
                (request.tagIds() == null || request.tagIds().isEmpty()) ? null : request.tagIds().stream()
                        .map(tagId -> new TagId(UUID.fromString(tagId))).collect(Collectors.toSet())
        );
        return openDemandUseCase.handle(openDemandCommand);
    }

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

}
