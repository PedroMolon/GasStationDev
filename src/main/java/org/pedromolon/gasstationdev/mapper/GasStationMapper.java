package org.pedromolon.gasstationdev.mapper;

import lombok.experimental.UtilityClass;
import org.pedromolon.gasstationdev.dto.request.GasStationRequest;
import org.pedromolon.gasstationdev.dto.response.GasStationResponse;
import org.pedromolon.gasstationdev.entity.Fuel;
import org.pedromolon.gasstationdev.entity.GasStation;

@UtilityClass
public class GasStationMapper {

    public static Fuel getFuelById(Long id) {
        return Fuel.builder().id(id).build();
    }

    public static GasStation toEntity(GasStationRequest request) {
        return GasStation.builder()
                .name(request.name())
                .fuel(getFuelById(request.fuelId()))
                .build();
    }

    public static GasStationResponse toResponse(GasStation gasStation) {
        return GasStationResponse.builder()
                .id(gasStation.getId())
                .name(gasStation.getName())
                .fuel(gasStation.getFuel())
                .build();
    }

}
