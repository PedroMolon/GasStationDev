package org.pedromolon.gasstationdev.dto.request;

import lombok.Builder;

@Builder
public record PumpRequest(
        String name,
        Long gasStationId,
        Long fuelId
) {
}

