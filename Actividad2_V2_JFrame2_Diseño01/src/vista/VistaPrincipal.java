package vista;





import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import javax.swing.table.DefaultTableModel;

import controlador.ControladorActionListener;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class VistaPrincipal extends JFrame{
	
	//Atributos de la clase, componentes que vamod a necesitar
	
	//Icono
	private JLabel icono;
	//Botones 
	private JButton botonAdd;
	private JButton botonEdit;
	private JButton botonDelete;
	
	//DefaultTableModel(tabla |x|y|)  ->  JTable  -> ScrollPane
	
	//definir tabla JTable
	private JTable tablaContactos;
	//modelo tabla
	private DefaultTableModel tableModel;
	//contenedor con scroll
	private JScrollPane scrollPane;
	private JPanel panel;
	private JLabel lblNewLabel;
	
	//Constructor para inicializar las variables
	public VistaPrincipal() {
		//crear la ventana y establecerla
		setBounds(100,100,530,359);
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
		background.setBackground(Color.WHITE);
		background.setBounds(0, 0, 530, 322);
		getContentPane().add(background);
		background.setLayout(null);
		
		//2º crear la tabla
		tablaContactos = new JTable(tableModel);
		
		//3º meter la tabla en el Scrollpane
		
		scrollPane = new JScrollPane(tablaContactos);
		scrollPane.setBounds(201, 11, 300, 300);
		background.add(scrollPane);
		
		
		
		//botones
		botonAdd = new JButton("Añadir contacto");
		botonAdd.setBounds(10, 135, 150, 30);
		background.add(botonAdd);
		
		botonDelete = new JButton("Eliminar contacto");
		botonDelete.setBounds(10, 254, 150, 30);
		background.add(botonDelete);
		
		botonEdit = new JButton("Editar contacto");
		botonEdit.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
				}
		});
		botonEdit.setBounds(10, 195, 150, 30);
		background.add(botonEdit);
			
		panel = new JPanel();
		panel.setBackground(SystemColor.textHighlight);
		panel.setBounds(0, 0, 191, 322);
		background.add(panel);
		
		//crear el ICONO
		Image img = new ImageIcon("icono256.png").getImage();
		icono = new JLabel(new ImageIcon(img.getScaledInstance(80,80, Image.SCALE_SMOOTH)));
		icono.setBounds(90, 20, 80, 80);
		getContentPane().add(icono);
		
		
		
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
