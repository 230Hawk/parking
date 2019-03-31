package com.sgs.parking.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sgs.parking.domain.Patio;

@Repository
public interface PatioRepository extends JpaRepository<Patio, Integer> {

}
