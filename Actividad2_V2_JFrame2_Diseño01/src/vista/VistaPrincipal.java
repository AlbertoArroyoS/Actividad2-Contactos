package vista;

import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import controlador.ControladorActionListener;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Image;
import java.io.IOException;

/**
 * Clase que representa la vista principal de la aplicacion de contactos.
 * Extiende JFrame y contiene elementos como botones, una tabla y otros componentes visuales.
 * Proporciona metodos para obtener informacion de la interfaz y establecer listeners al controlador.
 * 
 * @author Alberto Arroyo Santofimia
 * @see JFrame
 * @version v1.0
 */
public class VistaPrincipal extends JFrame{
	//Botones 
	private JButton botonAdd;
	private JButton botonEdit;
	private JButton botonDelete;
	private JButton botonGuardar;
	private JButton botonCargar;
	private JButton botonSonido, botonNoSonido;
	private JButton botonAZ;
	private JLabel icono, nombreApp;
	
	//DefaultTableModel(tabla |x|y|)  ->  JTable  -> ScrollPane
	
	//definir tabla JTable
	private JTable tablaContactos;
	//modelo tabla
	private DefaultTableModel tableModel;
	//contenedor con scroll
	private JScrollPane scrollPane;

	
	//Constructor para inicializar las variables
	
	 /**
	 * Constructor para inicializar las variables de la vista.
	 */
	public VistaPrincipal() {
		//crear la ventana y establecerla
		setBounds(100,100,515,390);
		//establecer lo que hace el boton cerrar X
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//decimos que no vamos a utilizar layout, lo posicionamos nosotros
		getContentPane().setLayout(null);
		//que no se pueda redimensionar por el usuario
		setResizable(false);
		//Nombre ventana
		setTitle("Mis contactos");
		//icono de la ventana
		setIconImage(Toolkit.getDefaultToolkit().getImage("img/contactos64-principal.png"));
		//funcion para inicializar las variables
		initVariables();
		//hacer visible la ventana (tiene que ser la ultima opcion del constructor)
		setVisible(true);
		
	}
	//metodo para inicializar variables
	/**
     * Metodo privado para inicializar las variables de la vista.
     */
	private void initVariables() {
		
		//Tabla
		
		//1º crear el modelo
		
		//crear array con el nombre de las columnas
		String[] nombreColumnas= {"Nombre", "Teléfono"};
		tableModel = new DefaultTableModel(nombreColumnas,0);
		
		GradientPanel background = new GradientPanel();
	    background.setBounds(0, 0, 506, 353);
	    getContentPane().add(background);
	    background.setLayout(null);
		
		//2º crear la tabla
		tablaContactos = new JTable(tableModel);
		
		//3º meter la tabla en el Scrollpane
		
		scrollPane = new JScrollPane(tablaContactos);
		scrollPane.setBounds(196, 46, 300, 298);
		background.add(scrollPane);
		
		
		
		//botones
		botonAdd = new JButton("Añadir contacto");
		botonAdd.setBounds(20, 100, 150, 30);
		botonAdd.setBackground(Color.WHITE);
		botonAdd.setFont(new Font("Dialog",Font.BOLD,13));
		background.add(botonAdd);
		
		botonDelete = new JButton("Eliminar contacto");
		botonDelete.setBounds(20, 180, 150, 30);
		botonDelete.setBackground(Color.WHITE);
		botonDelete.setFont(new Font("Dialog",Font.BOLD,13));
		background.add(botonDelete);
		
		botonEdit = new JButton("Editar contacto");
		botonEdit.setBounds(20, 140, 150, 30);
		botonEdit.setBackground(Color.WHITE);
		botonEdit.setFont(new Font("Dialog",Font.BOLD,13));
		background.add(botonEdit);
		
		//botonos de guardar y cargar
		botonGuardar = new JButton("Guardar");
		botonGuardar.setBounds(20, 240, 150, 30);
		botonGuardar.setBackground(Color.WHITE);
		botonGuardar.setFont(new Font("Dialog",Font.BOLD,14));
		background.add(botonGuardar);
		
		botonCargar = new JButton("Cargar");
		botonCargar.setBounds(20, 280, 150, 30);
		botonCargar.setBackground(Color.WHITE);
		botonCargar.setFont(new Font("Dialog",Font.BOLD,14));
		background.add(botonCargar);
		

		/*
		
		//crear el componente
		icono = new JLabel();
		icono.setIcon(new ImageIcon("img/agenda6-80.png"));
		//colocarlo en la ventana
		
		//icono.setBounds(55, 9, 90, 90);
		icono.setLocation(55, 9);
		icono.setSize(80, 80);
		//añadir el icono al panel
		background.add(icono);
	*/
	
		//crear el ICONO **********ESTE QUE REDIMENSIONA IMAGEN
		
		Image img = new ImageIcon("img/agenda6-512.png").getImage();
		icono = new JLabel(new ImageIcon(img.getScaledInstance(80, 80, Image.SCALE_SMOOTH)));
		icono.setBounds(55, 9, 80, 80);
		background.add(icono);
		
		 ImageIcon sonidoIcon = new ImageIcon("img/altavoz.png");
	     Image imageSonido = sonidoIcon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
	     sonidoIcon = new ImageIcon(imageSonido);
	     botonSonido = new JButton(sonidoIcon);
	     botonSonido.setBounds(20, 320, 30, 30);
	     botonSonido.setContentAreaFilled(false); // Hace que el área del botón no sea pintada
	     botonSonido.setBorderPainted(false); // Elimina el borde del botón
	     background.add(botonSonido);
	     

		 ImageIcon sonidoNoIcon = new ImageIcon("img/silencio-naranja.png");
	     Image imageNoSonido = sonidoNoIcon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
	     sonidoNoIcon = new ImageIcon(imageNoSonido);
	     botonNoSonido = new JButton(sonidoNoIcon);
	     botonNoSonido.setBounds(60, 320, 30, 30);
	     botonNoSonido.setContentAreaFilled(false); // Hace que el área del botón no sea pintada
	     botonNoSonido.setBorderPainted(false); // Elimina el borde del botón
	     background.add(botonNoSonido);
	     
	  
	     ImageIcon iconoOrdenar = new ImageIcon("img/clasificar2.png");
	     Image imageOrdenar = iconoOrdenar.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
	     iconoOrdenar = new ImageIcon(imageOrdenar);
	     botonAZ = new JButton(iconoOrdenar);
	     botonAZ.setBounds(160, 50, 30, 30);
	     botonAZ.setContentAreaFilled(false); // Hace que el área del botón no sea pintada
	     botonAZ.setBorderPainted(false); // Elimina el borde del botón
	     background.add(botonAZ);
	     
	     /* 
	      * PRUEBAS PARA USAR SVG
	      * 
	      * */
	     
	
		
		
		//Cambiar la fuente de la ventana
		
		try {
			Font font = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("TERMINAT.ttf"));
	
			//crear la label con esa fuente
			nombreApp = new JLabel("MIS CONTACTOS");		
			//alineacion centrada
			nombreApp.setHorizontalAlignment(SwingConstants.CENTER);
			//meter la fuente
			nombreApp.setFont(font.deriveFont(20f));
			//colocar la etiqueta
			nombreApp.setBounds(209, 10, 271, 22);
			//color de la letra en blanco
			nombreApp.setForeground(Color.WHITE);
			background.add(nombreApp);
			
		} catch (FontFormatException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		
	}
	//
		
