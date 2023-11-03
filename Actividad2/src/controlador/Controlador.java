package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vista.Vista;

public class Controlador implements ActionListener{
	
	//referencia a la vista creando una variable
	 Vista vista;
	 
	//Inicializar la variable en el constructor
	 
	public Controlador(Vista vista) {
		this.vista = vista;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	 
	 
	 
}
