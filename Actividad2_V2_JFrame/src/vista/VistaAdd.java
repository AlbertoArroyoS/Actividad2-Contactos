package vista;

import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controlador.ControladorActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class VistaAdd extends JFrame {
    private JLabel nombre;
    private JLabel telefono;
    private JButton botonOk;
    private JButton botonCancel;
    private JTextField campoNombre;
    private JTextField campoTelefono;
    private ControladorActionListener controlador;
    
    //le pasamos por parametro el controlador
    public VistaAdd(ControladorActionListener controlador) {
        this.controlador = controlador;

        // Crear la ventana y establecerla
        setTitle("Añadir Contacto");
        setBounds(100, 100, 400, 180);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        getContentPane().setLayout(null); // No se recomienda, pero se mantiene por compatibilidad
        setResizable(false);
        setIconImage(Toolkit.getDefaultToolkit().getImage("img/icono16.png"));

        // Llamar a initVariables para inicializar los componentes
        initVariables();

        // Hacer visible la ventana (debe ser la última opción del constructor)
        setVisible(true);
    }

    private void initVariables() {
        // Crear los componentes y configurarlos
        nombre = new JLabel("Nombre");
        nombre.setBounds(60, 10, 80, 20);
        getContentPane().add(nombre);
        
        campoNombre = new JTextField();
        //Que solo se puedan introducir letras en el campo
        campoNombre.addKeyListener(new KeyAdapter() {
        	@Override
        	public void keyTyped(KeyEvent e) {
        		int key = e.getKeyChar();
        		//donde empiezan y terminan los numeros en asci
        		boolean mayusculas = key >=65 && key <=90;
        		boolean minusculas = key >=97 && key <= 122;
        		boolean espacio = key == 32;
        		//Si se introduce algo que no sean letras mayusculas o minusculas
        		if (!(mayusculas || minusculas || espacio)) {
        			e.consume();
        		}
        		
        	}
        });
        campoNombre.setBounds(140, 10, 80, 20);
        getContentPane().add(campoNombre);
        
        telefono = new JLabel("Teléfono");
        telefono.setBounds(60, 40, 80, 20);
        getContentPane().add(telefono);
        
        
        campoTelefono = new JTextField();
        //Condicion para no introducir letras Design->SeleccionarCampo->Key->KeyTyped
        campoTelefono.addKeyListener(new KeyAdapter() {
        	@Override
        	public void keyTyped(KeyEvent e) {
        		int key = e.getKeyChar();
        		//donde empiezan y terminan los numeros en asci
        		boolean numeros = key >=48 && key <=57;
        		//Si se introduce algo que no sea numero no se introduce
        		if (!numeros) {
        			e.consume();
        		}
        		//No se pueden introducir mas de 9 numeros en el campo
        		if(campoTelefono.getText().length()>=9) {
        			e.consume();
        		}
        	}
        });
        campoTelefono.setBounds(140, 40, 80, 20);
        getContentPane().add(campoTelefono);

        botonOk = new JButton("Ok");
        botonOk.setBounds(100, 80, 80, 30);
        getContentPane().add(botonOk);

        botonCancel = new JButton("Cancel");
        botonCancel.setBounds(200, 80, 80, 30);
        getContentPane().add(botonCancel);
    }


	public void establecerListeners(ControladorActionListener controlador) {
        botonOk.addActionListener(controlador);
        botonCancel.addActionListener(controlador);
    }
	
    
    //getters

	public JTextField getCampoNombre() {
		return campoNombre;
	}

	public JTextField getCampoTelefono() {
		return campoTelefono;
	}
    public JButton getBotonOk() {
		return botonOk;
	}

	public JButton getBotonCancel() {
		return botonCancel;
	}

}

