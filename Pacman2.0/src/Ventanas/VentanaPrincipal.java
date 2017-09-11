package Ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;

public class VentanaPrincipal extends JFrame {

	private JPanel contentPane, panelNorte, panelCentro;
	private JLabel lblTitulo;
	private JButton btnStart, btnScores, btnQuit;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 452, 360);
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
		btnStart.setBounds(144, 34, 113, 43);
		panelCentro.add(btnStart);
		
		btnScores = new JButton("Scores");
		btnScores.setFont(new Font("DialogInput", Font.BOLD, 20));
		btnScores.setBounds(144, 94, 113, 42);
		panelCentro.add(btnScores);
		
		btnQuit = new JButton("Quit");
		btnQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnQuit.setFont(new Font("DialogInput", Font.BOLD, 20));
		btnQuit.setBounds(144, 154, 113, 43);
		panelCentro.add(btnQuit);
	}
}
