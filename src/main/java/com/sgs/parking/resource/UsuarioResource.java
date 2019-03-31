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

import com.sgs.parking.domain.Usuario;
import com.sgs.parking.service.UsuarioService;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioResource {
	

	@Autowired
	private UsuarioService usuarioService;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Optional<Usuario> find(@PathVariable Integer id) {
		Optional<Usuario> objUsuario = usuarioService.find(id);
		return objUsuario;
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<Usuario> findAll() {
		List<Usuario> listUsuario = usuarioService.findAll();
			return listUsuario;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Usuario objUsuario) {
		objUsuario = usuarioService.insert(objUsuario);
		return null;
	}
}
