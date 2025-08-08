package org.pedromolon.gasstationdev.dto.response;

import lombok.Builder;

@Builder
public record FuelResponse(
        Long id,
        String name,
        Double price
) {}
