package com.sistema.service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.text.html.HTMLDocument.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digitalpersona.onetouch.DPFPDataPurpose;
import com.digitalpersona.onetouch.DPFPFeatureSet;
import com.digitalpersona.onetouch.DPFPGlobal;
import com.digitalpersona.onetouch.DPFPSample;
import com.digitalpersona.onetouch.DPFPSampleFactory;
import com.digitalpersona.onetouch.DPFPTemplate;
import com.digitalpersona.onetouch.processing.DPFPFeatureExtraction;
import com.digitalpersona.onetouch.processing.DPFPImageQualityException;
import com.digitalpersona.onetouch.verification.DPFPVerification;
import com.digitalpersona.onetouch.verification.DPFPVerificationResult;
import com.sistema.dao.HuellaDAO;
import com.sistema.dao.UsuarioDAO;
import com.sistema.pojo.Huella;
import com.sistema.pojo.Usuario;

@Service
public class HuellaService {

	@Autowired
	public UsuarioDAO usuarioDao;
	
	@Autowired
	public HuellaDAO huellaDAO;
	
	//objeto de la librería para comparar Huellas.
	@Autowired(required=false)
	private DPFPVerification Verificador = DPFPGlobal.getVerificationFactory().createVerification();

	
	
	public void saveOrUpdate(Huella huella){
		
			if (huella.getId_huella() == 0) {
				
				huellaDAO.save(huella);
			}else{
				//usuarioDao.update(usuario);
			}
	}
	
	
	
	public Usuario findByHuella(Huella h){
		
		List<Huella> huellas = huellaDAO.findAll();
		
		//Huella a verificar desde el Lector.
		byte huellaVerify[] = h.getHuella();

		
		//Recorremos la Lista de Huellas y Comparamos las caracteristicas.
		try {
			for (Huella huellaList : huellas) {

				//Buffer donde se almacenan las Huellas desde BD.
			    byte listahuellas[] = huellaList.getHuella();
			    
			    System.out.println("DAO.HuellaDAO.IdentificarHuella() => " + listahuellas);
			    System.out.println("DAO.HuellaDAO.IdentificarHuella() => " + huellaVerify);
			    
			   
			    //Huella a verificar
			    DPFPFeatureSet features = DPFPGlobal.getFeatureSetFactory().createFeatureSet(huellaVerify);
			    
		        
			   // DPFPFeatureSet featuredVerificacion = extraerCaracteristicas(sample, DPFPDataPurpose.DATA_PURPOSE_VERIFICATION);
			    
			    DPFPTemplate referenceTemplate = DPFPGlobal.getTemplateFactory().createTemplate(listahuellas);
			    
			    //Se comparan las huellas Capturada con la de la BD.
			    DPFPVerificationResult result = Verificador.verify(features, referenceTemplate);
			    
			    if(result.isVerified()){
			    	
			        Usuario user = new Usuario();// = new Usuario();
			        user = usuarioDao.findById(huellaList.getId_usuario());
			        user.setDomicilio(null);
			        user.setHistoria(null);
			        return user;
			    }
			}
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	
}
