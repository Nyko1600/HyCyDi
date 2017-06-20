package com.sistema.controller;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.digitalpersona.onetouch.DPFPSample;
import com.digitalpersona.onetouch.DPFPSampleFactory;
import com.digitalpersona.onetouch.DPFPTemplate;
import com.google.gson.Gson;
import com.sistema.pojo.Huella;
import com.sistema.pojo.Usuario;
import com.sistema.service.HuellaService;
import com.sistema.service.UsuarioService;
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
	

	@RequestMapping(value = "/usuarios/buscar/{dni}", method = RequestMethod.GET,headers = "Accept=application/json")
	public String showUsuarios(@PathVariable("dni") int dni ){
		//@ResponseBody JSONObject
		
		Usuario user = usuarioService.findByDNI(dni);
		
		if (user == null) {
			return null;
		}

		//System.out.println("USUARIO: " + user.toString());
		//Elimina la Recursividad en en json: @jsonIngnore no funciona.
		//user.setDomicilio(null);
		//user.setHistoria(null);
		
		String gson = new Gson().toJson(user);
		return gson;
	}
	
	@RequestMapping(value = "/usuarios/listar", method = RequestMethod.GET,headers = "Accept=application/json")
	public String showUsuariosListar(){
		
		/*Map<String, Usuario>*/
		List<Usuario> user_list = usuarioService.findAll();
		List<Usuario> UsuarioList = new ArrayList<Usuario>();
		
		//Elimina la Recursividad en en json: @jsonIngnore no funciona.
		for (Usuario usuario : user_list) {
			usuario.setHistoria(null);
			usuario.setDomicilio(null);
			
			UsuarioList.add(usuario);
		}
				
		String json = new Gson().toJson(UsuarioList);
		
		return json;	
		
	}
	
	@RequestMapping(value = "/huella/save", method = RequestMethod.POST)//,consumes = "application/json")
    public void saveHuella(HttpServletRequest request) {

		
		try {
			Huella huella = new Huella();
			
			//Parametros POST
			String id = request.getParameter("id").toString();
			String finger = request.getParameter("finger").toString();			
			String data = request.getParameter("data").toString();
						
			
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
			
			
			huella.setId_usuario(2);
			huella.setDedo("Dedo prueba 2");
			huella.setHuella(bytes);
			
			Usuario usuario = huellaService.findByHuella(huella);
			ObjectMapper mapper = new ObjectMapper();
			String jsonInString = mapper.writeValueAsString(usuario);
			System.out.println(jsonInString);
			return jsonInString;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
    }
	
	
}