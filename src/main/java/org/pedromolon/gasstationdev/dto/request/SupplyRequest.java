package org.pedromolon.gasstationdev.dto.request;

import java.math.BigDecimal;

public record SupplyRequest(
        Long pumpId,
        Double quantity,
        BigDecimal price
) {
}
