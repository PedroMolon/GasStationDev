package org.pedromolon.gasstationdev.mapper;

import org.pedromolon.gasstationdev.dto.request.PumpRequest;
import org.pedromolon.gasstationdev.dto.response.PumpResponse;
import org.pedromolon.gasstationdev.entity.Fuel;
import org.pedromolon.gasstationdev.entity.GasStation;
import org.pedromolon.gasstationdev.entity.Pump;

public class PumpMapper {

    public static Pump toEntity(PumpRequest request) {
        return Pump.builder()
                .name(request.name())
                .gasStation(GasStation.builder().id(request.gasStationId()).build())
                .fuel(Fuel.builder().id(request.fuelId()).build())
                .build();
    }

    public static PumpResponse toResponse(Pump pump) {
        return PumpResponse.builder()
                .id(pump.getId())
                .name(pump.getName())
                .gasStationId(pump.getGasStation().getId())
                .fuelId(pump.getFuel().getId())
                .build();
    }
}

