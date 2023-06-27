package hexmatcher.project.application.port.in;

import hexmatcher.project.domain.entity.MarketUnit;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode(callSuper = false)
public class RegisterClientCommand extends SelfValidating<RegisterClientCommand> {

    @NotBlank
    private final String name;
    @NotNull
    private final MarketUnit marketUnit;

    public RegisterClientCommand(String name, MarketUnit marketUnit) {
        this.name = name;
        this.marketUnit = marketUnit;
        this.validateSelf();
    }
}
