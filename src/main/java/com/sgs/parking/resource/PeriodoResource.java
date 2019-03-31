package com.sgs.parking.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sgs.parking.domain.Periodo;
import com.sgs.parking.service.PeriodoService;

@RestController
@RequestMapping(value = "/periodos")
public class PeriodoResource {
	

	@Autowired
	private PeriodoService periodoService;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Optional<Periodo> find(@PathVariable Integer id) {
		Optional<Periodo> objPeriodo = periodoService.find(id);
		return objPeriodo;
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<Periodo> findAll() {
		List<Periodo> listPeriodo = periodoService.findAll();
			return listPeriodo;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Periodo objPeriodo) {
		objPeriodo = periodoService.insert(objPeriodo);
		return null;
	}
}
