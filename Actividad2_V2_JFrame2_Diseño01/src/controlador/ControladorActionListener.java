package controlador;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

import vista.VistaPrincipal;
import vista.VistaSecundaria;


public class ControladorActionListener implements ActionListener{
	
	//referencia a la vista creando una variable
	 private VistaPrincipal vistaPrincipal;
	 private VistaSecundaria vistaSecundaria;
	 
	 String sonidoBoton="audio/mouse-click.wav";
	 String sonidoAlert="audio/windows-error.wav";

	 
	//Inicializar la variable en el constructor
	 
	public ControladorActionListener(VistaPrincipal vista) {
		this.vistaPrincipal = vista;
		
	}

	@Override
    public void actionPerformed(ActionEvent e) {
		//Aqui ponemos todo lo que hace click cuando le damos a los botones	
        
		//Al pulsar boton añadir de la principal, abre secundaria y llama a los liseners de VistaAdd
		if (e.getSource() == vistaPrincipal.getBotonAdd()) {
			reproducirSonido(sonidoBoton);
			if(vistaSecundaria==null) {
				vistaSecundaria = new VistaSecundaria(this);
				vistaSecundaria.setTitle("Añadir contacto");
				vistaSecundaria.setIconImage(Toolkit.getDefaultToolkit().getImage("img/añadir32.png"));
				
			}else {
				resetCampos();
				vistaSecundaria.setTitle("Añadir contacto");
				vistaSecundaria.setIconImage(Toolkit.getDefaultToolkit().getImage("img/añadir32.png"));
				vistaSecundaria.setVisible(true);
			}
			
			//vistaAdd.setVisible(true);

           // vistaAdd.getCampoNombre().requestFocus();
        }
		
		//Al pulsar boton OK de añadir contacto, añade nombre y telefono a la tabla
		if (vistaSecundaria != null && e.getSource() == vistaSecundaria.getBotonOk()) {
			reproducirSonido(sonidoBoton);
			
	        if ("Añadir contacto".equals(vistaSecundaria.getTitle())) {
	    	    addDatosTabla();
	        	            
	    	  //  vistaSecundaria.dispose();
	        } else if ("Editar contacto".equals(vistaSecundaria.getTitle())) {
	            editDatosTabla();
	            
	        }
	    }
		
		//Al pulsar cancelar de añadir contacto cierra y queda la principal
		
		if (vistaSecundaria != null && e.getSource() == vistaSecundaria.getBotonCancel()) {
			if(vistaSecundaria==null) {
				vistaSecundaria = new VistaSecundaria(this);
				
			}
			reproducirSonido(sonidoBoton);
            vistaSecundaria.dispose();
        }
		
		//Al pulsar el boton editar de la tabla principal
		if (e.getSource() == vistaPrincipal.getBotonEdit()) {
			reproducirSonido(sonidoBoton);
            //vistaEditar.getCampoNombre().requestFocus();
            int selectedRow = vistaPrincipal.obtenerFilaSeleccionada();
            
    		if (selectedRow >= 0) {
    			if(vistaSecundaria==null) {
    				vistaSecundaria = new VistaSecundaria(this);
    			}else {
    				vistaSecundaria.setVisible(true);
    			}
    			vistaSecundaria.setTitle("Editar contacto");
    			vistaSecundaria.setIconImage(Toolkit.getDefaultToolkit().getImage("img/editar32.png"));
    			ponerDatosTabla();
    				
    		}else {
    			reproducirSonido(sonidoAlert);
    			JOptionPane.showMessageDialog(vistaPrincipal, "Tiene que seleccionar una fila.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
    			//JOptionPane.showMessageDialog(null,"Tiene que seleccionar una fila", "Aviso", JOptionPane.INFORMATION_MESSAGE);	
    		}
                
        }
		//Al pulsar el boton borrar de la tabla principal
		if (e.getSource() == vistaPrincipal.getBotonDelete()) {
			reproducirSonido(sonidoBoton);
		    eliminarContacto();
		}
		
		// Al pulsar un botón para guardar la tabla en un archivo
	    if (e.getSource() == vistaPrincipal.getBotonGuardar()) {
	    	reproducirSonido(sonidoBoton);
	        guardarTablaEnArchivo();
	    }
	    
	    // Al pulsar un botón para cargar datos desde un archivo
	    if (e.getSource() == vistaPrincipal.getBotonCargar()) {
	    	reproducirSonido(sonidoBoton);
	        cargarDatosDesdeArchivo();
	    }
	    if (e.getSource() == vistaPrincipal.getBotonSonido()) {
	    	reproducirSonido(sonidoBoton);
	    	
	    	sonidoBoton ="audio/mouse-click.wav";
	   	 	sonidoAlert="audio/windows-error.wav";
	    }
	    if (e.getSource() == vistaPrincipal.getBotonNoSonido()) {	
	    	sonidoBoton ="audio/no-sonido.wav";
	   	 	sonidoAlert="audio/no-sonido.wav";
	    }

		
    }
			
	//metodo para añadir los datos de los campos nombre y telefono a la tabla
	
	public void addDatosTabla() {
		String nombre = vistaSecundaria.getCampoNombre().getText();
	    String telefono = vistaSecundaria.getCampoTelefono().getText();
	    if (nombre.isEmpty()) {
	    	reproducirSonido(sonidoAlert);
		       JOptionPane.showOptionDialog(null,
		               "Nombre está vacío",
		               "Aviso",
		               JOptionPane.DEFAULT_OPTION,
		               JOptionPane.WARNING_MESSAGE,
		               null,
		               new Object[]{"Aceptar"},  // Añadimos un botón "Aceptar"
		               "Aceptar");
		       
		       
		 } else if (telefono.isEmpty()) {
			 reproducirSonido(sonidoAlert);
		     //   JOptionPane.showMessageDialog(null, "Teléfono está vacío", "Aviso", JOptionPane.INFORMATION_MESSAGE);
		        JOptionPane.showOptionDialog(null,
			               "Teléfono está vacío",
			               "Aviso",
			               JOptionPane.DEFAULT_OPTION,
			               JOptionPane.WARNING_MESSAGE,
			               null,
			               new Object[]{"Aceptar"},  // Añadimos un botón "Aceptar"
			               "Aceptar");
		 }else if(telefono.length()<9){
			 reproducirSonido(sonidoAlert);
			 JOptionPane.showOptionDialog(null,
		               "El teléfono debe tener 9 digitos",
		               "Aviso",
		               JOptionPane.DEFAULT_OPTION,
		               JOptionPane.WARNING_MESSAGE,
		               null,
		               new Object[]{"Aceptar"},  // Añadimos un botón "Aceptar"
		               "Aceptar");
			 
		 }else {
		    	 DefaultTableModel tableModel = vistaPrincipal.getTableModel();
		    	 tableModel.addRow(new String[]{nombre, telefono});
		    	 vistaSecundaria.dispose();
		    	 resetCampos();
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
	    		reproducirSonido(sonidoAlert);
	    		JOptionPane.showMessageDialog(null,"Nombre esta vacio", "Aviso", JOptionPane.INFORMATION_MESSAGE);
	    	}else if(telefonoEditado.isEmpty()){
	    		reproducirSonido(sonidoAlert);
	    		JOptionPane.showMessageDialog(null,"Telefono esta vacio", "Aviso", JOptionPane.INFORMATION_MESSAGE);
	    	}else if(telefonoEditado.length()<9){
	    		reproducirSonido(sonidoAlert);
				 JOptionPane.showOptionDialog(null,
			               "El teléfono debe tener 9 digitos",
			               "Aviso",
			               JOptionPane.DEFAULT_OPTION,
			               JOptionPane.WARNING_MESSAGE,
			               null,
			               new Object[]{"Aceptar"},  // Añadimos un botón "Aceptar"
			               "Aceptar");
				 
			 }else {
	    		DefaultTableModel tableModel = vistaPrincipal.getTableModel();
	    		tableModel = vistaPrincipal.getTableModel();
	    		tableModel.setValueAt(nombreEditado, filaSeleccionada, 0);
	    	    tableModel.setValueAt(telefonoEditado, filaSeleccionada, 1);
	    	    resetCampos();
	            vistaSecundaria.dispose();
	    		
	    	}  
	        
        } else {
        	reproducirSonido(sonidoAlert);
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
			reproducirSonido(sonidoAlert);
            JOptionPane.showMessageDialog(vistaPrincipal, "Selecciona un contacto para eliminar.", "Sin selección", JOptionPane.INFORMATION_MESSAGE);
        }
		
	}
	public void resetCampos() {
		vistaSecundaria.getCampoNombre().setText(null);
        vistaSecundaria.getCampoTelefono().setText(null); 
		 
	}
	
