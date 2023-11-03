package vista;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

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
	}
	//metodo para inicializar variables
	private void initVariables() {
		//crear el componente
		icono = new JLabel();
		icono.setIcon(new ImageIcon("img/icono.png"));
		//colocarlo en la ventana
		icono.setBounds(294, 33, 192, 183);
		//añadir el icono al panel
		add(icono);
		
		
	}
	
	
	
	

}
