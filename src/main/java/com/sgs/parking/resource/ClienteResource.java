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

import com.sgs.parking.domain.Cliente;
import com.sgs.parking.service.ClienteService;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteResource {
	

	@Autowired
	private ClienteService clienteService;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Optional<Cliente> find(@PathVariable Integer id) {
		Optional<Cliente> objCliente = clienteService.find(id);
		return objCliente;
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<Cliente> findAll() {
		List<Cliente> listCliente = clienteService.findAll();
			return listCliente;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Cliente objCliente) {
		objCliente = clienteService.insert(objCliente);
		return null;
	}
}
