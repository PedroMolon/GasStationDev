package org.pedromolon.gasstationdev.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "pumps")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pump {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gas_station_id", nullable = false)
    private GasStation gasStation;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fuel_id", nullable = false)
    private Fuel fuel;
}

