package controlador;

import vista.Vista;

public class Main {

	public static void main(String[] args) {
		
		//crear la vista	
		Vista vista = new Vista();
		//crear el controlador del Boton, y comunicar el controlador con la vista
		ControladorActionListener controlador = new ControladorActionListener(vista);
		//llamamos al metodo de los listeners
		vista.establecerListeners(controlador);
		

	}
	
}
