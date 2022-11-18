package com.arquitectura.crud.ArquitecturaCRUDApp.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.arquitectura.crud.ArquitecturaCRUDApp.modelo.Cliente;
import com.arquitectura.crud.ArquitecturaCRUDApp.servicio.ClienteServicio;

@Controller
public class ClienteCotrolador {
	
	@Autowired
	ClienteServicio clienteServicio;
	

	@GetMapping("/home")
		public String mostrarHome() {
			return "index";	
		}

	@GetMapping({ "/", "/vistaClientes" })
	public String vistaClientes(String mensaje, Model model)
	{
		List<Cliente> clientList = clienteServicio.getAllClientes();
		model.addAttribute("cliList", clientList);
		model.addAttribute("mensaje", mensaje);
		return "VistaClientes";
	}

	@GetMapping("/nuevoClientes")
	public String nuevoClientes(String mensaje, Model model)
	{
		model.addAttribute("cli", new Cliente());
		model.addAttribute("mensaje", mensaje);
		return "AgregarCliente";
	}

	@PostMapping("/guardarClientes")
	public String guardarClientes(Cliente cliente, RedirectAttributes redirectAttributes)
	{
		if (clienteServicio.guardarOrActualizarCliente(cliente)) {
			redirectAttributes.addFlashAttribute("mensaje", "Cliente creado");
			return "redirect:/vistaClientes";
		} else {
			redirectAttributes.addFlashAttribute("mensaje", "algo salio mal");
			return "redirect:/agregarCliente";
		}

	}

	@GetMapping("/editarCliente/{id}")
	public String editarCliente(@PathVariable Integer id, String mensaje, Model model) {
		Cliente cliente = clienteServicio.getClienteId(id);
		model.addAttribute("cli", cliente);
		model.addAttribute("mensaje", mensaje);
		return "EditarCliente";

	}

	@PostMapping("/guardarYactualizar")
	public String guardarYactualizar(Cliente cli, RedirectAttributes redirectAttributes) {
		if(clienteServicio.guardarOrActualizarCliente(cli)) {
			redirectAttributes.addFlashAttribute("mensaje", "Cliente editado con exito");
			return "redirect:/vistaClientes";
		}
		else
		{
			redirectAttributes.addFlashAttribute("mensaje", "Algo salio mal");
			return "redirect:/editarCliente/"+cli.getId();
		}
	}

	@GetMapping("/eliminarCliente/{id}")
	public String eliminarCliente(@PathVariable Integer id, RedirectAttributes redirectAttributes) {
		if(clienteServicio.eliminarCliente(id)) {
			redirectAttributes.addFlashAttribute("mensaje", "El cliente ha sido eliminado con exito");
			return "redirect:/vistaClientes";
		}
		else
		{
			redirectAttributes.addFlashAttribute("mensaje", "La eliminación del cliente ha sido fallido");
			return "redirect:/vistaClientes";
		}
	}
}
