package com.mx.Reto.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mx.Reto.Dominio.Usuarios;

@Repository
public interface UsuariosDao extends JpaRepository<Usuarios, Integer>{

}
