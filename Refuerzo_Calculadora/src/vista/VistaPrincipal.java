package vista;


import java.awt.Toolkit;

import javax.swing.JButton;

import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.JTextField;


import controlador.Controlador;

public class VistaPrincipal extends JFrame {

		//Declaramos
	
		private JLabel numero1, numero2, resultado, resultadoFinal;
		private JTextField cajaNumero1, cajaNumero2;
		private JButton botonSumar, botonRestar, botonMultiplicar, botonDividir, botonRaiz2, botonRaiz3;
	
		
		//constructor
		public VistaPrincipal() {
			setBounds(100,100,300,500);
			//establecer lo que hace el boton cerrar X
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			//decimos que no vamos a utilizar layout, lo posicionamos nosotros
			getContentPane().setLayout(null);
			//que no se pueda redimensionar por el usuario
			setResizable(false);
			//Nombre ventana
			setTitle("Calculadora");
			//
			//setLayout(null);
			//icono de la ventana
			setIconImage(Toolkit.getDefaultToolkit().getImage("img/icono16.png"));
			//funcion para inicializar las variables
			inicializarVariables();
			//hacer visible la ventana (tiene que ser la ultima opcion del constructor)
			setVisible(true);
		}
		
		//inicializamos
		void inicializarVariables() {
			
			//etiquetas numeros
			numero1 = new JLabel("Numero 1: ");
			numero1.setBounds(49,53,64,45);
			getContentPane().add(numero1);
			
			numero2 = new JLabel("Numero 2: ");
			numero2.setBounds(49,109,64,45);
			getContentPane().add(numero2);
			
			//caja de texto numeros
			
			cajaNumero1 = new JTextField();
			cajaNumero1.setBounds(123,53,114,45);
			getContentPane().add(cajaNumero1);
			
			cajaNumero2 = new JTextField();
			cajaNumero2.setBounds(123,109,114,45);
			getContentPane().add(cajaNumero2);
			
			//botonSumar, botonRestar, botonMultiplicar, botonDividir, botonRaiz2, botonRaiz3;
			
			//botones
			botonSumar = new JButton("Sumar");
			botonSumar.setBounds(49, 199, 96, 30);
			getContentPane().add(botonSumar);
			
			botonRestar = new JButton("Restar");
			botonRestar.setBounds(155, 199, 96, 30);
			getContentPane().add(botonRestar);
			
			botonMultiplicar = new JButton("Multiplicar");
			botonMultiplicar.setBounds(49, 258, 96, 30);
			getContentPane().add(botonMultiplicar);
			
			botonDividir = new JButton("Dividir");
			botonDividir.setBounds(155, 258, 96, 30);
			getContentPane().add(botonDividir);
			
			botonRaiz2 = new JButton("Raiz 2");
			botonRaiz2.setBounds(49, 317, 96, 30);
			getContentPane().add(botonRaiz2);
			
			botonRaiz3 = new JButton("Raiz 3");
			botonRaiz3.setBounds(155, 317, 96, 30);
			getContentPane().add(botonRaiz3);
			
			
			//etiqueta resultado
			resultado = new JLabel();
			resultado.setBounds(49,380,64,45);
			resultado.setText("Resultado: ");
			getContentPane().add(resultado);
			
			resultadoFinal = new JLabel();
			resultadoFinal.setBounds(123,380,96,45);
			resultadoFinal.setText("************");
			getContentPane().add(resultadoFinal);
			
			
		}
		//listener con el controlador
		////botonSumar, botonRestar, botonMultiplicar, botonDividir, botonRaiz2, botonRaiz3;
		


		public void establecerManejador(Controlador controlador) {
			botonSumar.addActionListener(controlador);
			botonRestar.addActionListener(controlador);
			botonMultiplicar.addActionListener(controlador);
			botonDividir.addActionListener(controlador);
			botonRaiz2.addActionListener(controlador);
			botonRaiz3.addActionListener(controlador);
		}
		
		// getter /setter
		
		public JLabel getResultado() {
			return resultado;
		}

		public void setResultado(JLabel resultado) {
			this.resultado = resultado;
		}

		public JTextField getCajaNumero1() {
			return cajaNumero1;
		}

		public void setCajaNumero1(JTextField cajaNumero1) {
			this.cajaNumero1 = cajaNumero1;
		}

		public JTextField getCajaNumero2() {
			return cajaNumero2;
		}

		public void setCajaNumero2(JTextField cajaNumero2) {
			this.cajaNumero2 = cajaNumero2;
		}

		public JButton getBotonSumar() {
			return botonSumar;
		}

		public JButton getBotonRestar() {
			return botonRestar;
		}

		public JButton getBotonMultiplicar() {
			return botonMultiplicar;
		}

		public JButton getBotonDividir() {
			return botonDividir;
		}

		public JButton getBotonRaiz2() {
			return botonRaiz2;
		}

		public JButton getBotonRaiz3() {
			return botonRaiz3;
		}

}
