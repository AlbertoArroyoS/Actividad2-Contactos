package vista;

import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controlador.ControladorActionListener;

public class VistaEditar extends JFrame {
    private JLabel nombre;
    private JLabel telefono;
    private JButton botonOk;
    private JButton botonCancel;
    private JTextField campoNombre;
    private JTextField campoTelefono;
    private ControladorActionListener controlador;
    
    //le pasamos por parametro el controlador
    public VistaEditar(ControladorActionListener controlador) {
        this.controlador = controlador;

        // Crear la ventana y establecerla
        setTitle("Editar contacto");
        setBounds(100, 100, 400, 180);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setLayout(null); // No se recomienda, pero se mantiene por compatibilidad
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
        add(nombre);
        
        campoNombre = new JTextField();
        campoNombre.setBounds(140, 10, 80, 20);
        add(campoNombre);
        
        telefono = new JLabel("Teléfono");
        telefono.setBounds(60, 40, 80, 20);
        add(telefono);
        
        
        campoTelefono = new JTextField();
        campoTelefono.setBounds(140, 40, 80, 20);
        add(campoTelefono);

        botonOk = new JButton("Ok");
        botonOk.setBounds(100, 80, 80, 30);
        add(botonOk);

        botonCancel = new JButton("Cancel");
        botonCancel.setBounds(200, 80, 80, 30);
        add(botonCancel);
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

