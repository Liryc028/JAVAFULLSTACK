package com.mx.Reto.Service;

import com.mx.Reto.Dto.UsuariosDto;
import com.mx.Reto.Respuesta.Respuesta;

public interface UsuariosMetodos {
	
	Respuesta guardar(UsuariosDto dto);
	
	Respuesta buscar(Integer id);
	
	Respuesta editar(UsuariosDto dto);
	
	Respuesta eliminar(Integer id);
	
	Respuesta listar();

}
