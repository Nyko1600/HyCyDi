package com.sistema.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.digitalpersona.onetouch.DPFPSample;
import com.digitalpersona.onetouch.DPFPSampleFactory;
import com.digitalpersona.onetouch.DPFPTemplate;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.sistema.pojo.Huella;
import com.sistema.pojo.Usuario;
import com.sistema.service.HuellaService;
import com.sistema.service.UsuarioService;
import com.sistema.util.Util;
import com.sistema.dao.HuellaDAO;
import com.sistema.dao.UsuarioDAO;


@RestController
@RequestMapping("/rest")
public class ClientRestController {

	@Autowired
	UsuarioService usuarioService;
	
	@Autowired
	HuellaService huellaService;
	
	@Autowired
	public HuellaDAO huellaDao;
	
		
	@RequestMapping(value = "/mensaje", method = RequestMethod.GET,headers = "Accept=application/json")
	public @ResponseBody String showIndex(){
		return "mensaje de index";
	}
	

	// TODO - Buscar Usuario por DNI.
	@RequestMapping(value = "/usuario/buscar/{dni}", method = RequestMethod.GET,headers = "Accept=application/json")
	public String showUsuarios(@PathVariable("dni") int dni ){
		
		
		try {
			
			Usuario user = usuarioService.findByDNI(dni);
			
			if (user == null) {
				return null;
			}
	
			//System.out.println("USUARIO: " + user.toString());
			//Elimina la Recursividad en en json: @jsonIngnore no funciona.
			user.setDomicilio(null);
			user.setHistoria(null);
			
			String json = new Gson().toJson(user);
			//System.err.println("JSON: " + json);
			return json;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
		// TODO - Buscar Usuario por DNI, Nombre, Apellidos.
		@RequestMapping(value = "/usuario/search/{cadena}", method = RequestMethod.GET,headers = "Accept=application/json")
		public String showUsuarioName(@PathVariable("cadena") String cadena ){
			
			
			try {
				
				List<Usuario> user = usuarioService.findAllByName(cadena);
				List<Usuario> UsuarioList = new ArrayList<Usuario>();
				//Util util = Util.getInstance();
				if (user == null) {
					return null;
				}
		
				for (Usuario usuario : user) {
					usuario.setHistoria(null);
					usuario.setDomicilio(null);
					
					UsuarioList.add(usuario);
				}
				
				String json = new Gson().toJson(UsuarioList);
				json = Util.getInstance().hardCodeCaracteres(json);
				return json;

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
		}
	
	//TODO - Listar todos los Usuarios.
	@RequestMapping(value = "/usuarios/listar", method = RequestMethod.GET,headers = "Accept=application/json")
	public String showUsuariosListar(){
		
		
		try {
			List<Usuario> user_list = usuarioService.findAll();
			List<Usuario> UsuarioList = new ArrayList<Usuario>();
			
			//Elimina la Recursividad en en json: @jsonIngnore no funciona.
			for (Usuario usuario : user_list) {
				usuario.setHistoria(null);
				usuario.setDomicilio(null);
				
				UsuarioList.add(usuario);
			}
					
			String json = new Gson().toJson(UsuarioList);
			json = Util.getInstance().hardCodeCaracteres(json);
			return json;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}	
		
	}
	
	//TODO - Guardar Huella Capturada.
	@RequestMapping(value = "/huella/save", method = RequestMethod.POST)//,consumes = "application/json")
    public void saveHuella(HttpServletRequest request) {

		try {
			Huella huella = new Huella();
			
			//Parametros POST
			String id = request.getParameter("id").toString();
			String finger = request.getParameter("finger").toString();			
			String data = request.getParameter("data").toString();
			
			//Convierte Byte[] to String. Split de la cadena.
			String[] byteValues = data.substring(1, data.length() - 1).split(",");
			
			byte[] bytes = new byte[byteValues.length];

			for (int i=0, len=bytes.length; i<len; i++) {
			   bytes[i] = Byte.parseByte(byteValues[i].trim());     
			}
			
			huella.setId_usuario(Integer.parseInt(id));
			huella.setDedo(finger);
			huella.setHuella(bytes);
			

			huellaService.saveOrUpdate(huella);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
    }
	
	//TODO - Identificar Huella.
	@RequestMapping(value = "/huella/identificar", method = RequestMethod.POST,headers = "Accept=application/json")
    public String identificarHuella(HttpServletRequest request) {

		
		try {
			Huella huella = new Huella();
			
			String r = request.getParameter("data").toString();
					
			String[] byteValues = r.substring(1, r.length() - 1).split(",");
			
			byte[] bytes = new byte[byteValues.length];

			for (int i=0, len=bytes.length; i<len; i++) {
			   bytes[i] = Byte.parseByte(byteValues[i].trim());     
			}
			
			huella.setHuella(bytes);
			
			Usuario usuario = huellaService.findByHuella(huella);
			ObjectMapper mapper = new ObjectMapper();
			String json = Util.getInstance().hardCodeCaracteres(mapper.writeValueAsString(usuario));
			return json;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
			e.printStackTrace();
			return null;
		}
		
    }
	
	
}