package controlador;

import vista.Vista;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Vista vista = new Vista();
		Controlador controlador = new Controlador(vista);
		vista.EstablecerManejador(controlador);
	}

}
