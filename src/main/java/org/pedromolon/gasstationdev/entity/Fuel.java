package org.pedromolon.gasstationdev.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "fuels")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Fuel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Double price;

}
