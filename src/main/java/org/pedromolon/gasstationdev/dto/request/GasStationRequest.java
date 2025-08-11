package org.pedromolon.gasstationdev.dto.request;

public record GasStationRequest(
        String name,
        Long fuelId
) {}
