package org.pedromolon.gasstationdev.service;

import lombok.RequiredArgsConstructor;
import org.pedromolon.gasstationdev.entity.GasStation;
import org.pedromolon.gasstationdev.repository.GasStationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GasStationService {

    private final GasStationRepository gasStationRepository;

    public List<GasStation> getAllGasStations() {
        return gasStationRepository.findAll();
    }

    public GasStation getGasStationById(Long id) {
        return gasStationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("GasStation not found with id: " + id));
    }

    public GasStation createGasStation(GasStation gasStation) {
        return gasStationRepository.save(gasStation);
    }

    public GasStation updateGasStation(Long id, GasStation gasStation) {
        GasStation foundGasStation = gasStationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("GasStation not found with id: " + id));
        foundGasStation.setName(gasStation.getName());
        foundGasStation.setFuel(gasStation.getFuel());
        return gasStationRepository.save(foundGasStation);
    }

    public void deleteGasStation(Long id) {
        gasStationRepository.deleteById(id);
    }

}
