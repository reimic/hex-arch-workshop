package hexmatcher.matching.domain;

public class ValidationException extends RuntimeException {

    public ValidationException(String reason) {
        super(reason);
    }

}
