package org.pedromolon.gasstationdev.repository;

import org.pedromolon.gasstationdev.entity.Pump;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PumpRepository extends JpaRepository<Pump, Long> {
}

