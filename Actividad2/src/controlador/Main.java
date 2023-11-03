package controlador;

import vista.VistaPrincipal;


public class Main {

	public static void main(String[] args) {
		
		//crear la vista	
		VistaPrincipal vista = new VistaPrincipal();
		
		//crear el controlador del Boton, y comunicar el controlador con la vista
		ControladorActionListener controlador = new ControladorActionListener(vista);
		//llamamos al metodo de los listeners
		vista.establecerListeners(controlador);
		
		
		

	}
	
}
