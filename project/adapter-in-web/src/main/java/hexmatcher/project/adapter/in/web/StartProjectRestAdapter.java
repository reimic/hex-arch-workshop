package hexmatcher.project.adapter.in.web;

import hexmatcher.project.application.usecase.StartProjectUseCase;
import hexmatcher.project.application.usecase.StartProjectUseCase.StartProjectCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
class StartProjectRestAdapter {

    private final StartProjectUseCase startProjectUseCase;

    @PostMapping("projects")
    @ResponseStatus(HttpStatus.ACCEPTED)
    String startProject(@RequestBody ProjectCreationRequest request){
        StartProjectCommand startProjectCommand = new StartProjectCommand(
                request.businessPriorityIndex(),
                request.name(),
                request.engagementManagerEmail(),
                request.description(),
                request.clientId()
        );
        return startProjectUseCase.handle(startProjectCommand);
    }

    record ProjectCreationRequest(
            Double businessPriorityIndex,
            String name,
            String engagementManagerEmail,
            String description,
            String clientId
    ) {
    }
}
