package hexmatcher.project.application.port.in;

@FunctionalInterface
public interface RegisterClientUseCase {
    String handle(RegisterClientCommand registerClientCommand);
}
