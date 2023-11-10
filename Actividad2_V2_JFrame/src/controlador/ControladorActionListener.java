package controlador;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import vista.VistaPrincipal;
import vista.VistaSecundaria;


public class ControladorActionListener implements ActionListener{
	
	//referencia a la vista creando una variable
	 private VistaPrincipal vistaPrincipal;
	 private VistaSecundaria vistaSecundaria;

	 
	//Inicializar la variable en el constructor
	 
	public ControladorActionListener(VistaPrincipal vista) {
		this.vistaPrincipal = vista;
		
	}

	@Override
    public void actionPerformed(ActionEvent e) {
		//Aqui ponemos todo lo que hace click cuando le damos a los botones	
        
		//Al pulsar boton añadir de la principal, abre secundaria y llama a los liseners de VistaAdd
		if (e.getSource() == vistaPrincipal.getBotonAdd()) {
			if(vistaSecundaria==null) {
				vistaSecundaria = new VistaSecundaria(this);
				vistaSecundaria.setTitle("Añadir contacto");
				
			}else {
				vistaSecundaria.setTitle("Añadir contacto");
				vistaSecundaria.setVisible(true);
			}
			
			//vistaAdd.setVisible(true);
            //Llamo a los listeners de VistaAdd
           // vistaAdd.getCampoNombre().requestFocus();
        }
		
		//Al pulsar boton OK de añadir contacto, añade nombre y telefono a la tabla
		//else if (vistaAdd != null && e.getSource() == vistaAdd.getBotonOk()) {
		if (e.getSource() == vistaSecundaria.getBotonOk()) {
			
			if("Añadir contacto".equals(vistaSecundaria.getTitle())) {
				addDatosTabla();
				resetCampos();
		          //  vistaAdd.setVisible(false);
		        vistaSecundaria.dispose();
			}if("Editar contacto".equals(vistaSecundaria.getTitle())) {
				editDatosTabla();
				resetCampos();
				vistaSecundaria.dispose();
			}         
        }
		
		//Al pulsar cancelar de añadir contacto cierra y queda la principal
		//else if (vistaAdd != null && e.getSource() == vistaAdd.getBotonCancel()) {
		if (e.getSource() == vistaSecundaria.getBotonCancel()) {
            vistaSecundaria.dispose();

        }
		
		//Al pulsar el boton editar de la tabla principal
		if (e.getSource() == vistaPrincipal.getBotonEdit()) {
			
            //vistaEditar.getCampoNombre().requestFocus();
            int selectedRow = vistaPrincipal.obtenerFilaSeleccionada();
            
    		if (selectedRow >= 0) {
    			if(vistaSecundaria==null) {
    				vistaSecundaria = new VistaSecundaria(this);
    			}else {
    				vistaSecundaria.setVisible(true);
    			}
    			vistaSecundaria.setTitle("Editar contacto");
    			ponerDatosTabla();
    				
    		}else {
    			JOptionPane.showMessageDialog(null,"Tiene que seleccionar una fila", "Aviso", JOptionPane.INFORMATION_MESSAGE);	
    		}
                
        }
		//Al pulsar el boton borrar de la tabla principal
		if (e.getSource() == vistaPrincipal.getBotonDelete()) {
		        vistaPrincipal.establecerListeners(this);
		        eliminarContacto();
		}
		
    }
			

	//metodo para añadir los datos de los campos nombre y telefono a la tabla
	public void addDatosTabla() {
	    String nombre = vistaSecundaria.getCampoNombre().getText();
	    String telefono = vistaSecundaria.getCampoTelefono().getText();
	    if(nombre.isEmpty()){
	        JOptionPane.showMessageDialog(null,"Nombre está vacío", "Aviso", JOptionPane.INFORMATION_MESSAGE);
	        if (vistaSecundaria.isVisible()) {
	            vistaSecundaria.dispose(); // Cierra la ventana si está visible
	        }
	        vistaSecundaria = null; // Reinicializa la instancia de VistaAdd
	    } else if(telefono.isEmpty()){
	        JOptionPane.showMessageDialog(null,"Teléfono está vacío", "Aviso", JOptionPane.INFORMATION_MESSAGE);
	        if (vistaSecundaria.isVisible()) {
	            vistaSecundaria.dispose(); // Cierra la ventana si está visible
	        }
	        vistaSecundaria = null; // Reinicializa la instancia de VistaAdd
	    } else {
	        DefaultTableModel tableModel = vistaPrincipal.getTableModel();
	        tableModel.addRow(new String[]{nombre, telefono});
	       // resetCampos();
	    }
	}
	
	public void ponerDatosTabla() {
		int selectedRow = vistaPrincipal.obtenerFilaSeleccionada();

		if (selectedRow >= 0) {
		    // Seleccionar la fila se encuentra en 'selectedRow'
		    // Puedes acceder a los datos de esa fila a través del modelo de tabla
		    String nombre = vistaPrincipal.getTableModel().getValueAt(selectedRow, 0).toString();
		    String telefono = vistaPrincipal.getTableModel().getValueAt(selectedRow, 1).toString();

	        // Asignar los valores a los campos de edición en vistaEditar
		    
	        vistaSecundaria.getCampoNombre().setText(nombre);
	        vistaSecundaria.getCampoTelefono().setText(telefono);
		}
		
	}
	public void editDatosTabla() {
		
		int filaSeleccionada = vistaPrincipal.obtenerFilaSeleccionada();

		if (filaSeleccionada >= 0) {
		   
	       // Asignar los valores a los campos de edición en vistaEditar
	        //Añadir los valores editados
	        String nombreEditado = vistaSecundaria.getCampoNombre().getText();
	    	String telefonoEditado = vistaSecundaria.getCampoTelefono().getText();
	    	if(nombreEditado.isEmpty()){
	    		JOptionPane.showMessageDialog(null,"Nombre esta vacio", "Aviso", JOptionPane.INFORMATION_MESSAGE);
	    	}else if(telefonoEditado.isEmpty()){
	    		JOptionPane.showMessageDialog(null,"Telefono esta vacio", "Aviso", JOptionPane.INFORMATION_MESSAGE);
	    	}else {
	    		DefaultTableModel tableModel = vistaPrincipal.getTableModel();
	    		tableModel = vistaPrincipal.getTableModel();
	    		tableModel.setValueAt(nombreEditado, filaSeleccionada, 0);
	    	    tableModel.setValueAt(telefonoEditado, filaSeleccionada, 1);
	    		
	    	}  
	        
        } else {
            // Mostrar un mensaje al usuario indicando que no hay fila seleccionada.
            JOptionPane.showMessageDialog(vistaPrincipal, "Selecciona un contacto para editar.", "Sin selección", JOptionPane.INFORMATION_MESSAGE);
        }

	}
	public void eliminarContacto() {
		int filaSeleccionada = vistaPrincipal.obtenerFilaSeleccionada();

		if (filaSeleccionada >= 0) {
			DefaultTableModel tableModel = vistaPrincipal.getTableModel();
			tableModel.removeRow(filaSeleccionada);
		}
		else {
            // Mostrar un mensaje al usuario indicando que no hay fila seleccionada.
            JOptionPane.showMessageDialog(vistaPrincipal, "Selecciona un contacto para editar.", "Sin selección", JOptionPane.INFORMATION_MESSAGE);
        }
		
	}
	public void resetCampos() {
		vistaSecundaria.getCampoNombre().setText(null);
        vistaSecundaria.getCampoTelefono().setText(null);
	}
	 
	 
 
}
