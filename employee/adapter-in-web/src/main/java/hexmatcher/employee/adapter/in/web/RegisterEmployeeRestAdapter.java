package hexmatcher.employee.adapter.in.web;

import hexmatcher.employee.application.usecase.AssignEmployeeToProjectCommand;
import hexmatcher.employee.application.usecase.AssignEmployeeToProjectUseCase;
import hexmatcher.employee.application.usecase.RegisterEmployeeCommand;
import hexmatcher.employee.application.usecase.RegisterEmployeeUseCase;
import hexmatcher.employee.domain.valueobject.ProjectId;
import hexmatcher.employee.domain.valueobject.TagId;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequiredArgsConstructor
class RegisterEmployeeRestAdapter {

    private final RegisterEmployeeUseCase registerEmployeeUseCase;
    private final AssignEmployeeToProjectUseCase assignEmployeeToProjectUseCase;
    @PostMapping("employees")
    @ResponseStatus(HttpStatus.CREATED)
    String registerEmployee(@RequestBody EmployeeCreationRequest request) {
        log.info("Got request with body: {}", request);
        RegisterEmployeeCommand registerEmployeeCommand = new RegisterEmployeeCommand(
                request.firstName(),
                request.lastName(),
                request.projectId() == null ? null : new ProjectId(UUID.fromString(request.projectId())),
                (request.tagIds() == null || request.tagIds().isEmpty()) ? null : request.tagIds().stream()
                        .map(tagId -> new TagId(UUID.fromString(tagId))).collect(Collectors.toSet())
        );
        return registerEmployeeUseCase.handle(registerEmployeeCommand);
    }

    @PatchMapping("employees")
    @ResponseStatus(HttpStatus.ACCEPTED)
    void registerEmployee(@RequestBody AssignProjectRequest request) {
        log.info("Got request with body: {}", request);
        AssignEmployeeToProjectCommand assignEmployeeToProjectCommand = new AssignEmployeeToProjectCommand(
          request.employeeId(),
          request.projectId()
        );
        assignEmployeeToProjectUseCase.apply(assignEmployeeToProjectCommand);
    }
}
