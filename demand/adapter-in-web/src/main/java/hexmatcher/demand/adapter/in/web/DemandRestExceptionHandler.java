package hexmatcher.demand.adapter.in.web;

import hexmatcher.demand.domain.valueobject.ValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;
import java.util.Map;

@RestControllerAdvice
class DemandRestExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ValidationException.class)
    Map<String, String> handleValidationException(ValidationException validationException) {
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        return Map.of(
                "time", Instant.now().toString(),
                "code",String.valueOf(httpStatus.value()),
                "error",httpStatus.getReasonPhrase(),
                "message",validationException.getLocalizedMessage()
        );
    }
}
