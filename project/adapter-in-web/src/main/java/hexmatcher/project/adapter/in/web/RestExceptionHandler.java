package hexmatcher.project.adapter.in.web;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.ValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;
import java.util.List;

@RestControllerAdvice
class RestExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    ResponseEntity<ErrorDto> handleException(EntityNotFoundException entityNotFoundException) {
        HttpStatus httpStatus = HttpStatus.NOT_FOUND;
        String message = entityNotFoundException.getMessage()==null? "":entityNotFoundException.getMessage();
        return ResponseEntity.status(httpStatus).body(createErrorDto(List.of(message),httpStatus));
    }

    @ExceptionHandler(ValidationException.class)
    ResponseEntity<ErrorDto> handleException(ValidationException validationException){
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        ErrorDto errorDto;
        if (validationException instanceof ConstraintViolationException){
            List<String> messages = extractViolationsFromException((ConstraintViolationException) validationException);
            errorDto = createErrorDto(messages,httpStatus);
        }else {
            String exceptionMessage = validationException.getMessage();
            errorDto = createErrorDto(List.of(exceptionMessage),httpStatus);
        }
        return ResponseEntity.status(httpStatus).body(errorDto);
    }
    private List<String> extractViolationsFromException(ConstraintViolationException validationException) {
        return validationException.getConstraintViolations()
                .stream()
                .map(ConstraintViolation::getMessage)
                .toList();
    }
    private ErrorDto createErrorDto(List<String> messages, HttpStatus httpStatus) {
        return ErrorDto.builder()
                .time(Instant.now())
                .code(httpStatus.value())
                .error(httpStatus.getReasonPhrase())
                .messages(messages)
                .build();
    }
}