	//creamos un metodo en la vista para tener acceso al controlador
	//hay que hacer un metodo por cada evento que necesite ser escuchado
	/**
     * Metodo para establecer listeners al controlador.
     * @param controlador representa el controlador que manejara los eventos.
     */
	public void establecerListeners(ControladorActionListener controlador) {
		
		botonAdd.addActionListener(controlador);
		botonEdit.addActionListener(controlador);
		botonDelete.addActionListener(controlador);
		botonGuardar.addActionListener(controlador);
		botonCargar.addActionListener(controlador);
		botonSonido.addActionListener(controlador);
		botonNoSonido.addActionListener(controlador);
		botonAZ.addActionListener(controlador);
	}
	
		//Obtener la fila seleccionada
	/**
     * Metodo para obtener la fila seleccionada en la tabla de contactos.
     * @return La fila seleccionada.
     */
	public int obtenerFilaSeleccionada() {
		return tablaContactos.getSelectedRow();
	}
	
	
	//getters y setters de los botones para acceder a ellos desde el controlador
	
	public JButton getBotonAdd() {
		return botonAdd;
	}
	public DefaultTableModel getTableModel() {
		return tableModel;
	}
	public JButton getBotonEdit() {
		return botonEdit;
	}
	public JButton getBotonDelete() {
		return botonDelete;
	}
	public JButton getBotonGuardar() {
		return botonGuardar;
	}
	public JButton getBotonCargar() {
		return botonCargar;
	}
	public JButton getBotonSonido() {
		return botonSonido;
	}
	public JButton getBotonNoSonido() {
		return botonNoSonido;
	}
	public JButton getBotonAZ() {
		return botonAZ;
	}
	
}
