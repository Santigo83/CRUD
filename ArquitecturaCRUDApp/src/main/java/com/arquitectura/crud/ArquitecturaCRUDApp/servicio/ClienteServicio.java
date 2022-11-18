package com.arquitectura.crud.ArquitecturaCRUDApp.servicio;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arquitectura.crud.ArquitecturaCRUDApp.modelo.Cliente;
import com.arquitectura.crud.ArquitecturaCRUDApp.repositorio.ClienteRepositorio;

@Service
public class ClienteServicio {
	
	@Autowired
	ClienteRepositorio clienteRepositorio;
	
	public List<Cliente> getAllClientes(){
		List<Cliente> list = new ArrayList<>();
		clienteRepositorio.findAll().forEach(cliente -> list.add(cliente));
		return list;
	}
	
	public Cliente getClienteId(Integer id) {
		return clienteRepositorio.findById(id).get();
	}
	
	public boolean guardarOrActualizarCliente(Cliente cliente) {
		
		Cliente client = clienteRepositorio.save(cliente);
		if(client != null && clienteRepositorio.findById(client.getId())!=null) {
			return true;
		}
		else
		{
			return false;	
		}
		
	}
	
	public boolean eliminarCliente(Integer id)
	{
		clienteRepositorio.deleteById(id);
		if(clienteRepositorio.findById(id) != null)
		{
			return false;
		}
		else
		{
			return true;
		}
		
	}

}
