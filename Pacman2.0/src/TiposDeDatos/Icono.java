package TiposDeDatos;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;

import Ventanas.VentanaNivel;

public class Icono  {

	public static boolean obstaculo[][];
	public static boolean pared[][];
	


	public Icono() {
		 

	}

	public static void hayPared(Object aBi[][]) {
		pared = new boolean[25][25];
		for (int i = 0; i < aBi.length; i++) {			
			for (int j = 0; j < aBi[0].length; j++) {
				JLabel l = (JLabel)aBi[i][j];
				ImageIcon im = (ImageIcon)l.getIcon();
				if(im.getDescription().equals("Imagenes\\Pared.png"))
					pared[i][j]=true;	
			}
		}
	}

	public static boolean puedeAvanzar(int dir,int x, int y) {

		/** dir:1 arriba 
		 * 		2 abajo
		 * 		3 derecha
		 * 		4 izquierda
		 */

		switch(dir) {
		case 1: if(y==0)
			return false;
		if(Icono.pared[x][y-1]==true ) {
			return false;
		}
		case 2 :if(y==550)
			return false;
		if(Icono.pared[x][y+1]==true) {
			return false;
		}
		case 3 :if(x==560)
			return false;
		if(Icono.pared[x+1][y]==true){
			return false;
		}
		case 4: if(x==0)
			return false;
		if(Icono.pared[x-1][y]== true) {
			return false;

		}

		}
		return true;


		//		boolean hayObstaculo = false;			
		//		for (int i = 0; i < aBi.length; i++) {			
		//			for (int j = 0; j < aBi[0].length; j++) {
		//				JLabel l = (JLabel)aBi[i][j];
		//				ImageIcon im = (ImageIcon)l.getIcon();
		//				obstaculo[i][j]= false;
		//				if(!im.getDescription().equals("Imagenes\\Fondo.png")) { //.????? nulll queda la excepcion de los fantasmas
		//					obstaculo[i][j]=true;
		//				}
		//
		//			}
		//		}
		//		switch(dir) {
		//		case 1: if(obstaculo[x][y+1]==true ) {
		//			hayObstaculo =true;
		//		}
		//		case 2 : if(obstaculo[x][y-1]==true) {
		//			hayObstaculo = true;
		//		}
		//		case 3 :if(obstaculo[x+1][y]==true){
		//			hayObstaculo= true;
		//		}
		//		case 4: if(obstaculo[x-1][y]== true) {
		//			hayObstaculo= true;
		//
		//		}
		//		}
		//		return hayObstaculo;
	}
	public static boolean dentroTablero(int x, int y) {
		// no es seguro que las dimensiones del panelCentro son estas, REVISAR!
		if(x > 560 || x <1 || y < 1 || y > 550) {
			return false;
		}
		else {
			return true;

		}
	}
	public static boolean comeBolita(int x, int y) {
		






		return false;
	}

	public static void actualizarBolitas(Object aBi[][]) {
		
		for (int i = 0; i < aBi.length; i++) {			
			for (int j = 0; j < aBi[0].length; j++) {
				
				

			}


		}
	}
}

