package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import vista.VistaPrincipal;
import vista.VistaAdd;

public class ControladorActionListener implements ActionListener{
	
	//referencia a la vista creando una variable
	 VistaPrincipal vista;
	 VistaAdd vistaAdd;

	//Inicializar la variable en el constructor
	 
	public ControladorActionListener(VistaPrincipal vista) {
		this.vista = vista;
		
	}

	@Override
    public void actionPerformed(ActionEvent e) {
		//Aqui ponemos todo lo que hace click cuando le damos a los botones	
        
		//Al pulsar boton añadir de la principal, abre secundaria y llama a los liseners de VistaAdd
		if (e.getSource() == vista.getBotonAdd()) {
            vistaAdd = new VistaAdd(this);
            //Llamo a los listeners de VistaAdd
            vistaAdd.establecerListeners(this);
            vistaAdd.getCampoNombre().requestFocus();
        }
		//Al pulsar boton OK 
		else if (e.getSource() == vistaAdd.getBotonOk()) {
            addDatosTabla();
            vistaAdd.setVisible(false);
        } 
		else if (e.getSource() == vistaAdd.getBotonCancel()) {
            vistaAdd.setVisible(false);
            vistaAdd.dispose();
        } 
		else if (e.getSource() == vista.getBotonEdit()) {
            // Aquí debes implementar la lógica para editar contactos
        } 
		else if (e.getSource() == vista.getBotonDelete()) {
            // Aquí debes implementar la lógica para eliminar contactos
        }
    }
			
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
			
		

	//metodo para añadir los datos de los campos nombre y telefono a la tabla
	public void addDatosTabla() {
    	String nombre = vistaAdd.getCampoNombre().getText();
    	String telefono = vistaAdd.getCampoTelefono().getText();
    	DefaultTableModel tableModel = vista.getTableModel();
        tableModel.addRow(new String[]{nombre, telefono});
    }
	 
	 
	 
}
