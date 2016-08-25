package com.sistema.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.catalina.connector.Request;
import org.jboss.logging.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestScope;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sistema.pojo.Domicilio;
import com.sistema.pojo.Usuario;
import com.sistema.service.DomicilioService;
import com.sistema.service.UsuarioService;

@Controller
@RequestMapping(value="/usuarios")
@SessionAttributes("usuarioSession")
public class UsuarioController {

	@Autowired
	public UsuarioService usuarioService;
	
	@Autowired
	public DomicilioService domicilioService;
	
	
	@RequestMapping("/usuariosList")
	public String showUsuarios(Model model,@ModelAttribute ("delete") String delete){

		List<Usuario> usuarios = usuarioService.findAll();
		model.addAttribute("usuarios", usuarios);
		//model.addAttribute("usuariosList", usuariosList);
		
		return "/jsp/usuario/usuariosView";
	}
	
	
	@RequestMapping("/administradorList")
	public String showAdmins(Model model,@ModelAttribute("resultadoForm") String resultado){
		
		model.addAttribute("resultado",resultado);
		List<Usuario> usuarioList = usuarioService.findAllAdmins();

		Usuario usuario = new Usuario();
		model.addAttribute("admin",usuario);
		model.addAttribute("admins",usuarioList);
	//	model.addAttribute("resultadoForm",resultadoForm);
		
		return "/jsp/usuario/administradorView";
	}
	
	@RequestMapping("/profesionalList")
	public String showProfesionales(Model model,@ModelAttribute("resultadoForm") String resultado){
		
		model.addAttribute("resultado",resultado);
		List<Usuario> usuarioList = usuarioService.findAllProfesionales();

		Usuario usuario = new Usuario();
		model.addAttribute("profesional",usuario);
		model.addAttribute("profesionales",usuarioList);
		//model.addAttribute("resultadoForm",resultado);
		
		return "/jsp/usuario/profesionalView";
	}
	
	@RequestMapping("/pacienteList")
	public String showPacientes(Model model){
		
		List<Usuario> pacientes = usuarioService.findAllPacientes();
		Usuario paciente = new Usuario();
		model.addAttribute("paciente",paciente);
		model.addAttribute("pacientes",pacientes);
		return "/jsp/usuario/pacienteView";
	}
	
	@RequestMapping("/administrador")
	public String handleAdmin(Model model,@ModelAttribute("adminForm") Usuario admin,
			@ModelAttribute("resultado") String resultado,
			@ModelAttribute("domicilio") Domicilio dom){
	
		
			model.addAttribute("adminForm",new Usuario());//instacia vacia para completar en /save x ejemplo
			model.addAttribute("domicilio",new Domicilio());
			model.addAttribute("resultadoCargar",resultado);
		
		
		return "/jsp/usuario/administradorForm";
	}
	
	@RequestMapping("/profesional")
	public String showProfesional(Model model,@ModelAttribute("profesionalForm") Usuario user,
			@ModelAttribute("resultado") String resultado){
	
			model.addAttribute("profesionalForm",new Usuario());
			model.addAttribute("domicilio",new Domicilio());
			model.addAttribute("resultadoCargar",resultado);
		
		return "/jsp/usuario/profesionalForm";
	}
	
	@RequestMapping("/paciente")
	public String showPaciente(Model model,@ModelAttribute("pacienteForm") Usuario user,
			@ModelAttribute("resultado") String resultado){
		
		
			model.addAttribute("pacienteForm",new Usuario());
			model.addAttribute("domicilio",new Domicilio());
			model.addAttribute("resultadoCargar",resultado);
				
		return "/jsp/usuario/pacienteForm";
	}
	
	
	
	@RequestMapping(value = "/administrador/save", method=RequestMethod.POST)
	public String handleAdmin(Model model,@ModelAttribute("adminForm") Usuario admin,
			BindingResult result, RedirectAttributes ra, 
			@RequestParam("password2") String pass2,
			@RequestParam(value="provincia") String prov,
			@RequestParam(value="localidad") String loc,
			@RequestParam(value="direccion") String dir,
			@RequestParam(value="id_domicilio") int id_domicilio			
			){
		
			
				try {
					Domicilio domicilio = new Domicilio(id_domicilio,prov,loc,dir);
					model.addAttribute("adminForm", admin);
					model.addAttribute("domicilio",domicilio);
					System.out.println("domiclio:" + domicilio);
					usuarioService.saveOrUpdate(admin);
					System.out.println("usuario_id: " + admin.getId_usuario() );
					domicilioService.saveOrUpdate(admin, domicilio);
					
					ra.addAttribute("resultado", "Datos Cargados Correctamente");
					
				} catch (Exception e) {
					ra.addAttribute("resultado", "Error al Cargar los Datos");
					e.printStackTrace();
				}		
			
			return "redirect:/usuarios/administrador";

	}
	
