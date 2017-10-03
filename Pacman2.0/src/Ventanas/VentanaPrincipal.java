package Ventanas;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BaseDeDatos.BD;
import TiposDeDatos.Usuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class VentanaPrincipal extends JFrame {

	private JPanel contentPane, panelNorte, panelCentro;
	private JLabel lblTitulo, lblUsuario, lblContrasenia;
	private JButton btnStart, btnEditor, btnScores, btnQuit, btnIniciarSesion, btnRegistrarse;
	public static BD bd;
	private JTextField txtUsuario;
	private JPasswordField txtContrasenia;
	private boolean sesionIniciada = false;

	/**
	 * Launch the application.
	 */
		
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
				     frame.setLocationRelativeTo(null);	
				     frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaPrincipal() {
		
		bd = new BD();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		panelNorte = new JPanel();
		contentPane.add(panelNorte, BorderLayout.NORTH);
		panelNorte.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		lblTitulo = new JLabel("Pacman 2.0");
		lblTitulo.setFont(new Font("DialogInput", Font.BOLD, 38));
		panelNorte.add(lblTitulo);
		
		panelCentro = new JPanel();
		contentPane.add(panelCentro, BorderLayout.CENTER);
		panelCentro.setLayout(null);
		
		btnStart = new JButton("Start");
		btnStart.setFont(new Font("DialogInput", Font.BOLD, 20));
		btnStart.setBounds(130, 35, 130, 36);
		panelCentro.add(btnStart);
		
		btnEditor = new JButton("Editor");
		btnEditor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaEditor ventEdit = new VentanaEditor();
				ventEdit.setVisible(true);
				dispose();
			}
		});
		btnEditor.setFont(new Font("DialogInput", Font.BOLD, 20));
		btnEditor.setBounds(130, 83, 130, 36);
		panelCentro.add(btnEditor);
		
		btnScores = new JButton("Scores");	
		btnScores.setFont(new Font("DialogInput", Font.BOLD, 20));
		btnScores.setBounds(130, 130, 130, 36);
		panelCentro.add(btnScores);
		
		btnQuit = new JButton("Quit");
		btnQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnQuit.setFont(new Font("DialogInput", Font.BOLD, 20));
		btnQuit.setBounds(130, 177, 130, 36);
		panelCentro.add(btnQuit);
		
		btnIniciarSesion = new JButton("Iniciar Sesion");
		btnIniciarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!sesionIniciada) {
					String txtnom = txtUsuario.getText();
					String txtcon = txtContrasenia.getText();
					if (txtnom.equals("") || txtcon.equals("")) {
						JOptionPane.showMessageDialog(null,
								"Para iniciar sesión tienes que insertar un nombre de usuario y una contraseña.",
								"ERROR!", JOptionPane.ERROR_MESSAGE);
						limpiarCampoUsuario();
						limpiarCampoContrasenia();
					} else {
						Usuario u = bd.obtenerUsuario(txtnom);
						if (u == null) {
							JOptionPane.showMessageDialog(null, "Lo sentimos, el usuario no está registrado.", "ERROR!",
									JOptionPane.ERROR_MESSAGE);
							btnRegistrarse.setVisible(true);
						} else if (!u.getContrasenia().equals(txtcon)) {
							JOptionPane.showMessageDialog(null, "Lo sentimos, la contraseña no es correcta.", "ERROR!",
									JOptionPane.ERROR_MESSAGE);
							limpiarCampoContrasenia();
						} else {
							JOptionPane.showMessageDialog(null, "Enhorabuena, ha iniciado sesión con exito.", "OK!",
									JOptionPane.INFORMATION_MESSAGE);
							sesionIniciada = true;
							deshabilitarCampos();
						}
					}
				} else {
					JOptionPane.showMessageDialog(null, "Ya hay una sesión iniciada.", "ERROR!",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnIniciarSesion.setBounds(268, 265, 123, 23);
		panelCentro.add(btnIniciarSesion);
		
		btnRegistrarse = new JButton("Registrarse");
		btnRegistrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtUsuario.equals("") || txtContrasenia.equals("")) {
					JOptionPane.showMessageDialog(null,
							"Para iniciar sesión tienes que insertar un nombre de usuario y una contraseña.", "ERROR!",
							JOptionPane.ERROR_MESSAGE);
				} else {
					Usuario u = bd.obtenerUsuario(txtUsuario.getText());
					if (u != null)
						//Funciona
						JOptionPane.showMessageDialog(null, "Ese usuario ya está registrado", "ERROR!",
								JOptionPane.ERROR_MESSAGE);
					else {
						//No Funciona, el problema esta en insertarNuevoUsuario(), en el executeUpdate.
						u = new Usuario(txtUsuario.getText(), txtContrasenia.getText());
						bd.insertarNuevoUsuario(u);
						JOptionPane.showMessageDialog(null, "Usuario registrado con éxito", "CORRECTO!",
								JOptionPane.INFORMATION_MESSAGE);
						deshabilitarCampos();
					}
				}
			}
		});
		btnRegistrarse.setBounds(268, 293, 123, 23);
		panelCentro.add(btnRegistrarse);
		btnRegistrarse.setVisible(false);
		
		lblUsuario = new JLabel("Usuario:");
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUsuario.setBounds(40, 261, 90, 26);
		panelCentro.add(lblUsuario);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(140, 266, 108, 20);
		panelCentro.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		lblContrasenia = new JLabel("Contraseña:");
		lblContrasenia.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblContrasenia.setBounds(40, 289, 90, 26);
		panelCentro.add(lblContrasenia);
		
		txtContrasenia = new JPasswordField();
		txtContrasenia.setBounds(140, 294, 108, 20);
		panelCentro.add(txtContrasenia);
		
	}
	
	private void limpiarCampoUsuario() {
		txtUsuario.setText("");
	}
	
	private void limpiarCampoContrasenia(){
		txtContrasenia.setText("");
	}
	
	private void habilitarCampos(){
		txtUsuario.setEnabled(true);
		txtContrasenia.setEnabled(true);
	}
	
	private void deshabilitarCampos(){
		txtUsuario.setEnabled(false);
		txtContrasenia.setEnabled(false);
	}
	
	/**Esto es una puta mierda y no funciona.*/
}
