package vista;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controlador.Controlador;

public class Vista extends JFrame{
	
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
	
	//Constructor para inicializar las variables
	public Vista() {
		//crear la ventana y establecerla
		setBounds(100,100,800,800);
		//establecer lo que hace el boton cerrar X
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//decimos que no vamos a utilizar layout, lo posicionamos nosotros
		setLayout(null);
		//funcion para inicializar las variables
		initVariables();
		//hacer visible la ventana (tiene que ser la ultima opcion del constructor)
		setVisible(true);
		
	}
	//metodo para inicializar variables
	private void initVariables() {
		//crear el componente
		icono = new JLabel();
		icono.setIcon(new ImageIcon("img/icono128.png"));
		//colocarlo en la ventana
		icono.setBounds(200, 33, 128, 128);
		//añadir el icono al panel
		add(icono);
		
		//botones
		botonAdd = new JButton("Añadir contacto");
		botonAdd.setBounds(200, 550, 150, 30);
		add(botonAdd);
		
		botonEdit = new JButton("Editar");
		botonEdit.setBounds(500, 350, 100, 30);
		add(botonEdit);
		
		botonDelete = new JButton("Eliminar");
		botonDelete.setBounds(500, 300, 100, 30);
		add(botonDelete);
		
		//Tabla
		
		//1º crear el modelo
		
		//crear array con el nombre de las columnas
		String[] nombreColumnas= {"Nombre", "Teléfono"};
		tableModel = new DefaultTableModel(nombreColumnas,0);
		
		//2º crear la tabla
		tablaContactos = new JTable(tableModel);
		
		//3º meter la tabla en el Scrollpane
		
		scrollPane = new JScrollPane(tablaContactos);
		//ubicar el scroll pane
		scrollPane.setBounds(150, 200, 300, 300);
		add(scrollPane);
		
	}
	
	//creamos un metodo en la vista para tener acceso al controlador
	//hay que hacer un metodo por cada evento que necesite ser escuchado
	
	public void establecerListeners(Controlador controlador) {
		
		botonAdd.addActionListener(controlador);
		botonEdit.addActionListener(controlador);
		botonDelete.addActionListener(controlador);
	}

}
