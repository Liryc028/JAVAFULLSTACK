package com.mx.Reto.Dominio;

import java.time.LocalDate;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "USUARIOS_EXAMEN")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Usuarios {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	String nombre;
	String app;
	@Column(name = "FECHA_NACIMIENTO")
	LocalDate fechaNacimiento;
	String telefono;
	String email;
}
