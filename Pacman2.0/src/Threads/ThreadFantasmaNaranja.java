package Threads;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Ventanas.VentanaNivel;

public class ThreadFantasmaNaranja extends Thread {

	public ThreadFantasmaNaranja() {

		boolean choque=false;

		// TODO Auto-generated constructor stub
		double aux = Math.random();
		int dir=0;
		if(aux>0 && aux <0.25) {
			dir =1;//derecha
		}else if( aux>0.25 && aux< 0.50) {
			dir = 2;//izquierda
		}else if( aux>0.50 && aux< 0.75) {
			dir = 3;//arriba
		}else if( aux>0.75 && aux< 1.0) {
			dir = 4;//abajo
		}

		switch(dir) {

		case 1:
			while(!choque) {
				if(VentanaNivel.c<24 && (((ImageIcon) ((JLabel) VentanaNivel.aBi[VentanaNivel.fClyde][VentanaNivel.cClyde+1]).getIcon()).getDescription().equalsIgnoreCase("Imagenes\\Bolita.png"))||
						(((ImageIcon) ((JLabel) VentanaNivel.aBi[VentanaNivel.fClyde][VentanaNivel.cClyde+1]).getIcon()).getDescription().equalsIgnoreCase("Imagenes\\Fondo.png"))) {
					Object aux2 = VentanaNivel.aBi[VentanaNivel.fClyde][VentanaNivel.cClyde + 1];
					VentanaNivel.aBi[VentanaNivel.fClyde][VentanaNivel.cClyde + 1] = VentanaNivel.aBi[VentanaNivel.fClyde][VentanaNivel.cClyde];
					VentanaNivel.aBi[VentanaNivel.fClyde][VentanaNivel.cClyde] = aux2;
					VentanaNivel.cClyde++;
					ImageIcon im = new ImageIcon("Imagenes\\FantasmaNaranja.png");
					im.setDescription("Imagenes\\FantasmaNaranja.png");
					((JLabel) VentanaNivel.aBi[VentanaNivel.fClyde][VentanaNivel.cClyde]).setIcon(im);
					//	VentanaNivel.cambiarPanel();//llamar desde el run no es posible estatic
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					

				}else if(((ImageIcon) ((JLabel) VentanaNivel.aBi[VentanaNivel.fClyde][VentanaNivel.cClyde+1]).getIcon()).getDescription().equalsIgnoreCase("Imagenes\\Pared.png")){
					choque = true;
					break;

				}
				
				
			}





		case 2:
			while(!choque) {
				if(VentanaNivel.c<24 && (((ImageIcon) ((JLabel) VentanaNivel.aBi[VentanaNivel.fClyde][VentanaNivel.cClyde-1]).getIcon()).getDescription().equalsIgnoreCase("Imagenes\\Bolita.png"))||
						(((ImageIcon) ((JLabel) VentanaNivel.aBi[VentanaNivel.fClyde][VentanaNivel.cClyde-1]).getIcon()).getDescription().equalsIgnoreCase("Imagenes\\Fondo.png"))) {
					Object aux2 = VentanaNivel.aBi[VentanaNivel.fClyde][VentanaNivel.cClyde- 1];

					VentanaNivel.aBi[VentanaNivel.fClyde][VentanaNivel.cClyde -1] = VentanaNivel.aBi[VentanaNivel.fClyde][VentanaNivel.cClyde];
					VentanaNivel.aBi[VentanaNivel.fClyde][VentanaNivel.cClyde] = aux2;
					VentanaNivel.cClyde--;
					ImageIcon im = new ImageIcon("Imagenes\\FantasmaNaranja.png");
					im.setDescription("Imagenes\\FantasmaNaranja.png");
					((JLabel) VentanaNivel.aBi[VentanaNivel.fClyde][VentanaNivel.cClyde]).setIcon(im);
					//VentanaNivel.cambiarPanel();//llamar desde el run no es posible estatic
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					

				}else if(((ImageIcon) ((JLabel) VentanaNivel.aBi[VentanaNivel.fClyde][VentanaNivel.cClyde-1]).getIcon()).getDescription().equalsIgnoreCase("Imagenes\\Pared.png")){
					choque = true;
					break;

				}
				
			}




		case 3:
			while(!choque) {
				if(VentanaNivel.c<24 && (((ImageIcon) ((JLabel) VentanaNivel.aBi[VentanaNivel.fClyde-1][VentanaNivel.cClyde]).getIcon()).getDescription().equalsIgnoreCase("Imagenes\\Bolita.png"))||
						(((ImageIcon) ((JLabel) VentanaNivel.aBi[VentanaNivel.fClyde-1][VentanaNivel.cClyde]).getIcon()).getDescription().equalsIgnoreCase("Imagenes\\Fondo.png"))) {
					Object aux2 = VentanaNivel.aBi[VentanaNivel.fClyde-1][VentanaNivel.cClyde];
					VentanaNivel.aBi[VentanaNivel.fClyde-1][VentanaNivel.cClyde] = VentanaNivel.aBi[VentanaNivel.fClyde][VentanaNivel.cClyde];
					VentanaNivel.aBi[VentanaNivel.fClyde][VentanaNivel.cClyde] = aux2;
					VentanaNivel.fClyde--;
					ImageIcon im = new ImageIcon("Imagenes\\FantasmaNaranja.png");
					im.setDescription("Imagenes\\FantasmaNaranja.png");
					((JLabel) VentanaNivel.aBi[VentanaNivel.fClyde][VentanaNivel.cClyde]).setIcon(im);
					//VentanaNivel.cambiarPanel();//llamar desde el run no es posible estatic
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					

				}else if(((ImageIcon) ((JLabel) VentanaNivel.aBi[VentanaNivel.fClyde-1][VentanaNivel.cClyde]).getIcon()).getDescription().equalsIgnoreCase("Imagenes\\Pared.png")){
					choque = true;
					break;

				}
			}


		case 4:
			while(!choque) {
				if(VentanaNivel.c<24 && (((ImageIcon) ((JLabel) VentanaNivel.aBi[VentanaNivel.fClyde+1][VentanaNivel.cClyde]).getIcon()).getDescription().equalsIgnoreCase("Imagenes\\Bolita.png"))||
						(((ImageIcon) ((JLabel) VentanaNivel.aBi[VentanaNivel.fClyde+1][VentanaNivel.cClyde]).getIcon()).getDescription().equalsIgnoreCase("Imagenes\\Fondo.png"))) {
					Object aux2 = VentanaNivel.aBi[VentanaNivel.fClyde+1][VentanaNivel.cClyde];
					VentanaNivel.aBi[VentanaNivel.fClyde+1][VentanaNivel.cClyde ] = VentanaNivel.aBi[VentanaNivel.fClyde][VentanaNivel.cClyde];
					VentanaNivel.aBi[VentanaNivel.fClyde][VentanaNivel.cClyde] = aux2;
					VentanaNivel.fClyde++;
					ImageIcon im = new ImageIcon("Imagenes\\FantasmaNaranja.png");
					im.setDescription("Imagenes\\FantasmaNaranja.png");
					((JLabel) VentanaNivel.aBi[VentanaNivel.fClyde][VentanaNivel.cClyde]).setIcon(im);
					//VentanaNivel.cambiarPanel();//llamar desde el run no es posible estatic
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					

				}else if(((ImageIcon) ((JLabel) VentanaNivel.aBi[VentanaNivel.fClyde+1][VentanaNivel.cClyde]).getIcon()).getDescription().equalsIgnoreCase("Imagenes\\Pared.png")){
					choque = true;
					break;

				}
				
			}

		}


	}

}