	@RequestMapping(value = "/profesional/save", method=RequestMethod.POST)
	public String handleProfesional(Model model,@ModelAttribute("profesionalForm") Usuario profesional,
			BindingResult result, RedirectAttributes ra,
			@RequestParam("password2") String pass2,
			@RequestParam(value="provincia") String prov,
			@RequestParam(value="localidad") String loc,
			@RequestParam(value="direccion") String dir,
			@RequestParam(value="id_domicilio") int id_domicilio){
		
			try {
				Domicilio domic = new Domicilio(id_domicilio,prov, loc, dir);
			
				model.addAttribute("profesional", profesional);
				usuarioService.saveOrUpdate(profesional);
				//System.out.println(domic.getUsuario().getId_usuario());
				domicilioService.saveOrUpdate(profesional, domic);
				ra.addAttribute("resultado", "Datos Cargados Correctamente");
			} catch (Exception e) {
				ra.addAttribute("resultado", "Error al Cargar Los Datos");	
				e.printStackTrace();
			}
			
			return "redirect:/usuarios/profesional";

	}
	
	@RequestMapping(value = "/paciente/save", method=RequestMethod.POST)
	public String handlePaciente(Model model,@ModelAttribute("pacienteForm") Usuario paciente,
			BindingResult result, RedirectAttributes ra, 
			@RequestParam(value="password2") String pass2,
			@RequestParam(value="provincia") String prov,
			@RequestParam(value="localidad") String loc,
			@RequestParam(value="direccion") String dir,
			@RequestParam(value="id_domicilio") int id_domicilio){

			try {
				Domicilio domic = new Domicilio(id_domicilio,prov, loc, dir);
				model.addAttribute("paciente", paciente);
				usuarioService.saveOrUpdate(paciente);
				System.out.println("fecha: "+paciente.getFechaAlta());
				domicilioService.saveOrUpdate(paciente, domic);
				ra.addAttribute("resultado", "Datos Cargados Correctamente");
			} catch (Exception e) {
				ra.addAttribute("resultado", "Error al Cargar Los Datos");
				e.printStackTrace();
			}
			
			return "redirect:/usuarios/paciente";

	}
	
	@RequestMapping(value="/administrador/{id}/update",method=RequestMethod.GET)
	public String showUpdate(Model model, @PathVariable("id")int idadmin){

		try {
		
			Usuario usuario = usuarioService.findById(idadmin);
			model.addAttribute("adminForm",usuario);
			Domicilio dom = domicilioService.findByUsuario(idadmin);
			model.addAttribute("domicilio",dom);
			
		System.out.println("US_CONTROLLER: "+ usuario.getId_usuario());
		System.out.println("US_CONTROLLER-DOM: "+ dom.getId_domicilio());
			
		} catch (Exception e) {
			System.out.println("Controllador Usuario Update: " + e.getMessage());
		
		}
		
		return "/jsp/usuario/administradorForm";
	}
	
	@RequestMapping(value="/profesional/{id}/update",method=RequestMethod.GET)
	public String showUpdateProfesional(Model model, @PathVariable("id")int id_prof){

		try {
		
			Usuario usuario = usuarioService.findById(id_prof);
			model.addAttribute("profesionalForm",usuario);
			Domicilio dom = domicilioService.findByUsuario(id_prof);
			model.addAttribute("domicilio",dom);
			
			
		} catch (Exception e) {
			System.out.println("Controllador UsuarioUpdate: " + e.getMessage());
		}
		
		return "/jsp/usuario/profesionalForm";
	}
	@RequestMapping(value="/paciente/{id}/update",method=RequestMethod.GET)
	public String showUpdatePaciente(Model model, @PathVariable("id")int id_pac){

		try {
		
			Usuario usuario = usuarioService.findById(id_pac);
			model.addAttribute("pacienteForm",usuario);
			System.out.println("fecha upd: "+ usuario.getFechaAlta());
			Domicilio dom = domicilioService.findByUsuario(id_pac);
			model.addAttribute("domicilio",dom);
			
		} catch (Exception e) {
			System.out.println("Controllador PacienteUpdate: " + e.getMessage());
			e.printStackTrace();
		}
		
		return "/jsp/usuario/pacienteForm";
	}
	
	
	@RequestMapping(value="/administrador/{id}/delete",method=RequestMethod.GET)
	public String showDeleteAdmin(Model model, @PathVariable("id")int id_usu,RedirectAttributes ra){

		try {
		
			Usuario usuario = usuarioService.findById(id_usu);
			usuarioService.Delete(usuario);
			ra.addFlashAttribute("delete", "Usuario Eliminado Correctamente");
		} catch (Exception e) {
			System.out.println("Controllador UsuarioDelete: " + e.getMessage());
			ra.addFlashAttribute("delete", "Usuario NO Eliminado");
			e.printStackTrace();
		}
		
		return "redirect:/usuarios/usuariosList";
		
		
	}
	
