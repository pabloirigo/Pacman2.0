package TiposDeDatos;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;

import Ventanas.VentanaNivel;

public class Icono  {

	public static boolean obstaculo[][];


	public Icono() {

	}
	public static boolean hayObstaculo(int dir,Object aBi[][], int x, int y) {
		/** dir:1 arriba 
		 * 		2 abajo
		 * 		3 derecha
		 * 		4 izquierda
		 */
		boolean hayObstaculo = false;			
		for (int i = 0; i < aBi.length; i++) {			
			for (int j = 0; j < aBi[0].length; j++) {
				JLabel l = (JLabel)aBi[i][j];
				ImageIcon im = (ImageIcon)l.getIcon();
				if(im.getDescription().equals("Imagenes\\Fondo.png")) { //.notequals?
					obstaculo[i][j]=false;
				}
				else {
					obstaculo[i][j]= true;
				}
			}
		}
		switch(dir) {
		case 1: if(obstaculo[x][y-1]==true ) {
			hayObstaculo =true;
		}
		case 2 : if(obstaculo[x][y+1]==true) {
			hayObstaculo = true;
		}
		case 3 :if(obstaculo[x+1][y]==true){
			hayObstaculo= true;
		}
		case 4: if(obstaculo[x-1][y]== true) {
			hayObstaculo= true;
		}
		}
		return hayObstaculo;
	}
	public static boolean dentroTablero(int x, int y) {
		// no es seguro que las dimensiones del panelCentro son estas, REVISAR!
		if(x > 560 || x <1 || y < 1 || y < 550) {
			return false;
		}
		else {
			return true;

		}
	}

}

