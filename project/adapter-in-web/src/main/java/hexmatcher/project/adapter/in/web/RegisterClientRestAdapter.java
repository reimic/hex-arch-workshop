package hexmatcher.project.adapter.in.web;


import hexmatcher.project.application.port.in.RegisterClientCommand;
import hexmatcher.project.application.port.in.RegisterClientUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
class RegisterClientRestAdapter {

    private final RegisterClientUseCase registerClientUseCase;

    @PostMapping("clients")
    @ResponseStatus(HttpStatus.ACCEPTED)
    String registerClient(@RequestBody ClientCreationRequest request){
        RegisterClientCommand registerClientCommand = new RegisterClientCommand(
                request.name(),
                request.marketUnit()
        );
        return registerClientUseCase.handle(registerClientCommand);
    }
}
