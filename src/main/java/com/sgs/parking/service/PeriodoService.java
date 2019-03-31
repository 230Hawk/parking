package com.sgs.parking.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sgs.parking.domain.Periodo;
import com.sgs.parking.repositories.PeriodoRepository;

@Service
public class PeriodoService {

	
	@Autowired
	private PeriodoRepository periodoRepository;
	
	
	public Optional<Periodo> find(Integer id) {
		Optional<Periodo> objperiodo = periodoRepository.findById(id);
		return objperiodo;
	}

	public List<Periodo> findAll() {
		return periodoRepository.findAll();

	}
	@Transactional
	public Periodo insert(Periodo objPeriodo) {
		objPeriodo.setId(null);
		Date saida = objPeriodo.getSaida();
		Date entrada = objPeriodo.getEntrada();
		 long diffInMillies = Math.abs(saida.getTime() - entrada.getTime());
		 long diff = TimeUnit.HOURS.convert(diffInMillies, TimeUnit.MILLISECONDS);
		 System.out.println("Intervalo :" + diff);
		 System.out.println("Taxa :" + objPeriodo.getPatio().getTaxa());
		Double total = diff * objPeriodo.getPatio().getTaxa();
		objPeriodo.setTotal(total);
		objPeriodo = periodoRepository.save(objPeriodo);
		return objPeriodo;

	}
	

}
