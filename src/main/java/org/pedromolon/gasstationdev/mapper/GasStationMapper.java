package org.pedromolon.gasstationdev.mapper;

import org.pedromolon.gasstationdev.dto.request.GasStationRequest;
import org.pedromolon.gasstationdev.dto.response.GasStationResponse;
import org.pedromolon.gasstationdev.entity.GasStation;

import java.util.Collections;
import java.util.stream.Collectors;

public class GasStationMapper {

    public static GasStation toEntity(GasStationRequest request) {
        return GasStation.builder()
                .name(request.name())
                .build();
    }

    public static GasStationResponse toResponse(GasStation gasStation) {
        return GasStationResponse.builder()
                .id(gasStation.getId())
                .name(gasStation.getName())
                .pumps(gasStation.getPumps() != null ? gasStation.getPumps().stream()
                        .map(PumpMapper::toResponse)
                        .collect(Collectors.toList()) : Collections.emptyList())
                .build();
    }
}
