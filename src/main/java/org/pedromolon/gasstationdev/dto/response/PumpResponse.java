package org.pedromolon.gasstationdev.dto.response;

import lombok.Builder;

@Builder
public record PumpResponse(
        Long id,
        String name,
        Long gasStationId,
        Long fuelId
) {
}

