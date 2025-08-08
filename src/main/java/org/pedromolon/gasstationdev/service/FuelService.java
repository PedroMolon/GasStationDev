package org.pedromolon.gasstationdev.service;

import lombok.RequiredArgsConstructor;
import org.pedromolon.gasstationdev.entity.Fuel;
import org.pedromolon.gasstationdev.repository.FuelRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FuelService {

    private final FuelRepository fuelRepository;

    public List<Fuel> getAllFuels() {
        return fuelRepository.findAll();
    }

    public Fuel getFuelById(Long id) {
        return fuelRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Fuel not found with id: " + id));
    }

    public Fuel saveFuel(Fuel fuel) {
        return fuelRepository.save(fuel);
    }

    public Fuel updateFuel(Long id, Fuel fuel) {
        Fuel foundFuel = fuelRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Fuel not found with id:" + id));
        foundFuel.setName(fuel.getName());
        foundFuel.setPrice(fuel.getPrice());
        return fuelRepository.save(foundFuel);
    }

    public void deleteFuel(Long id) {
        fuelRepository.deleteById(id);
    }

}
