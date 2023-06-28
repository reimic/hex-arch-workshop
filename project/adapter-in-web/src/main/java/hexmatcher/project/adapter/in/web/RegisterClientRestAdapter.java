package hexmatcher.project.adapter.in.web;


import hexmatcher.project.application.usecase.RegisterClientCommand;
import hexmatcher.project.application.usecase.RegisterClientUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
