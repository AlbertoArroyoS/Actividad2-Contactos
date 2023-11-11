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
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class VistaPrincipal extends JFrame{
	
	//Atributos de la clase, componentes que vamod a necesitar
	
	//Icono
	private JLabel icono, nombreApp;
	//Botones 
	private JButton botonAdd;
	private JButton botonEdit;
	private JButton botonDelete;
	private JButton botonGuardar;
	private JButton botonCargar;
	
	//DefaultTableModel(tabla |x|y|)  ->  JTable  -> ScrollPane
	
	//definir tabla JTable
	private JTable tablaContactos;
	//modelo tabla
	private DefaultTableModel tableModel;
	//contenedor con scroll
	private JScrollPane scrollPane;
	private JPanel panel;

	
	//Constructor para inicializar las variables
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
		setIconImage(Toolkit.getDefaultToolkit().getImage("img/icono16.png"));
		//funcion para inicializar las variables
		initVariables();
		//hacer visible la ventana (tiene que ser la ultima opcion del constructor)
		setVisible(true);
		
	}
	//metodo para inicializar variables
	private void initVariables() {
		
		//Tabla
		
		//1º crear el modelo
		
		//crear array con el nombre de las columnas
		String[] nombreColumnas= {"Nombre", "Teléfono"};
		tableModel = new DefaultTableModel(nombreColumnas,0);
		
		JPanel background = new JPanel();
		background.setBackground(Color.LIGHT_GRAY);
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
		background.add(botonAdd);
		
		botonDelete = new JButton("Eliminar contacto");
		botonDelete.setBounds(20, 180, 150, 30);
		botonDelete.setBackground(Color.WHITE);
		background.add(botonDelete);
		
		botonEdit = new JButton("Editar contacto");
		botonEdit.setBounds(20, 140, 150, 30);
		botonEdit.setBackground(Color.WHITE);
		background.add(botonEdit);
		
		//botonos de guardar y cargar
		botonGuardar = new JButton("Guardar");
		botonGuardar.setBounds(20, 260, 150, 30);
		botonGuardar.setBackground(Color.WHITE);
		background.add(botonGuardar);
		
		botonCargar = new JButton("Cargar");
		botonCargar.setBounds(20, 300, 150, 30);
		botonCargar.setBackground(Color.WHITE);
		background.add(botonCargar);
			
		panel = new JPanel();
		panel.setBackground(new Color(0, 0, 0));
		panel.setBounds(0, 0, 191, 353);
		background.add(panel);
		

		
		/*
		//crear el componente
		icono = new JLabel();
		icono.setIcon(new ImageIcon("img/contactos.png"));
		//colocarlo en la ventana
		icono.setBounds(20, 20, 128, 128);
		//añadir el icono al panel
		panel.add(icono);
	
	*/
		//crear el ICONO **********USAR ESTE QUE REDIMENSIONA
		
		Image img = new ImageIcon("img/contactos.png").getImage();
		icono = new JLabel(new ImageIcon(img.getScaledInstance(80, 80, Image.SCALE_SMOOTH)));
		icono.setBounds(50, 50, 80, 80);
		panel.add(icono);
		
		
		//Cambiar la fuente de la ventana
		
		try {
			Font font = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("TERMINAT.ttf"));
			
			JPanel panel_1 = new JPanel();
			panel_1.setBackground(new Color(0, 0, 0));
			panel_1.setBounds(191, 0, 325, 43);
			background.add(panel_1);
			//crear la label con esa fuente
			nombreApp = new JLabel("MIS CONTACTOS");
			panel_1.add(nombreApp);
			//alineacion centrada
			nombreApp.setHorizontalAlignment(SwingConstants.CENTER);
			//meter la fuente
			nombreApp.setFont(font.deriveFont(20f));
			//colocar la etiqueta
			nombreApp.setBounds(0, 10, 20, 10);
			//color de la letra en blanco
			nombreApp.setForeground(Color.WHITE);
			
		} catch (FontFormatException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
	}
	
	//creamos un metodo en la vista para tener acceso al controlador
	//hay que hacer un metodo por cada evento que necesite ser escuchado
	
	public void establecerListeners(ControladorActionListener controlador) {
		
		botonAdd.addActionListener(controlador);
		botonEdit.addActionListener(controlador);
		botonDelete.addActionListener(controlador);
	}
	
	
	
	
	//gettes y setters de los botones para acceder a ellos desde el controlador
	
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
	//Obtener la fila seleccionada
	public int obtenerFilaSeleccionada() {
		return tablaContactos.getSelectedRow();
	}
}
