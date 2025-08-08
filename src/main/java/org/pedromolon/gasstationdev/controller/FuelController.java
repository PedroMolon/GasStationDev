package org.pedromolon.gasstationdev.controller;

import org.pedromolon.gasstationdev.dto.request.FuelRequest;
import org.pedromolon.gasstationdev.dto.response.FuelResponse;
import org.pedromolon.gasstationdev.mapper.FuelMapper;
import org.pedromolon.gasstationdev.service.FuelService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gasstationdev/fuels")
public class FuelController {

    private final FuelService fuelService;

    public FuelController(FuelService fuelService) {
        this.fuelService = fuelService;
    }

    @GetMapping
    public ResponseEntity<List<FuelResponse>> getAllFuels() {
        return ResponseEntity.ok().body(fuelService.getAllFuels()
                .stream()
                .map(FuelMapper::toResponse)
                .toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<FuelResponse> getFuelById(@PathVariable Long id) {
        return ResponseEntity.ok().body(FuelMapper.toResponse(fuelService.getFuelById(id)));
    }

    @PostMapping
    public ResponseEntity<FuelResponse> saveFuel(@RequestBody FuelRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(FuelMapper.toResponse(fuelService.saveFuel(FuelMapper.toEntity(request))));
    }

    @PutMapping("/{id}")
    public ResponseEntity<FuelResponse> updateFuel(@PathVariable Long id, @RequestBody FuelRequest request) {
        return ResponseEntity.ok().body(FuelMapper.toResponse(fuelService.updateFuel(id, FuelMapper.toEntity(request))));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFuel(@PathVariable Long id) {
        fuelService.deleteFuel(id);
        return ResponseEntity.ok().body(null);
    }

}
