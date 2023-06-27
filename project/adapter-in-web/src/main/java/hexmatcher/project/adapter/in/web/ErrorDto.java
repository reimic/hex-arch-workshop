package hexmatcher.project.adapter.in.web;

import lombok.Builder;

import java.time.Instant;
import java.util.List;

@Builder
record ErrorDto(
        Instant time,
        int code,
        String error,
        List<String> messages
) {
}
