package com.sgs.parking.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sgs.parking.domain.Cliente;
import com.sgs.parking.repositories.ClienteRepository;

@Service
public class ClienteService {

	
	@Autowired
	private ClienteRepository clienteRepository;
	
	
	public Optional<Cliente> find(Integer id) {
		Optional<Cliente> objcliente = clienteRepository.findById(id);
		return objcliente;
	}

	public List<Cliente> findAll() {
		return clienteRepository.findAll();

	}
	@Transactional
	public Cliente insert(Cliente objCliente) {
		objCliente.setId(null);
		objCliente = clienteRepository.save(objCliente);
		return objCliente;

	}
}
