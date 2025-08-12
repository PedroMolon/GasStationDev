package org.pedromolon.gasstationdev.dto.response;

import lombok.Builder;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Builder
public record SupplyResponse(
        Long id,
        Long pumpId,
        LocalDateTime date,
        Double quantity,
        BigDecimal price
) {
}
