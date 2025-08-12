package org.pedromolon.gasstationdev.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "supplies")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Supply {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pump_id", nullable = false)
    private Pump pump;

    private LocalDateTime date;

    private Double quantity;

    private BigDecimal price;

}
