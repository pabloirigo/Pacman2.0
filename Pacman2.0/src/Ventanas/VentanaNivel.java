package Ventanas;

import java.awt.BorderLayout;

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

public class VentanaNivel extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane, panelNorte, panelSur, panelCentro;
	public static Object aBi[][];
	
	public int columnas, filas;
	Pacman pacman = new Pacman();
	Fantasmas fantasma = new Fantasmas();
	
	




	/**
	 * Create the frame.
	 */
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
	}


	public void keyPressed(KeyEvent e ) {

		// TODO Auto-generated method stub
		/**pregunta: donde poner el movimiento? pacman o icono? o nivel? movimiento el mismo, 
		 * pero cada uno tiene su inteligencia
		 * 
		 * keypressed en la ventananiveeel, 
		 * 
		 * while movimiento continuo.
		 * 

		 **/
		int keyCode = e.getKeyCode();
		Pacman pacman = new Pacman();
		MiThread t = new MiThread();
		

		switch( keyCode ) {

		case KeyEvent.VK_UP:						
			t.run(1,aBi,pacman.getX(), pacman.getY());
			break;	
		case KeyEvent.VK_DOWN:						
			t.run(2,aBi,pacman.getX(), pacman.getY());
			break;
		case KeyEvent.VK_RIGHT :			
			t.run(3,aBi,pacman.getX(), pacman.getY());			
			break;
		case KeyEvent.VK_LEFT:			
			t.run( 4,aBi,pacman.getX(), pacman.getY());
			break;
		}
	}

}
class MiThread extends Thread {

	public void run(int dir,Object aBi[][], int x, int y) {

	//	VentanaNivel.aBi = aBi;
		Icono icono = new Icono(); 
		Pacman pacman = new Pacman();
		
	
		switch(dir) {
		case 1 : //mover hacia arriba
			
			while(icono.hayPared(dir,aBi,x,y)==false) {
			x = x+10;
			pacman.setX(x);			
			
			}		
			break;

		case 2 :// mover hacia abajo
			
			while(icono.hayPared(dir,aBi,x, y)== false) {
			x = x - 10;	
			pacman.setX(x);
			}
			
			break;

		case 3 : // mover hacia derecha
			while(icono.hayPared(dir,aBi,x, y)==false) {
			y = y+10;
			pacman.setY(y);
			
			}
			break;

		case 4: // mover hacia izquierda
			while(icono.hayPared(dir,aBi,x, y)==false) {
			y = y-10;
			pacman.setY(y);			
			}
			break;

		}
	}


}