package com.sgs.parking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sgs.parking.domain.Veiculo;
import com.sgs.parking.repositories.VeiculoRepository;

@Service
public class VeiculoService {

	
	@Autowired
	private VeiculoRepository veiculoRepository;

	public List<Veiculo> findAll() {
		return veiculoRepository.findAll();

	}
	@Transactional
	public Veiculo insert(Veiculo objVeiculo) {
		objVeiculo.setId(null);
		objVeiculo = veiculoRepository.save(objVeiculo);
		return objVeiculo;

	}
}
