package org.pedromolon.gasstationdev.service;

import lombok.RequiredArgsConstructor;
import org.pedromolon.gasstationdev.entity.Pump;
import org.pedromolon.gasstationdev.exception.ResourceNotFoundException;
import org.pedromolon.gasstationdev.repository.PumpRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PumpService {

    private final PumpRepository pumpRepository;

    public List<Pump> getAllPumps() {
        return pumpRepository.findAll();
    }

    public Pump getPumpById(Long id) {
        return pumpRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Pump not found with id: " + id));
    }

    public Pump createPump(Pump pump) {
        return pumpRepository.save(pump);
    }

    public Pump updatePump(Long id, Pump pump) {
        Pump foundPump = pumpRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Pump not found with id: " + id));
        foundPump.setName(pump.getName());
        foundPump.setGasStation(pump.getGasStation());
        foundPump.setFuel(pump.getFuel());
        return pumpRepository.save(foundPump);
    }

    public void deletePump(Long id) {
        if (!pumpRepository.existsById(id)) {
            throw new ResourceNotFoundException("Pump not found with id: " + id);
        }
        pumpRepository.deleteById(id);
    }
}