	@RequestMapping(value="/profesional/{id}/delete",method=RequestMethod.GET)
	public String showDeleteProfesional(Model model, @PathVariable("id")int id_usu, RedirectAttributes ra){

		try {
		
			Usuario usuario = usuarioService.findById(id_usu);
			usuarioService.Delete(usuario);
			ra.addFlashAttribute("delete", "Profesional Eliminado Correctamente");
				
		} catch (Exception e) {
			System.out.println("Controllador UsuarioDelete: " + e.getMessage());
			ra.addFlashAttribute("delete", "Profesional NO Eliminado");
			e.printStackTrace();
			
		}
		return "redirect:/usuarios/profesionalList";
		
	}
	
	@RequestMapping(value="/paciente/{id}/delete",method=RequestMethod.GET)
	public String showDeletePaciente(Model model, @PathVariable("id")int id_usu,RedirectAttributes ra){

		try {
		
			Usuario usuario = usuarioService.findById(id_usu);
			usuarioService.Delete(usuario);
			ra.addFlashAttribute("delete", "Paciente Eliminado Correctamente");
					
		} catch (Exception e) {
			System.out.println("Controllador UsuarioDelete: " + e.getMessage());
			ra.addFlashAttribute("delete", "Paciente NO Eliminado");
			e.printStackTrace();
		}
		return "redirect:/usuarios/pacienteList";	
	}
	@RequestMapping(value="/searchByName",method=RequestMethod.GET)
	public ModelAndView findAllUser(Model model,@RequestParam("apellido") String apellido, HttpServletRequest request){
		HttpSession session = request.getSession();
		Usuario usuario = (Usuario) session.getAttribute("usuarioSession");
		
		try {
			if(usuario.getRol().equals("ROLE_ADMIN")){
				List<Usuario> usuarios = usuarioService.findAllByName(apellido);
				ModelAndView modelo = new ModelAndView("/jsp/usuario/usuariosView", "usuarios", usuarios);
				return modelo;	
			}else if (usuario.getRol().equals("ROLE_PROFESIONAL") ) {
				List<Usuario> usuarios = usuarioService.findAllByNamePacientes(apellido);
				ModelAndView modelo = new ModelAndView("/jsp/usuario/profesionalesView", "pacientes", usuarios);
				return modelo;	
			}else {
			ModelAndView modelo = new ModelAndView("/jsp/usuario/usuariosView");
			return modelo;
			}
		} catch (Exception e) {
			System.out.println("Excepcion en Redireccionar: " + e.getMessage());
			ModelAndView modelo = new ModelAndView("/jsp/usuario/usuariosView");
			return modelo;
		}
		
	}
	
	@SuppressWarnings("finally")
	@RequestMapping(value="/searchByDNI",method=RequestMethod.GET)
	public ModelAndView findAllUserDNI(Model model,@RequestParam("dni") int dni, HttpServletRequest request){
		
		HttpSession session = request.getSession();
		Usuario usuario = (Usuario) session.getAttribute("usuarioSession");
		
		try {
	
			if(usuario.getRol().equals("ROLE_ADMIN")){
				Usuario usuarioDni = usuarioService.findByDNI(dni);
				System.out.println("USUARIOS_DNI: " + usuarioDni);
				ModelAndView modelo = new ModelAndView("/jsp/usuario/usuariosView", "usuarioDNI", usuarioDni);
				return modelo;
			}else if (usuario.getRol().equals("ROLE_PROFESIONAL")) {
				Usuario paciente = usuarioService.findByDNIPacientes(dni);
				System.out.println("USUARIOS_DNI: " + paciente);
				ModelAndView modelo = new ModelAndView("/jsp/usuario/usuariosView", "usuarioDNI", paciente);
				return modelo;
			}else{
				ModelAndView modelo = new ModelAndView("/jsp/usuario/usuariosView", "msj", "No se encontraron Resultados");
				return modelo;
			}
		} catch (Exception e) {
			System.out.println("SearchDNI: "+ e.getMessage());
			ModelAndView modelo = new ModelAndView("/jsp/usuario/usuariosView", "msj", "No se encontraron Resultados");
			return modelo;
		}
		
		
		
		
	}
	
	@RequestMapping(value="/json/search",produces="application/json")
	public Map<String, Object> findAllUsers(Model model,@RequestParam("term") String apellido){
		Map<String, Object> map = new HashMap<String, Object>();
		List<Usuario> usuarios = usuarioService.findAllByName(apellido);
		model.addAttribute("usuarios",usuarios);
		
		for (int i = 0; i < usuarios.size(); i++) {
			Usuario us = usuarios.get(i);
			map.put("id_usuario",us.getId_usuario());
			map.put("Apellido",us.getApellido1());
		}
		
		return map;
		
	}
	
	
	
}
