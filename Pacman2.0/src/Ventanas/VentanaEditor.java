package Ventanas;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.Point;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;

public class VentanaEditor extends JFrame implements MouseListener{

	private JPanel contentPane, panelNorte, panelSur, panelCentro;
	public ArrayList<String> aFotos;
	private JButton btnFondo, btnPared, btnPacman, btnFantasma, btnGuardarNivel, btnVolver;
	private String descripcion;
	
	private void inicializarConFondo(){
		for(int i=0;i<32;i++){
			for(int j=0;j<32;j++){
				ImageIcon im = new ImageIcon("Imagenes\\Fondo.png");
				im.setDescription("Imagenes\\Fondo.png");
				JLabel lblFoto = new JLabel(im);
				panelCentro.add(lblFoto);
			}
		}
	}
	
	private void cargarFotos(){
		for(String ruta : aFotos){
			ImageIcon im = new ImageIcon(ruta);
			im.setDescription(ruta);
			JLabel lblFoto = new JLabel(im);
			panelCentro.add(lblFoto);
		}
	}


	/**
	 * Create the frame.
	 */
	public VentanaEditor() {
		
		aFotos = VentanaPrincipal.bd.obtenerFotos();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 520, 510);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		panelNorte = new JPanel();
		contentPane.add(panelNorte, BorderLayout.NORTH);
		
		panelSur = new JPanel();
		contentPane.add(panelSur, BorderLayout.SOUTH);
		
		btnFondo = new JButton("Fondo");
		btnFondo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				descripcion = "Fondo";
			}
		});
		
		btnPared = new JButton("Pared");
		btnPared.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				descripcion = "Pared";
			}
		});
		panelSur.add(btnPared);
		panelSur.add(btnFondo);
		
		btnPacman = new JButton("Pacman");
		panelSur.add(btnPacman);
		
		btnFantasma = new JButton("Fant.");
		panelSur.add(btnFantasma);
		
		btnGuardarNivel = new JButton("Guard.Nivel");
		panelSur.add(btnGuardarNivel);
		
		btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaPrincipal ventPrin = new VentanaPrincipal();
				ventPrin.setVisible(true);
				dispose();
			}
		});
		panelSur.add(btnVolver);
		
		panelCentro = new JPanel();
		contentPane.add(panelCentro, BorderLayout.CENTER);
		panelCentro.setLayout(new GridLayout(0, 32, 0, 0));
		
		inicializarConFondo();
	}
	
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		Point p = e.getPoint();
		if(panelCentro.getComponentAt(p) instanceof JLabel){
			JLabel lblFoto = (JLabel)panelCentro.getComponentAt(p);
			if(descripcion.equals("Pared")){
				ImageIcon im = new ImageIcon("Imagenes\\Pared.png");
				im.setDescription("Imagenes\\Pared.png");
				lblFoto.setIcon(im);
			}else if(descripcion.equals("Fondo")){
				ImageIcon im = new ImageIcon("Imagenes\\Fondo.png");
				im.setDescription("Imagenes\\Fondo.png");
				lblFoto.setIcon(im);
			}
			panelCentro.updateUI();
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		Point p = e.getPoint();
		if(panelCentro.getComponentAt(p) instanceof JLabel){
			JLabel lblFoto = (JLabel)panelCentro.getComponentAt(p);
			
			if(descripcion.equals("Pared"))
				lblFoto.setIcon(new ImageIcon("Imagenes\\Pared.png"));
				
			else if(descripcion.equals("Fondo")) 
				lblFoto.setIcon(new ImageIcon("Imagenes\\Fondo.png"));
				
			panelCentro.updateUI();
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
