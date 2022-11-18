package com.arquitectura.crud.ArquitecturaCRUDApp.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.arquitectura.crud.ArquitecturaCRUDApp.modelo.Cliente;

public interface ClienteRepositorio extends JpaRepository<Cliente, Integer>{
	

}
