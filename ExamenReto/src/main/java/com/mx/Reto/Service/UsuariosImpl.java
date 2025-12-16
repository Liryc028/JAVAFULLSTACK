package com.mx.Reto.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.Reto.Dao.UsuariosDao;
import com.mx.Reto.Dominio.Usuarios;
import com.mx.Reto.Dto.UsuariosDto;
import com.mx.Reto.Respuesta.Respuesta;

@Service
public class UsuariosImpl implements UsuariosMetodos {

	@Autowired
	UsuariosDao dao;

	@Override
	public Respuesta guardar(UsuariosDto dto) {

		Usuarios user = new Usuarios();

		user.setNombre(dto.getNombre());
		user.setApp(dto.getApp());
		user.setFechaNacimiento(dto.getFechaNacimiento());
		user.setTelefono(dto.getTelefono());
		user.setEmail(dto.getEmail());
		dao.save(user);

		return new Respuesta("Se guardo el usuario exitosamente!", true, user);
	}

	@Override
	public Respuesta buscar(Integer id) {
		Usuarios usuBuscar = dao.findById(id).orElse(null);
		if (usuBuscar != null) {
			return new Respuesta("Se econtro el usuario:", true, usuBuscar);
		} else {
			return new Respuesta("No existe el usuario con ese id", false, null);
		}
	}

	@Override
	public Respuesta editar(UsuariosDto dto) {

		Usuarios userExistente = dao.findById(dto.getId()).orElse(null);
		if (userExistente == null) {
			return new Respuesta("No existe usuario con ese id.", false, null);
		}

		userExistente.setNombre(dto.getNombre());
		userExistente.setApp(dto.getApp());
		userExistente.setFechaNacimiento(dto.getFechaNacimiento());
		userExistente.setTelefono(dto.getTelefono());
		userExistente.setEmail(dto.getEmail());
		dao.save(userExistente);

		return new Respuesta("Se edito el usuario exitosamente!", true, userExistente);
	}

	@Override
	public Respuesta eliminar(Integer id) {
		if (dao.existsById(id)) {
			dao.deleteById(id);
			return new Respuesta("Se elimino el cliente.", true, null);
		} else {
			return new Respuesta("No existe el usuario con ese id.", false, null);
		}
	}

	@Override
	public Respuesta listar() {
		List<Usuarios> lista = (List<Usuarios>) dao.findAll();
		if (!lista.isEmpty()) {
			return new Respuesta("La lista contiene : ", true, lista);
		} else {
			return new Respuesta("La lista esta vacia", false, null);
		}
	}

}
