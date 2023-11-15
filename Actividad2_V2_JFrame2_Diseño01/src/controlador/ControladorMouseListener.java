package controlador;

import java.awt.Color;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import com.formdev.flatlaf.extras.FlatSVGIcon;

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
			vistaPrincipal.getBotonAdd().setBackground(Color.LIGHT_GRAY);
		}
		if (e.getSource() == vistaPrincipal.getBotonEdit()) {
			vistaPrincipal.getBotonEdit().setBackground(Color.LIGHT_GRAY);
		}
		if (e.getSource() == vistaPrincipal.getBotonDelete()) {
			vistaPrincipal.getBotonDelete().setBackground(Color.LIGHT_GRAY);
		}
		if (e.getSource() == vistaPrincipal.getBotonGuardar()) {
			vistaPrincipal.getBotonGuardar().setBackground(Color.LIGHT_GRAY);
		}
		if (e.getSource() == vistaPrincipal.getBotonCargar()) {
			vistaPrincipal.getBotonCargar().setBackground(Color.LIGHT_GRAY);
		}
		if (e.getSource() == vistaPrincipal.getBotonSonido()) {
			FlatSVGIcon svgIconoSonido = new FlatSVGIcon("main/svg/sound2.svg",30, 30);
			vistaPrincipal.getBotonSonido().setIcon(svgIconoSonido);
			vistaPrincipal.getBotonSonido().setContentAreaFilled(true);
		}
		if (e.getSource() == vistaPrincipal.getBotonNoSonido()) {
			FlatSVGIcon svgIconoNoSonido = new FlatSVGIcon("main/svg/mute2.svg",30, 30);
			vistaPrincipal.getBotonNoSonido().setIcon(svgIconoNoSonido);
			vistaPrincipal.getBotonNoSonido().setContentAreaFilled(true);
		}
		if (e.getSource() == vistaPrincipal.getBotonAZ()) {
			//vistaPrincipal.getBotonAZ().setSize(50, 50);
			FlatSVGIcon svgIconoAz = new FlatSVGIcon("main/svg/clasificar5.svg",30, 30);
			vistaPrincipal.getBotonAZ().setIcon(svgIconoAz);
			vistaPrincipal.getBotonAZ().setContentAreaFilled(true);
		}
		if (vistaSecundaria != null && e.getSource() == vistaSecundaria.getBotonOk()) {
			vistaSecundaria.getBotonOk().setBackground(Color.BLUE);
		}
		if (vistaSecundaria != null && e.getSource() == vistaSecundaria.getBotonCancel()) {
			vistaSecundaria.getBotonCancel().setBackground(Color.BLUE);
		}
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		if (e.getSource() == vistaPrincipal.getBotonAdd()) {
			vistaPrincipal.getBotonAdd().setBackground(Color.WHITE);
		}
		if (e.getSource() == vistaPrincipal.getBotonEdit()) {
			vistaPrincipal.getBotonEdit().setBackground(Color.WHITE);
		}
		if (e.getSource() == vistaPrincipal.getBotonDelete()) {
			vistaPrincipal.getBotonDelete().setBackground(Color.WHITE);
		}
		if (e.getSource() == vistaPrincipal.getBotonGuardar()) {
			vistaPrincipal.getBotonGuardar().setBackground(Color.WHITE);
		}
		if (e.getSource() == vistaPrincipal.getBotonCargar()) {
			vistaPrincipal.getBotonCargar().setBackground(Color.WHITE);
		}
		if (e.getSource() == vistaPrincipal.getBotonSonido()) {
			FlatSVGIcon svgIconoSonido = new FlatSVGIcon("main/svg/sound2-blanco.svg",30, 30);
			vistaPrincipal.getBotonSonido().setIcon(svgIconoSonido);
			vistaPrincipal.getBotonSonido().setContentAreaFilled(false);
		}
		if (e.getSource() == vistaPrincipal.getBotonNoSonido()) {
			FlatSVGIcon svgIconoNoSonido = new FlatSVGIcon("main/svg/mute2-blanco.svg",30, 30);
			vistaPrincipal.getBotonNoSonido().setIcon(svgIconoNoSonido);
			vistaPrincipal.getBotonNoSonido().setContentAreaFilled(false);
		}
		if (e.getSource() == vistaPrincipal.getBotonAZ()) {
			//vistaPrincipal.getBotonAZ().setSize(30, 30);
			FlatSVGIcon svgIconoAz = new FlatSVGIcon("main/svg/clasificar5-blanco.svg",30, 30);
			vistaPrincipal.getBotonAZ().setIcon(svgIconoAz);
			vistaPrincipal.getBotonAZ().setContentAreaFilled(false);
		}
		if (vistaSecundaria != null && e.getSource() == vistaSecundaria.getBotonOk()) {
			vistaSecundaria.getBotonOk().setBackground(Color.WHITE);
		}
		if (vistaSecundaria != null && e.getSource() == vistaSecundaria.getBotonCancel()) {
			vistaSecundaria.getBotonCancel().setBackground(Color.WHITE);
		}
		
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
