package com.mx.Reto.Dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuariosDto {
	
	Integer id;
	String nombre;
	String app;
	LocalDate fechaNacimiento;
	String telefono;
	String email;
}