    // Método para guardar la tabla en un archivo
    private void guardarTablaEnArchivo() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Guardar Tabla");
        fileChooser.setFileFilter(new FileNameExtensionFilter("Archivos de texto (*.txt)", "txt"));
        DefaultTableModel tableModel = vistaPrincipal.getTableModel();
        int seleccion = fileChooser.showSaveDialog(vistaPrincipal);

        if (seleccion == JFileChooser.APPROVE_OPTION) {
            File archivo = fileChooser.getSelectedFile();

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo))) {
                // Escribir las columnas
                for (int i = 0; i < tableModel.getColumnCount(); i++) {
                    writer.write(tableModel.getColumnName(i) + "\t");
                }
                writer.newLine();

                // Escribir los datos de la tabla
                for (int i = 0; i < tableModel.getRowCount(); i++) {
                    for (int j = 0; j < tableModel.getColumnCount(); j++) {
                        writer.write(tableModel.getValueAt(i, j).toString() + "\t");
                    }
                    writer.newLine();
                }

                writer.flush();
                JOptionPane.showMessageDialog(null, "Tabla guardada correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException e) {
                e.printStackTrace();
                reproducirSonido(sonidoAlert);
                JOptionPane.showMessageDialog(null, "Error al guardar la tabla", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    // Método para cargar datos desde un archivo
    private void cargarDatosDesdeArchivo() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Cargar Datos desde Archivo");
        fileChooser.setFileFilter(new FileNameExtensionFilter("Archivos de texto (*.txt)", "txt"));
        DefaultTableModel tableModel = vistaPrincipal.getTableModel();
        int seleccion = fileChooser.showOpenDialog(vistaPrincipal);

        if (seleccion == JFileChooser.APPROVE_OPTION) {
            File archivo = fileChooser.getSelectedFile();

            try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
                // Limpiar la tabla antes de cargar nuevos datos
                tableModel.setRowCount(0);

                // Leer la primera línea que contiene los nombres de las columnas
                String[] columnNames = reader.readLine().split("\t");
                tableModel.setColumnIdentifiers(columnNames);

                // Leer las líneas restantes que contienen los datos
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] rowData = line.split("\t");
                    tableModel.addRow(rowData);
                }

                JOptionPane.showMessageDialog(null, "Datos cargados correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException e) {
                e.printStackTrace();
                reproducirSonido(sonidoAlert);
                JOptionPane.showMessageDialog(null, "Error al cargar datos desde el archivo", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    //reproducir sonidos con la clase clip
    private void reproducirSonido(String ruta) {
        try {
            File file = new File(ruta);
            if (file.exists()) {
                Clip clip = AudioSystem.getClip();
                clip.open(AudioSystem.getAudioInputStream(file));
                clip.start();
            } else {
                System.out.println("El archivo de sonido no existe: " + ruta);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

	 	 
}
