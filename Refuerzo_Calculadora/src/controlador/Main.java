package controlador;


import vista.VistaPrincipal;

public class Main {

	public static void main(String[] args) {
		VistaPrincipal vista = new VistaPrincipal();
		Controlador controlador = new Controlador(vista);
		vista.establecerManejador(controlador);
		
	}

}


