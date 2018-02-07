package Ventanas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MoveAction;

import Threads.ThreadFantasmaAzul;
import Threads.ThreadFantasmaNaranja;
import Threads.ThreadFantasmaRojo;
import Threads.ThreadFantasmaRosa;
import TiposDeDatos.Fantasmas;
import TiposDeDatos.GestionFicheros;
import TiposDeDatos.Icono;
import TiposDeDatos.Pacman;

import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class VentanaNivel extends JFrame implements Runnable, KeyListener {

	public static JPanel panelCentro;
	private static final long serialVersionUID = 1L;
	private JPanel contentPane, panelNorte, panelSur;//, panelCentro;
	public static Object aBi[][];
	public static int puntuacion=0;
	public int columnas, filas;
	Pacman pacman = new Pacman();
	Fantasmas fantasma = new Fantasmas();
	public static int dir, f, c, fBlinky, cBlinky, fInky, cInky, fClyde, cClyde, fPinky, cPinky;
	public static boolean choque  = false;
	public static ThreadFantasmaAzul tfa;
	public static ThreadFantasmaRojo tfr;
	public static ThreadFantasmaNaranja tfn;
	public static ThreadFantasmaRosa tfrs;
	public boolean VentanaCorriendo;

	public VentanaNivel(Object aBi[][]) {


		VentanaNivel.aBi = aBi;
		addKeyListener(this);
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

				JLabel l = (JLabel)aBi[i][j];
				ImageIcon im = (ImageIcon)l.getIcon();
				if(!im.getDescription().equals("Imagenes\\PacmanConFondo.png") && !im.getDescription().equals("Imagenes\\Pared.png")
						&& !im.getDescription().startsWith("Imagenes\\Fan") ){
					ImageIcon im2 = new ImageIcon("Imagenes\\Bolita.png");
					im2.setDescription("Imagenes\\Bolita.png");
					((JLabel)aBi[i][j]).setIcon(im2);

				}

				panelCentro.add((JLabel) aBi[i][j]);
				if (((ImageIcon) ((JLabel) aBi[i][j]).getIcon()).getDescription()
						.equalsIgnoreCase("Imagenes\\PacmanConFondo.png")) {
					f = i;
					c = j;
				}else if(((ImageIcon) ((JLabel) aBi[i][j]).getIcon()).getDescription()
						.equalsIgnoreCase("Imagenes\\FantasmaAzul.png")) {
					fInky = i;
					cInky = j;
				}else if(((ImageIcon) ((JLabel) aBi[i][j]).getIcon()).getDescription()
						.equalsIgnoreCase("Imagenes\\FantasmaRojo.png")) {
					fBlinky = i;
					cBlinky = j;
				}else if(((ImageIcon) ((JLabel) aBi[i][j]).getIcon()).getDescription()
						.equalsIgnoreCase("Imagenes\\FantasmaNaranja.png")) {
					fClyde = i;
					cClyde = j;
				}else if(((ImageIcon) ((JLabel) aBi[i][j]).getIcon()).getDescription()
						.equalsIgnoreCase("Imagenes\\FantasmaRosa.png")) {
					fPinky = i;
					cPinky = j;
				}
				
			}
			setVisible(true);
			VentanaCorriendo = true; //se pone a false cuando se choca conun fantasma
		}
		System.out.println("El pacman est� en " + f + "-" + c);	
		System.out.println("El FantasmaAzul est� en " + fInky + "-" + cInky);
		System.out.println("El FantasmaRojo est� en " + fBlinky + "-" + cBlinky);
		System.out.println("El FantasmaNaranja est� en " + fClyde + "-" + cClyde);
		System.out.println("El FantasmaRosa est� en " + fPinky + "-" + cPinky);
		
		
		/**Inicializo el Hilo del fantasmaAzul**/
	//	while(VentanaCorriendo == true) {
		
		//tfa = new ThreadFantasmaAzul();
		//tfa.start();
	//	}
		/**Inicializo el Hilo del fantasmaRojo**/
	//	while(VentanaCorriendo == true) {
	//	tfr = new ThreadFantasmaRojo();
		//tfr.start();
	//	}
		/**Inicializo el Hilo del fantasmaRojo**/
	//	while(VentanaCorriendo == true) {
		//tfn = new ThreadFantasmaNaranja();
		//tfn.start();
	//	}
		
		/**Inicializo el Hilo del fantasmaRojo**/
	//	while(VentanaCorriendo == true) {
