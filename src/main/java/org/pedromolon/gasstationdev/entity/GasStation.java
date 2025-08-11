package org.pedromolon.gasstationdev.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "gastations")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GasStation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    private Fuel fuel;

}
