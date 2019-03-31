package com.sgs.parking.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sgs.parking.domain.Periodo;

@Repository
public interface PeriodoRepository extends JpaRepository<Periodo, Integer> {

	
}
