package org.pedromolon.gasstationdev.mapper;

import org.pedromolon.gasstationdev.dto.request.SupplyRequest;
import org.pedromolon.gasstationdev.dto.response.SupplyResponse;
import org.pedromolon.gasstationdev.entity.Pump;
import org.pedromolon.gasstationdev.entity.Supply;

import java.time.LocalDateTime;

public class SupplyMapper {

    public static Supply toEntity(SupplyRequest request) {
        return Supply.builder()
                .pump(Pump.builder().id(request.pumpId()).build())
                .date(LocalDateTime.now())
                .quantity(request.quantity())
                .price(request.price())
                .build();
    }

    public static SupplyResponse toResponse(Supply supply) {
        return SupplyResponse.builder()
                .id(supply.getId())
                .pumpId(supply.getPump().getId())
                .date(supply.getDate())
                .quantity(supply.getQuantity())
                .price(supply.getPrice())
                .build();
    }
}
