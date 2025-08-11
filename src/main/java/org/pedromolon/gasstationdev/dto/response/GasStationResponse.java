package org.pedromolon.gasstationdev.dto.response;

import lombok.Builder;
import org.pedromolon.gasstationdev.entity.Fuel;

@Builder
public record GasStationResponse(
        Long id,
        String name,
        Fuel fuel
) {}
