package org.pedromolon.gasstationdev.repository;

import org.pedromolon.gasstationdev.entity.Supply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplyRepository extends JpaRepository<Supply, Long> {
}
