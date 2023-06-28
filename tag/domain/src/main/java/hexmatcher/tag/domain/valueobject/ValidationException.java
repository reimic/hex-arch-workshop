package hexmatcher.tag.domain.valueobject;

public class ValidationException extends RuntimeException {
    public ValidationException(String reason) {
        super(reason);
    }

}
