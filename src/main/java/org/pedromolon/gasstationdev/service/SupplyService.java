package org.pedromolon.gasstationdev.service;

import lombok.RequiredArgsConstructor;
import org.pedromolon.gasstationdev.entity.Supply;
import org.pedromolon.gasstationdev.exception.ResourceNotFoundException;
import org.pedromolon.gasstationdev.repository.SupplyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SupplyService {

    private final SupplyRepository supplyRepository;

    public List<Supply> getAllSupplies() {
        return supplyRepository.findAll();
    }

    public Supply getSupplyById(Long id) {
        return supplyRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Supply not found"));
    }

    public Supply createSupply(Supply supply) {
        return supplyRepository.save(supply);
    }

    public Supply updateSupply(Long id, Supply supply) {
        Supply foundSupply = supplyRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Supply not found"));
        foundSupply.setPump(supply.getPump());
        foundSupply.setPrice(supply.getPrice());
        foundSupply.setQuantity(supply.getQuantity());
        return supplyRepository.save(foundSupply);
    }

    public void deleteSupply(Long id) {
        if (supplyRepository.findById(id).isEmpty()) {
            throw new ResourceNotFoundException("Supply not found with id: " + id);
        }
        supplyRepository.deleteById(id);
    }

}
