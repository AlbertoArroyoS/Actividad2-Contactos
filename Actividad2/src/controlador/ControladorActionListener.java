package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import vista.Vista;

public class ControladorActionListener implements ActionListener{
	
	//referencia a la vista creando una variable
	 Vista vista;
	 
	//Inicializar la variable en el constructor
	 
	public ControladorActionListener(Vista vista) {
		this.vista = vista;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//Aqui ponemos todo lo que hace click cuando le damos a los botones
		//como tenemos 3 botones
		if (e.getSource() == vista.getBotonAdd()) {
			//lo que hace al darle al boton añadir
			
			//Comprobamos que la caja no esta vacia
			//if(vista.getNombre(.getText().isEmpty())
					//mensaje de error si no ponemos nombre
				//	JOptionPane.showMessageDialog(null,"Nombre esta vacion", "Aviso", JOptionPane.INFORMATION_MESSAGE);
		
			//añadir a la agenda
		//	vista.getTableModel().addRow(new String[] {vista.getNombre().getText(), telefono});
			
			//restablecer la caja de texto
		//	vista.getNombre().setText(null);
			//restablecer telefono
			
			//poner el foco
		//	vista.getNombre().requestFocus();
			
		
		}
		if (e.getSource() == vista.getBotonEdit()) {
			//lo que hace al darle al boton editar
					
		}
		if (e.getSource() == vista.getBotonDelete()) {
			//lo que hace al darle al boton eliminar
			
		}
		
	}
	 
	 
	 
}
