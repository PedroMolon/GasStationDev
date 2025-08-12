package org.pedromolon.gasstationdev.controller;

import org.pedromolon.gasstationdev.dto.request.GasStationRequest;
import org.pedromolon.gasstationdev.dto.response.GasStationResponse;
import org.pedromolon.gasstationdev.mapper.GasStationMapper;
import org.pedromolon.gasstationdev.service.GasStationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gasstationdev/gasstations")
public class GasStationController {

    private final GasStationService gasStationService;

    public GasStationController(GasStationService gasStationService) {
        this.gasStationService = gasStationService;
    }

    @GetMapping
    public ResponseEntity<List<GasStationResponse>> getAllGasStations() {
        return ResponseEntity.ok().body(gasStationService.getAllGasStations().stream()
                .map(GasStationMapper::toResponse)
                .toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<GasStationResponse> getGasStationById(@PathVariable Long id) {
        return ResponseEntity.ok().body(GasStationMapper.toResponse(gasStationService.getGasStationById(id)));
    }

    @PostMapping
    public ResponseEntity<GasStationResponse> saveGasStation(@RequestBody GasStationRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(GasStationMapper.toResponse(gasStationService.createGasStation(GasStationMapper.toEntity(request))));
    }

    @PutMapping("/{id}")
    public ResponseEntity<GasStationResponse> updateGasStation(@PathVariable Long id, @RequestBody GasStationRequest request) {
        return ResponseEntity.ok().body(GasStationMapper.toResponse(gasStationService.updateGasStation(id, GasStationMapper.toEntity(request))));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGasStation(@PathVariable Long id) {
        gasStationService.deleteGasStation(id);
        return ResponseEntity.noContent().build();
    }

}
