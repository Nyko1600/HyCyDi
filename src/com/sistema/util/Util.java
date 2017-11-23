package com.sistema.util;

public class Util {

	private static final Util INSTANCE = new Util();

    // El constructor privado no permite que se genere un constructor por defecto.
    // (con mismo modificador de acceso que la definici�n de la clase) 
    private Util() {}

    public static Util getInstance() {
        return INSTANCE;
    }
	
	//Cambiamos Caracteres para POST/GET
    public String hardCodeCaracteres( String valor){
        valor=valor.replace("�","a");valor=valor.replace("�","a");  
        valor=valor.replace("�","e");valor=valor.replace("�", "e");
        valor=valor.replace("�","i");valor=valor.replace("�","i");
        valor=valor.replace("�","o");valor=valor.replace("�","o");
        valor=valor.replace("�","u");valor=valor.replace("�","u");
        valor=valor.replace( "�", "n");valor=valor.replace( "�", "n");

        return valor;
    }
}
