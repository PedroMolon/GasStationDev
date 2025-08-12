package org.pedromolon.gasstationdev.controller;

import org.pedromolon.gasstationdev.dto.request.SupplyRequest;
import org.pedromolon.gasstationdev.dto.response.SupplyResponse;
import org.pedromolon.gasstationdev.mapper.SupplyMapper;
import org.pedromolon.gasstationdev.service.SupplyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gasstationdev/supplies")
public class SupplyController {

    private final SupplyService supplyService;

    public SupplyController(SupplyService supplyService) {
        this.supplyService = supplyService;
    }

    @GetMapping
    public ResponseEntity<List<SupplyResponse>> getAllSupplies() {
        return ResponseEntity.ok().body(supplyService.getAllSupplies().stream()
                .map(SupplyMapper::toResponse)
                .toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SupplyResponse> getSupplyById(@PathVariable Long id) {
        return ResponseEntity.ok().body(SupplyMapper.toResponse(supplyService.getSupplyById(id)));
    }

    @PostMapping
    public ResponseEntity<SupplyResponse> saveSupply(@RequestBody SupplyRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(SupplyMapper.toResponse(supplyService.createSupply(SupplyMapper.toEntity(request))));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SupplyResponse> updateSupply(@PathVariable Long id, @RequestBody SupplyRequest request) {
        return ResponseEntity.ok().body(SupplyMapper.toResponse(supplyService.updateSupply(id, SupplyMapper.toEntity(request))));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSupply(@PathVariable Long id) {
        supplyService.deleteSupply(id);
        return ResponseEntity.ok().build();
    }

}
