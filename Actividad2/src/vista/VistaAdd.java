package vista;

import java.awt.HeadlessException;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controlador.ControladorActionListener;

public class VistaAdd extends JFrame{
	
	private JLabel nombre;
	private JLabel telefono;
	private JButton botonOk;
	private JButton botonCancel;
	
	public VistaAdd() throws HeadlessException {
		//crear la ventana y establecerla
		setBounds(100,100,400,400);
		//establecer lo que hace el boton cerrar X
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//decimos que no vamos a utilizar layout, lo posicionamos nosotros
		setLayout(null);
		//que no se pueda redimensionar por el usuario
		setResizable(false);
		//Nombre ventana
		setTitle("Añadir Contacto");
		//icono de la ventana
		setIconImage(Toolkit.getDefaultToolkit().getImage("img/icono16.png"));
		//funcion para inicializar las variables
		initVariables();
		//hacer visible la ventana (tiene que ser la ultima opcion del constructor)
		setVisible(true);
	}
	
	//metodo para inicializar variables
		private void initVariables() {
			//crear el componente
			nombre = new JLabel();
			//colocarlo en la ventana
			nombre.setBounds(50, 5, 128, 128);
			//añadir el icono al panel
			add(nombre);
			
			//crear el componente
			telefono = new JLabel();
			//colocarlo en la ventana
			telefono.setBounds(50, 33, 128, 128);
			//añadir el icono al panel
			add(telefono);
			
			//botones
			botonOk = new JButton("Añadir contacto");
			botonOk.setBounds(200, 550, 150, 30);
			add(botonOk);
		
			botonCancel = new JButton("Editar");
			botonCancel.setBounds(500, 350, 100, 30);
			add(botonCancel);
				
		}
		
		public void establecerListeners(ControladorActionListener controlador) {
			
			botonOk.addActionListener(controlador);
			botonCancel.addActionListener(controlador);
	
		}
	
	

}
