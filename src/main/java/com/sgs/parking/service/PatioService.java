package com.sgs.parking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sgs.parking.domain.Patio;
import com.sgs.parking.repositories.PatioRepository;

@Service
public class PatioService {

	
	@Autowired
	private PatioRepository patioRepository;

	public List<Patio> findAll() {
		return patioRepository.findAll();

	}
	@Transactional
	public Patio insert(Patio objPatio) {
		objPatio.setId(null);
		objPatio = patioRepository.save(objPatio);
		return objPatio;

	}
}
