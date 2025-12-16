package com.mx.Reto.Respuesta;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Respuesta {
	String mensaje;
	Boolean success;
	Object obj;
}
