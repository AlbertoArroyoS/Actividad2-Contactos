package controlador;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import vista.VistaPrincipal;
import vista.VistaSecundaria;

public class ControladorMouseListener implements MouseListener{

	//referencia a la vista creando una variable
	 private VistaPrincipal vistaPrincipal;
	 private VistaSecundaria vistaSecundaria;
	 
	 String sonidoBoton="audio/no-sonido.wav";
	
	
	 public ControladorMouseListener (VistaPrincipal vista) {
		 this.vistaPrincipal = vista;
	 }
	 
	@Override
	public void mouseClicked(MouseEvent e) {
			
			
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
		if (e.getSource() == vistaPrincipal.getBotonAdd()) {
			vistaPrincipal.getBotonAdd().setBackground(Color.BLUE);
		}
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
//reproducir sonidos con la clase clip
    
    /**
     * Metodo para reproducir un sonido a partir de un archivo de audio wav.
     * 
     * @param ruta representa la ruta del archivo de sonido.
     */
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
