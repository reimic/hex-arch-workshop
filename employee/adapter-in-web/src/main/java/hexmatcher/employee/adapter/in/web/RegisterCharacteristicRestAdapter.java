package hexmatcher.employee.adapter.in.web;

import hexmatcher.employee.application.usecase.RegisterCharacteristicCommand;
import hexmatcher.employee.application.usecase.RegisterCharacteristicUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
@Slf4j
@RestController
@RequiredArgsConstructor
class RegisterCharacteristicRestAdapter {

    private final RegisterCharacteristicUseCase registerCharacteristicUseCase;

    @PostMapping("characteristics")
    @ResponseStatus(HttpStatus.CREATED)
    String registerCharacteristic(@RequestBody CharacteristicCreationRequest request){
        log.info("Got request with body: {}", request);
        RegisterCharacteristicCommand registerCharacteristicCommand = new RegisterCharacteristicCommand(
                request.employeeId(),
                request.tagId()
        );
        return registerCharacteristicUseCase.handle(registerCharacteristicCommand);
    }
}
