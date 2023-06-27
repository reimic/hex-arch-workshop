package hexmatcher.project.adapter.in.web;

import hexmatcher.project.domain.entity.MarketUnit;

record ClientCreationRequest(
        String name,
        MarketUnit marketUnit
) {
}
