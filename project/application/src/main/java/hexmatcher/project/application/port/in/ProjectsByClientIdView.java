package hexmatcher.project.application.port.in;

import hexmatcher.project.domain.entity.MarketUnit;

public interface ProjectsByClientIdView {

    String getClientName();
    MarketUnit getMarketUnit();
    String getProjectName();
    String getEngagementManagerEmail();
    String getProjectDescription();
}
