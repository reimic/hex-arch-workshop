package hexmatcher.project.application.port.in;

@FunctionalInterface
public interface StartProjectUseCase {
    String handle(StartProjectCommand startProjectCommand);
}
