package com.sgs.parking.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sgs.parking.domain.Veiculo;
import com.sgs.parking.service.VeiculoService;

@RestController
@RequestMapping(value = "/veiculos")
public class VeiculoResource {
	

	@Autowired
	private VeiculoService veiculoService;

	@RequestMapping(method = RequestMethod.GET)
	public List<Veiculo> findAll() {
		List<Veiculo> listVeiculo = veiculoService.findAll();
			return listVeiculo;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Veiculo objVeiculo) {
		objVeiculo = veiculoService.insert(objVeiculo);
		return null;
	}
}
