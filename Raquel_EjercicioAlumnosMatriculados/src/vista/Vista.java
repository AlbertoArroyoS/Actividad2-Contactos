package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import controlador.Controlador;

public class Vista extends JFrame{
	private JLabel icono;
	private JTextField nombreAlumno;
	private JCheckBox checkMatriculado, checkConvalidado;
	private JButton botonAdd;
	private JTextArea listaAlumnos;
	private JTable table;
	private DefaultTableModel tableModel;
	private JScrollPane scrollPane;
	
	public Vista() {
		setBounds(100,100,790,700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(null);
		inicializarVariables();
		//establecerEventos(); SIN MVC
		setVisible(true);
	}
	
	void inicializarVariables() {
		icono = new JLabel();
		icono.setIcon(new ImageIcon("logo.png"));
		icono.setBounds(294,33,192,183);
		add(icono);
		
		nombreAlumno = new JTextField();
		nombreAlumno.setBounds(99,318,192,45);
		add(nombreAlumno);
		
		checkMatriculado = new JCheckBox("matriculado");
		checkMatriculado.setBounds(99,390,192,21);
		checkMatriculado.setSelected(true);
		checkMatriculado.setFont(new Font("Arial",Font.BOLD, 18));
		add(checkMatriculado);
		
		checkConvalidado = new JCheckBox("convalidado");
		checkConvalidado.setBounds(99,415,192,21);
		checkConvalidado.setSelected(false);
		checkConvalidado.setFont(new Font("Arial",Font.BOLD, 18));
		add(checkConvalidado);
		
		botonAdd = new JButton("Añadir");
		botonAdd.setBounds(99,460,192,61);
		botonAdd.setFont(new Font("Arial",Font.BOLD, 18));
		add(botonAdd);
		
		String[] columnNames = {"Alumno", "Convalidada"};		
		tableModel = new DefaultTableModel(columnNames, 0);  //[]nombreColumnas, int númeroInicialFilas
		table = new JTable(tableModel);
		//table.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
		//table.setShowVerticalLines(false);
		//table.setBackground(new Color(255, 255, 255));
		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(433,318,258,200);
		add(scrollPane);

	}
	
/*
	void establecerEventos() {
		botonAdd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	}
*/

	public void EstablecerManejador(Controlador controlador) {
		botonAdd.addActionListener(controlador);		
	}
	
	//Getters y Setters necesarios
	
	public JTextField getNombreAlumno() {
		return nombreAlumno;
	}
	
	public JCheckBox getCheckMatriculado() {
		return checkMatriculado;
	}


	public JCheckBox getCheckConvalidado() {
		return checkConvalidado;
	}

	public DefaultTableModel getTableModel() {
		return tableModel;
	}

}
