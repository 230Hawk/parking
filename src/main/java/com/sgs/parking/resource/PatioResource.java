package com.sgs.parking.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sgs.parking.domain.Patio;
import com.sgs.parking.service.PatioService;

@RestController
@RequestMapping(value = "/patios")
public class PatioResource {
	

	@Autowired
	private PatioService patioService;

	@RequestMapping(method = RequestMethod.GET)
	public List<Patio> findAll() {
		List<Patio> listPatio = patioService.findAll();
			return listPatio;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Patio objPatio) {
		objPatio = patioService.insert(objPatio);
		return null;
	}
}
