package org.pedromolon.gasstationdev.repository;

import org.pedromolon.gasstationdev.entity.Fuel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuelRepository extends JpaRepository<Fuel, Long> {
}
