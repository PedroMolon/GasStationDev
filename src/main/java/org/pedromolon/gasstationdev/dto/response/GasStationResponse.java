package org.pedromolon.gasstationdev.dto.response;

import lombok.Builder;
import org.pedromolon.gasstationdev.dto.response.PumpResponse;

import java.util.List;

@Builder
public record GasStationResponse(
        Long id,
        String name,
        List<PumpResponse> pumps
) {
}
