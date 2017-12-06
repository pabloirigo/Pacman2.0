package Ventanas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MoveAction;

import TiposDeDatos.Fantasmas;
import TiposDeDatos.GestionFicheros;
import TiposDeDatos.Icono;
import TiposDeDatos.Pacman;

import java.awt.GridLayout;
import java.awt.event.KeyEvent;

public class VentanaNivel extends JFrame implements Runnable {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane, panelNorte, panelSur, panelCentro;
	public static Object aBi[][];

	public int columnas, filas;
	Pacman pacman = new Pacman();
	Fantasmas fantasma = new Fantasmas();
	int dir;
	
	public VentanaNivel(Object aBi[][]) {

		VentanaNivel.aBi = aBi;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		panelNorte = new JPanel();
		contentPane.add(panelNorte, BorderLayout.NORTH);

		panelSur = new JPanel();
		contentPane.add(panelSur, BorderLayout.SOUTH);

		panelCentro = new JPanel();
		contentPane.add(panelCentro, BorderLayout.CENTER);
		panelCentro.setLayout(new GridLayout(0, 25, 0, 0));

		//aBi = GestionFicheros.volcarFicheroArray(nomfich);
		
		for (int i = 0; i < aBi.length; i++) {			
			for (int j = 0; j < aBi[0].length; j++) {
				panelCentro.add((JLabel) aBi[i][j]);				
				JLabel l = (JLabel)aBi[i][j];
				ImageIcon im = (ImageIcon)l.getIcon();
				if(im.getDescription().equals("Imagenes\\Pacman.png")){
					pacman.setX(i);
					pacman.setY(j);
				} else if(im.getDescription().equals("Imagenes\\FantasmaNaranja.png")) {
					fantasma.setFantasmaNaranjaX(i);
					fantasma.setFantasmaNaranjaY(j);
				}else if(im.getDescription().equals("Imagenes\\FantasmaRojo.png")) {
					fantasma.setFantasmaRojoX(i);
					fantasma.setFantasmaRojoY(j);
				}else if(im.getDescription().equals("Imagenes\\FantasmaAzul.png")) {
					fantasma.setFantasmaAzulX(i);
					fantasma.setFantasmaAzulY(j);
				}else if(im.getDescription().equals("Imagenes\\FantasmaRosa.png")) {
					fantasma.setFantasmaRosaX(i);
					fantasma.setFantasmaRosaY(j);	
				}
				setVisible(true);
			}
		}
		System.out.println(pacman.getX());
		System.out.println(pacman.getY());
		//t.start();
	}


	public void keyPressed(KeyEvent e ) {

		// TODO Auto-generated method stub
		int keyCode = e.getKeyCode();
		Pacman pacman = new Pacman();

		switch( keyCode ) {
		case KeyEvent.VK_UP:
			System.out.println(pacman.getX());
			dir = 1;
			run();
			break;	
		case KeyEvent.VK_DOWN:	
			dir = 2;
			run();
			break;
		case KeyEvent.VK_RIGHT :
			dir = 3;
			run();			
			break;
		case KeyEvent.VK_LEFT:	
			dir = 4;
			run();
			break;
		}
	}


	public void run() {
		
		//como mover la imagen con layout???
	

		Pacman pacman = new Pacman();
		
		switch(dir) {
		case 1 : //mover hacia arriba
			while(Icono.hayPared(dir,aBi,pacman.getX(),pacman.getY())==false || Icono.dentroTablero(pacman.getX(), pacman.getY())==true) {
				int y = pacman.getY() + 1;
				pacman.setY(y);

				int cx = pacman.getX();
				int cy = pacman.getY();
				//JLabel lblArriba = (JLabel)aBi[cx][cy-1];
				ImageIcon im = new ImageIcon("Imagenes\\Pared.png");
				ImageIcon im2 = new ImageIcon("Imagenes\\Pacman.png");
				im2.setDescription("Imagenes\\Pacman");
				im.setDescription("Imagenes\\Pared.png");
				aBi[cx][cy] = new JLabel(im2);
				aBi[cx][cy-1] = new JLabel(im);
							
				
			}		
			break;
		case 2 :// mover hacia abajo
			while(Icono.hayPared(dir,aBi,pacman.getX(), pacman.getY())== false || Icono.dentroTablero(pacman.getX(), pacman.getY())==true) {
				int y = pacman.getY()-1;
				pacman.setY(y);

				int cx = pacman.getX();
				int cy = pacman.getY();
				//JLabel lblArriba = (JLabel)aBi[cx][cy-1];
				ImageIcon im = new ImageIcon("Imagenes\\Pared.png");
				ImageIcon im2 = new ImageIcon("Imagenes\\Pacman.png");
				im2.setDescription("Imagenes\\Pacman");
				im.setDescription("Imagenes\\Pared.png");
				aBi[cx][cy] = new JLabel(im2);
				aBi[cx][cy-1] = new JLabel(im);

			}
			break;
		case 3 : // mover hacia derecha
			while(Icono.hayPared(dir,aBi,pacman.getX(),pacman.getY())==false || Icono.dentroTablero(pacman.getX(), pacman.getY())==true) {
				int x = pacman.getX()+1;
				pacman.setX(x);
				
				int cx = pacman.getX();
				int cy = pacman.getY();
				//JLabel lblArriba = (JLabel)aBi[cx][cy-1];
				ImageIcon im = new ImageIcon("Imagenes\\Pared.png");
				ImageIcon im2 = new ImageIcon("Imagenes\\Pacman.png");
				im2.setDescription("Imagenes\\Pacman");
				im.setDescription("Imagenes\\Pared.png");
				aBi[cx][cy] = new JLabel(im2);
				aBi[cx][cy-1] = new JLabel(im);
				
			}
			break;
		case 4: // mover hacia izquierda
			while(Icono.hayPared(dir,aBi,pacman.getX(),pacman.getY())==false || Icono.dentroTablero(pacman.getX(), pacman.getY())==true) {
				int x= pacman.getX() -1;
				pacman.setX(x);
				
				int cx = pacman.getX();
				int cy = pacman.getY();
				//JLabel lblArriba = (JLabel)aBi[cx][cy-1];
				ImageIcon im = new ImageIcon("Imagenes\\Pared.png");
				ImageIcon im2 = new ImageIcon("Imagenes\\Pacman.png");
				im2.setDescription("Imagenes\\Pacman");
				im.setDescription("Imagenes\\Pared.png");
				aBi[cx][cy] = new JLabel(im2);
				aBi[cx][cy-1] = new JLabel(im);
				
				

			}
			break;
		}
	}

}