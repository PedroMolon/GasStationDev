package org.pedromolon.gasstationdev.repository;

import org.pedromolon.gasstationdev.entity.GasStation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GasStationRepository extends JpaRepository<GasStation, Long> {
}
