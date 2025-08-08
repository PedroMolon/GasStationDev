package org.pedromolon.gasstationdev.mapper;

import lombok.experimental.UtilityClass;
import org.pedromolon.gasstationdev.dto.request.FuelRequest;
import org.pedromolon.gasstationdev.dto.response.FuelResponse;
import org.pedromolon.gasstationdev.entity.Fuel;

@UtilityClass
public class FuelMapper {

    public static Fuel toEntity(FuelRequest request) {
        return Fuel.builder()
                .name(request.name())
                .price(request.price())
                .build();
    }

    public static FuelResponse toResponse(Fuel fuel) {
        return FuelResponse.builder()
                .id(fuel.getId())
                .name(fuel.getName())
                .price(fuel.getPrice())
                .build();
    }

}