//		tfrs = new ThreadFantasmaRosa();
	//	tfrs.start();
	//	}
	}
	

	public  void cambiarPanel() {
		panelCentro.removeAll();
		for (int i = 0; i < aBi.length; i++) {
			for (int j = 0; j < aBi[0].length; j++) {
				panelCentro.add((JLabel) aBi[i][j]);
			}
			setVisible(true);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}
	public void keyPressed(KeyEvent k) {

		// TODO Auto-generated method stub
		switch(k.getKeyCode()) {
		case KeyEvent.VK_RIGHT:
			if(c<24 && (((ImageIcon) ((JLabel) aBi[f][c+1]).getIcon()).getDescription().equalsIgnoreCase("Imagenes\\Bolita.png"))||
					(((ImageIcon) ((JLabel) aBi[f][c+1]).getIcon()).getDescription().equalsIgnoreCase("Imagenes\\Fondo.png"))) {
				Object aux = aBi[f][c + 1];
				aBi[f][c + 1] = aBi[f][c];
				aBi[f][c] = aux;
				c++;
				ImageIcon im = new ImageIcon("Imagenes\\PacmanConFondo.png");
				im.setDescription("Imagenes\\PacmanConFondo.png");
				((JLabel) aBi[f][c]).setIcon(im);
				ImageIcon im2 = new ImageIcon("Imagenes\\Fondo.png");
				im2.setDescription("Imagenes\\Fondo.png");
				((JLabel) aBi[f][c-1]).setIcon(im2);
				cambiarPanel();
			}else if(((ImageIcon) ((JLabel) aBi[f][c+1]).getIcon()).getDescription().equalsIgnoreCase("Imagenes\\Pared.png")){
				break;
			}

			break;	
		case KeyEvent.VK_LEFT:	
			if(c>0 && (((ImageIcon) ((JLabel) aBi[f][c-1]).getIcon()).getDescription().equalsIgnoreCase("Imagenes\\Bolita.png"))||
					(((ImageIcon) ((JLabel) aBi[f][c-1]).getIcon()).getDescription().equalsIgnoreCase("Imagenes\\Fondo.png"))) {
				Object aux = aBi[f][c - 1];
				aBi[f][c - 1] = aBi[f][c];
				aBi[f][c] = aux;
				c--;
				ImageIcon im = new ImageIcon("Imagenes\\PacmanIzquierda.png");
				im.setDescription("Imagenes\\PacmanIzquierda.png");
				((JLabel) aBi[f][c]).setIcon(im);
				ImageIcon im2 = new ImageIcon("Imagenes\\Fondo.png");
				im2.setDescription("Imagenes\\Fondo.png");
				((JLabel) aBi[f][c+1]).setIcon(im2);
				cambiarPanel();
			}else if(((ImageIcon) ((JLabel) aBi[f][c-1]).getIcon()).getDescription().equalsIgnoreCase("Imagenes\\Pared.png")){
				break;
			}
			break;
		case KeyEvent.VK_UP :	
			if(f>=0 && (((ImageIcon) ((JLabel) aBi[f-1][c]).getIcon()).getDescription().equalsIgnoreCase("Imagenes\\Bolita.png"))||
			(((ImageIcon) ((JLabel) aBi[f-1][c]).getIcon()).getDescription().equalsIgnoreCase("Imagenes\\Fondo.png"))) {
				Object aux = aBi[f - 1][c];
				aBi[f -1][c] = aBi[f][c];
				aBi[f][c] = aux;
				f--;
				ImageIcon im = new ImageIcon("Imagenes\\PacmanArriba.png");
				im.setDescription("Imagenes\\PacmanArriba.png");
				((JLabel) aBi[f][c]).setIcon(im);
				ImageIcon im2 = new ImageIcon("Imagenes\\Fondo.png");
				im2.setDescription("Imagenes\\Fondo.png");
				((JLabel) aBi[f+1][c]).setIcon(im2);
				cambiarPanel();
			}else if(((ImageIcon) ((JLabel) aBi[f-1][c]).getIcon()).getDescription().equalsIgnoreCase("Imagenes\\Pared.png")){
				break;
			}
			break;
		case KeyEvent.VK_DOWN:
			if(f<24 && (((ImageIcon) ((JLabel) aBi[f+1][c]).getIcon()).getDescription().equalsIgnoreCase("Imagenes\\Bolita.png"))||
					(((ImageIcon) ((JLabel) aBi[f+1][c]).getIcon()).getDescription().equalsIgnoreCase("Imagenes\\Fondo.png"))) {
				Object aux = aBi[f + 1][c];
				aBi[f + 1][c] = aBi[f][c];
				aBi[f][c] = aux;
				f++;
				ImageIcon im = new ImageIcon("Imagenes\\PacmanAbajo.png");
				im.setDescription("Imagenes\\PacmanAbajo.png");
				((JLabel) aBi[f][c]).setIcon(im);
				ImageIcon im2 = new ImageIcon("Imagenes\\Fondo.png");
				im2.setDescription("Imagenes\\Fondo.png");
				((JLabel) aBi[f-1][c]).setIcon(im2);
				cambiarPanel();		
			}else if(((ImageIcon) ((JLabel) aBi[f+1][c]).getIcon()).getDescription().equalsIgnoreCase("Imagenes\\Pared.png")){
				break;
			}
			break;
		}
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

//	public void run()  {
//
//		
//		double aux = Math.random();
//		if(aux>0 && aux <0.25) {
//			dir =1;//derecha
//		}else if( aux>0.25 && aux< 0.50) {
//			dir = 2;//izquierda
//		}else if( aux>0.50 && aux< 0.75) {
//			dir = 3;//arriba
//		}else if( aux>0.75 && aux< 1.0) {
//			dir = 4;//abajo
//		}
//
//		switch(dir) {
//
//		case 1:
//			while(!choque) {
//				if(c<24 && (((ImageIcon) ((JLabel) aBi[fInky][cInky+1]).getIcon()).getDescription().equalsIgnoreCase("Imagenes\\Bolita.png"))||
//						(((ImageIcon) ((JLabel) aBi[fInky][cInky+1]).getIcon()).getDescription().equalsIgnoreCase("Imagenes\\Fondo.png"))) {
//					Object aux2 = aBi[fInky][cInky + 1];
//					aBi[fInky][cInky + 1] = aBi[fInky][cInky];
//					aBi[fInky][cInky] = aux2;
//					cInky++;
//					ImageIcon im = new ImageIcon("Imagenes\\FantasmaAzul.png");
//					im.setDescription("Imagenes\\FantasmaAzul.png");
//					((JLabel) aBi[fInky][cInky]).setIcon(im);
//					cambiarPanel();
//
//				}else if(((ImageIcon) ((JLabel) aBi[fInky][cInky+1]).getIcon()).getDescription().equalsIgnoreCase("Imagenes\\Pared.png")){
//					choque = true;
//					break;
//					
//				}
//				
//			}
//			
//		case 2:
//			while(!choque) {
//				if(c<24 && (((ImageIcon) ((JLabel) aBi[fInky][cInky+1]).getIcon()).getDescription().equalsIgnoreCase("Imagenes\\Bolita.png"))||
//						(((ImageIcon) ((JLabel) aBi[fInky][cInky+1]).getIcon()).getDescription().equalsIgnoreCase("Imagenes\\Fondo.png"))) {
//					Object aux2 = aBi[fInky][cInky + 1];
//					aBi[fInky][cInky + 1] = aBi[fInky][cInky];
//					aBi[fInky][cInky] = aux2;
//					cInky++;
//					ImageIcon im = new ImageIcon("Imagenes\\FantasmaAzul.png");
//					im.setDescription("Imagenes\\FantasmaAzul.png");
//					((JLabel) aBi[fInky][cInky]).setIcon(im);
//					cambiarPanel();
//
//				}else if(((ImageIcon) ((JLabel) aBi[fInky][cInky+1]).getIcon()).getDescription().equalsIgnoreCase("Imagenes\\Pared.png")){
//					
//					break;
//				}
//				
//			}
//			
//
//		case 3:
//			break;
//
//		case 4:
//			break;
//		}
		
		/*No se ni lo que es pero igual en un futuro sirve de algo*/
		/*switch(dir) {
		case 1 : //mover hacia arriba
			//while
			if(pacman.getY()>1 && Icono.puedeAvanzar(dir,pacman.getX(),pacman.getY())== true && Icono.dentroTablero(pacman.getX(), pacman.getY())==true) {

				System.out.println("Entra al while caso 1");
				//poner la direccion del pacman cuando se mueve, tengo que hacer una excepcion para cada imgane en movimiento�	
				int cx = pacman.getX();
				int cy = pacman.getY();
				System.out.println(cx+" "+cy);
				//JLabel lblArriba = (JLabel)aBi[cx][cy-1];
				ImageIcon im = new ImageIcon("Imagenes\\Fondo.png");
				ImageIcon im2 = new ImageIcon("Imagenes\\PacmanConFondo.png");
				im2.setDescription("Imagenes\\PacmanConFondo");
				im.setDescription("Imagenes\\Fondo.png");
				((JLabel)aBi[cx-1][cy-1]).setIcon(im2);
				((JLabel)aBi[cx-1][cy-2]).setIcon(im);
				repaint();
				int y = pacman.getY() - 1;
				pacman.setY(y);
				for (int i = 0; i < aBi.length; i++) {			
					for (int j = 0; j < aBi[0].length; j++) {
						panelCentro.add((JLabel) aBi[i][j]);
					}
				}
				panelCentro.updateUI();


			}		
			break;
		case 2 :// mover hacia abajo
			if(pacman.getY()<560 && Icono.puedeAvanzar(dir,pacman.getX(),pacman.getY())== true && Icono.dentroTablero(pacman.getX(), pacman.getY())==true) {
				System.out.println("Entra al while caso 1");


				int cx = pacman.getX();
				int cy = pacman.getY();
				//JLabel lblArriba = (JLabel)aBi[cx][cy-1];
				ImageIcon im = new ImageIcon("Imagenes\\Fondo.png");
				ImageIcon im2 = new ImageIcon("Imagenes\\PacmanConFondo.png");
				im2.setDescription("Imagenes\\PacmanConFondo");
				im.setDescription("Imagenes\\Fondo.png");
				((JLabel)aBi[cx-1][cy-1]).setIcon(im2); //= new JLabel(im2);
				((JLabel)aBi[cx-1][cy]).setIcon(im); //= new JLabel(im);
				repaint();
				int y = pacman.getY()+1;
				pacman.setY(y);
				for (int i = 0; i < aBi.length; i++) {			
					for (int j = 0; j < aBi[0].length; j++) {
						panelCentro.add((JLabel) aBi[i][j]);
					}
				}
				panelCentro.updateUI();

			}
			break;
		case 3 : // mover hacia derecha
			if(pacman.getY()<560 && Icono.puedeAvanzar(dir,pacman.getX(),pacman.getY())== true && Icono.dentroTablero(pacman.getX(), pacman.getY())==true) {



				int cx = pacman.getX();
				int cy = pacman.getY();
				//JLabel lblArriba = (JLabel)aBi[cx][cy-1];
				ImageIcon im = new ImageIcon("Imagenes\\Fondo.png");
				ImageIcon im2 = new ImageIcon("Imagenes\\PacmanConFondo.png");
				im2.setDescription("Imagenes\\PacmanConFondo");
				im.setDescription("Imagenes\\Fondo.png");
				((JLabel)aBi[cx-1][cy-1]).setIcon(im2);// = new JLabel(im2);
				((JLabel)aBi[cx-2][cy-1]).setIcon(im);// = new JLabel(im);
				int x = pacman.getX()+1;
				pacman.setX(x);
				for (int i = 0; i < aBi.length; i++) {			
					for (int j = 0; j < aBi[0].length; j++) {
						panelCentro.add((JLabel) aBi[i][j]);
					}
				}
				panelCentro.updateUI();

			}
			break;
		case 4: // mover hacia izquierda
			if(pacman.getY()<560 && Icono.puedeAvanzar(dir,pacman.getX(),pacman.getY())== true && Icono.dentroTablero(pacman.getX(), pacman.getY())==true) {


				int cx = pacman.getX();
				int cy = pacman.getY();
				//JLabel lblArriba = (JLabel)aBi[cx][cy-1];
				ImageIcon im = new ImageIcon("Imagenes\\Fondo.png");
				ImageIcon im2 = new ImageIcon("Imagenes\\PacmanConFondo.png");
				im2.setDescription("Imagenes\\PacmanConFondo");
				im.setDescription("Imagenes\\Fondo.png");
				((JLabel)aBi[cx-1][cy-1]).setIcon(im2);// = new JLabel(im2);
				((JLabel)aBi[cx][cy-1]).setIcon(im);// = new JLabel(im);
				int x= pacman.getX() -1;
				pacman.setX(x);			
				for (int i = 0; i < aBi.length; i++) {			
					for (int j = 0; j < aBi[0].length; j++) {
						panelCentro.add((JLabel) aBi[i][j]);
					}
				}
				panelCentro.updateUI();

			}
			break;
		}*/

	}


//}