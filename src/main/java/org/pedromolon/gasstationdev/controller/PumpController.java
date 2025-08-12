package org.pedromolon.gasstationdev.controller;

import org.pedromolon.gasstationdev.dto.request.PumpRequest;
import org.pedromolon.gasstationdev.dto.response.PumpResponse;
import org.pedromolon.gasstationdev.mapper.PumpMapper;
import org.pedromolon.gasstationdev.service.PumpService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gasstationdev/pumps")
public class PumpController {

    private final PumpService pumpService;

    public PumpController(PumpService pumpService) {
        this.pumpService = pumpService;
    }

    @GetMapping
    public ResponseEntity<List<PumpResponse>> getAllPumps() {
        return ResponseEntity.ok().body(pumpService.getAllPumps().stream()
                .map(PumpMapper::toResponse)
                .toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PumpResponse> getPumpById(@PathVariable Long id) {
        return ResponseEntity.ok().body(PumpMapper.toResponse(pumpService.getPumpById(id)));
    }

    @PostMapping
    public ResponseEntity<PumpResponse> savePump(@RequestBody PumpRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(PumpMapper.toResponse(pumpService.createPump(PumpMapper.toEntity(request))));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PumpResponse> updatePump(@PathVariable Long id, @RequestBody PumpRequest request) {
        return ResponseEntity.ok().body(PumpMapper.toResponse(pumpService.updatePump(id, PumpMapper.toEntity(request))));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePump(@PathVariable Long id) {
        pumpService.deletePump(id);
        return ResponseEntity.noContent().build();
    }
}

