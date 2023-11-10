package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import vista.Vista;

public class Controlador implements ActionListener{
	Vista vista;
	
	public Controlador(Vista vista) {
		this.vista = vista;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(vista.getNombreAlumno().getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Nombre Alumno vacío","Aviso",JOptionPane.INFORMATION_MESSAGE);
		}else if(!vista.getCheckMatriculado().isSelected()) {
			JOptionPane.showMessageDialog(null, "Alumno no matriculado","Aviso",JOptionPane.INFORMATION_MESSAGE);
		}else {
			String convalidado = "No";
			if(vista.getCheckConvalidado().isSelected()) {
				convalidado = "Sí";
			}
			vista.getTableModel().addRow(new String[]{vista.getNombreAlumno().getText(),convalidado} );
		}
		
		vista.getNombreAlumno().setText(null);
		vista.getNombreAlumno().requestFocus();
		vista.getCheckConvalidado().setSelected(false);		
		
	}

}
