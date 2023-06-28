package hexmatcher.employee.application.port.in;

@FunctionalInterface
public interface RegisterEmployeeUseCase {
    String handle(RegisterEmployeeCommand registerEmployeeCommand);
}
