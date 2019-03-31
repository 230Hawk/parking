package com.sgs.parking.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sgs.parking.domain.Usuario;
import com.sgs.parking.repositories.UsuarioRepository;

@Service
public class UsuarioService {

	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	
	public Optional<Usuario> find(Integer id) {
		Optional<Usuario> objusuario = usuarioRepository.findById(id);
		return objusuario;
	}

	public List<Usuario> findAll() {
		return usuarioRepository.findAll();

	}
	@Transactional
	public Usuario insert(Usuario objUsuario) {
		objUsuario.setId(null);
		objUsuario = usuarioRepository.save(objUsuario);
		return objUsuario;

	}
}
