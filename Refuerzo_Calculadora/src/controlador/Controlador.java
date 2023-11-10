package controlador;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import vista.VistaPrincipal;



public class Controlador implements ActionListener{
	VistaPrincipal vista;
	
	public Controlador(VistaPrincipal vista) {
		this.vista = vista;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == vista.getBotonSumar()) {
			double numero1 = Double.parseDouble(vista.getCajaNumero1().getText());
            //Double.valueOf(strNumero);
			double numero2 = Double.parseDouble(vista.getCajaNumero2().getText());
			
			
        }
		
		if (e.getSource() == vista.getBotonRaiz3()) {
			JOptionPane.showMessageDialog(null,"Funcionalidad no disponible", "Aviso", JOptionPane.INFORMATION_MESSAGE);
        }
		
		
		
		
	}

}
