package hexmatcher.employee.adapter.in.web;

import hexmatcher.employee.application.usecase.RegisterEmployeeUseCase;
import hexmatcher.employee.application.usecase.RegisterEmployeeUseCase.RegisterEmployeeCommand;
import hexmatcher.employee.domain.valueobject.ProjectId;
import hexmatcher.employee.domain.valueobject.TagId;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequiredArgsConstructor
class RegisterEmployeeRestAdapter {

    private final RegisterEmployeeUseCase registerEmployeeUseCase;
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

    record EmployeeCreationRequest(
            String firstName,
            String lastName,
            String projectId,
            Set<String> tagIds
    ) {
    }
}
