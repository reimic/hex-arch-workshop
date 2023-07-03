package hexmatcher.employee.adapter.in.web;

import hexmatcher.employee.application.usecase.AssignEmployeeToProjectUseCase;
import hexmatcher.employee.application.usecase.AssignEmployeeToProjectUseCase.AssignEmployeeToProjectCommand;
import hexmatcher.employee.domain.valueobject.EmployeeId;
import hexmatcher.employee.domain.valueobject.ProjectId;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
class AssignProjectRestAdapter {
    private final AssignEmployeeToProjectUseCase assignEmployeeToProjectUseCase;

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

    record AssignProjectRequest(
            EmployeeId employeeId,
            ProjectId projectId
    ) {
    }
}
