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
import java.awt.event.KeyListener;

public class VentanaNivel extends JFrame implements Runnable, KeyListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane, panelNorte, panelSur, panelCentro;
	public static Object aBi[][];

	public int columnas, filas;
	Pacman pacman = new Pacman();
	Fantasmas fantasma = new Fantasmas();
	int dir, f, c;

	public VentanaNivel(Object aBi[][]) {
		

		VentanaNivel.aBi = aBi;
		addKeyListener(this);
		System.out.println(VentanaNivel.aBi.length);
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
				if(!im.getDescription().equals("Imagenes\\PacmanConFondo.png") && !im.getDescription().equals("Imagenes\\Pared.png") ){
					ImageIcon im2 = new ImageIcon("Imagenes\\Bolita.png");
					im2.setDescription("Imagenes\\Bolita.png");
					((JLabel)aBi[i][j]).setIcon(im2);
										
				}
				
				panelCentro.add((JLabel) aBi[i][j]);
				System.out.println(((ImageIcon) ((JLabel) aBi[i][j]).getIcon()).getDescription());
				if (((ImageIcon) ((JLabel) aBi[i][j]).getIcon()).getDescription()
						.equalsIgnoreCase("Imagenes\\PacmanConFondo.png")) {
					System.out.println("HE ENCONTRADO EL Pacman.");
					
					f = i;
					c = j;
					
				}
			}
			setVisible(true);
		}
		System.out.println("El pacman está en " + f + "-" + c);
		

		/*for (int i = 0; i < aBi.length; i++) {			
			for (int j = 0; j < aBi[0].length; j++) {
				panelCentro.add((JLabel) aBi[i][j]);
				
//				ImageIcon im2 = new ImageIcon("Imagenes\\Bolita.png");
//				im2.setDescription("Imagenes\\Bolita.png");
//				JLabel lblFoto = new JLabel(im2);
//				panelCentro.add(lblFoto);
				
			
				
				JLabel l = (JLabel)aBi[i][j];
				ImageIcon im = (ImageIcon)l.getIcon();
				
				if(im.getDescription().equals("Imagenes\\PacmanConFondo.png")){
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
		Icono.hayPared(aBi);
		this.addKeyListener(this);
		System.out.println(pacman.getX());
		System.out.println(pacman.getY());
		//t.start();*/
		
		
	}
	public void generarBolitas() {
		
		for (int i = 0; i < aBi.length; i++) {			
			for (int j = 0; j < aBi[0].length; j++) {
				
				//poner bolita encima del Jlabel
				
				
				
			}
		}
		
/*		Tablero.inicializarBolitas();
//		boolean aPosicionesBolitas[][] = new boolean[ALTURA_ARRAY][ANCHURA_ARRAY];
//		int i, j;
//		//int posXBolita = 0,posYBolita = 0 ;
//		for (j = 0; j < aPosicionesBolitas.length; j++) {
//			for (i = 0; i < aPosicionesBolitas[0].length; i++) {
//				if (Tablero.posicionesGenerarBolitas(i, j)) {
//					imagenBolita = new ImageIcon(getClass().getResource("/imagenes/Bolita.png"));
//					lblBolita = new JLabel(imagenBolita);
//					panelFondo.add(lblBolita);
//					posXBolita = ((i * 28) + 12);
//					posYBolita = ((j * 28) + 12);
//					lblBolita.setBounds(posXBolita, posYBolita , 28, 28);
//					
//				}
//			}
//		}*/
	}
	
	public void comeBolita(Object abi) {
		
		
		
		
	}
	
	
	public void cambiarPanel() {
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
			//no funciona el run, crashea por que no detecta nada en el array al mover el pacman.
			//en teoria si que hay datos cargados en el array pero no detecta.
			//se incializa el array en la clase ventanaNivel.
			/*System.out.println("arriba");
			dir = 1;
			run();*/
			if(c<24) {
				Object aux = aBi[f][c + 1];
				aBi[f][c + 1] = aBi[f][c];
				aBi[f][c] = aux;
				c++;
				ImageIcon im = new ImageIcon("Imagenes\\PacmanConFondo.png");
				im.setDescription("Imagenes\\PacmanConFondo.png");
				((JLabel) aBi[f][c]).setIcon(im);
				cambiarPanel();
			}
			
			break;	
		case KeyEvent.VK_LEFT:	
			/*System.out.println("abajo");
			dir = 2;
			run();*/
			if(c>0) {
				Object aux = aBi[f][c - 1];
				aBi[f][c - 1] = aBi[f][c];
				aBi[f][c] = aux;
				c--;
				ImageIcon im = new ImageIcon("Imagenes\\PacmanIzquierda.png");
				im.setDescription("Imagenes\\PacmanIzquierda.png");
				((JLabel) aBi[f][c]).setIcon(im);
				cambiarPanel();
			}
			break;
		case KeyEvent.VK_UP :
			/*System.out.println("derecha");
			dir = 3;
			run();	*/	
			if(f>=0) {
				Object aux = aBi[f - 1][c];
				aBi[f -1][c] = aBi[f][c];
				aBi[f][c] = aux;
				f--;
				ImageIcon im = new ImageIcon("Imagenes\\PacmanArriba.png");
				im.setDescription("Imagenes\\PacmanArriba.png");
				((JLabel) aBi[f][c]).setIcon(im);
				cambiarPanel();
			}
			break;
		case KeyEvent.VK_DOWN:	
			/*System.out.println("izquierda");
			dir = 4;
			run();*/
			if(f<24) {
				Object aux = aBi[f + 1][c];
				aBi[f + 1][c] = aBi[f][c];
				aBi[f][c] = aux;
				f++;
				ImageIcon im = new ImageIcon("Imagenes\\PacmanAbajo.png");
				im.setDescription("Imagenes\\PacmanAbajo.png");
				((JLabel) aBi[f][c]).setIcon(im);
				cambiarPanel();		
			}
			break;
		}
	}

	public void run() {

		switch(dir) {
		case 1 : //mover hacia arriba
			//while
			if(pacman.getY()>1 && Icono.puedeAvanzar(dir,pacman.getX(),pacman.getY())== true && Icono.dentroTablero(pacman.getX(), pacman.getY())==true) {
				
				System.out.println("Entra al while caso 1");
				//poner la direccion del pacman cuando se mueve, tengo que hacer una excepcion para cada imgane en movimientoç	
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
		}
		
	}
	

}