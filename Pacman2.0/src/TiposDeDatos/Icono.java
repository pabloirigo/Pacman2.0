package TiposDeDatos;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;

import Ventanas.VentanaNivel;

public class Icono  {

	public static boolean paredes[][];


	public Icono(){


	}
	public static boolean hayPared(int dir,Object aBi[][], int x, int y) {
		/** dir:1 arriba 
		 * 		2 abajo
		 * 		3 derecha
		 * 		4 izquierda
		 */
		boolean haypared = false;			
		for (int i = 0; i < aBi.length; i++) {			
			for (int j = 0; j < aBi[0].length; j++) {
				JLabel l = (JLabel)aBi[i][j];
				ImageIcon im = (ImageIcon)l.getIcon();
				paredes[i][j]=false;
				if(im.getDescription().equals("Imagenes\\Pared.png")) {
					paredes[i][j]=true;
				}
			}
		}
		switch(dir) {
		case 1: if(paredes[x][y-1]==true ) {
			haypared =true;
		}

		case 2 : if(paredes[x][y+1]==true) {
			haypared = true;
		}
		case 3 :if(paredes[x+1][y]==true){
			haypared= true;

		}
		case 4: if(paredes[x-1][y]== true) {
			haypared= true;


		}
		}

		return haypared;
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

