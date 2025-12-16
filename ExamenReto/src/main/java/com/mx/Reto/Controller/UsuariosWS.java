package com.mx.Reto.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.Reto.Dto.UsuariosDto;
import com.mx.Reto.Respuesta.Respuesta;
import com.mx.Reto.Service.UsuariosImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping(path = "UsuariosWS")
@CrossOrigin
public class UsuariosWS {

	@Autowired
	UsuariosImpl impl;

	@GetMapping("listar")
	public ResponseEntity<?> listar() {
		Respuesta response = impl.listar();
		if (response.getSuccess()) {
			return new ResponseEntity<>(response, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(response, HttpStatus.NO_CONTENT);
		}
	}

	@PostMapping("guardar")
	public ResponseEntity<?> guardar(@RequestBody UsuariosDto dto) {
		Respuesta response = impl.guardar(dto);
		if (response.getSuccess()) {
			return new ResponseEntity<>(response, HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}

	}

	@GetMapping("buscar/{id}")
	public ResponseEntity<?> buscar(@PathVariable("id") Integer id) {
		Respuesta response = impl.buscar(id);
		if (response.getSuccess()) {
			return new ResponseEntity<>(response, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping("editar")
	public ResponseEntity<?> editar(@RequestBody UsuariosDto dto) {
		Respuesta response = impl.editar(dto);
		if (response.getSuccess()) {
			return new ResponseEntity<>(response, HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}

	}

	@DeleteMapping("eliminar/{id}")
	public ResponseEntity<?> eliminar(@PathVariable("id") Integer id) {
		Respuesta response = impl.eliminar(id);
		if (response.getSuccess()) {
			return new ResponseEntity<>(response, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		}
	}

}
