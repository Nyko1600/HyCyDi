package com.sistema.util;

public class Util {

	private static final Util INSTANCE = new Util();

    // El constructor privado no permite que se genere un constructor por defecto.
    // (con mismo modificador de acceso que la definición de la clase) 
    private Util() {}

    public static Util getInstance() {
        return INSTANCE;
    }
	
	//Cambiamos Caracteres para POST/GET
    public String hardCodeCaracteres( String valor){
        valor=valor.replace("á","a");valor=valor.replace("Á","a");  
        valor=valor.replace("é","e");valor=valor.replace("É", "e");
        valor=valor.replace("í","i");valor=valor.replace("Í","i");
        valor=valor.replace("ó","o");valor=valor.replace("Ó","o");
        valor=valor.replace("ú","u");valor=valor.replace("Ú","u");
        valor=valor.replace( "ñ", "n");valor=valor.replace( "Ñ", "n");

        return valor;
    }
}
