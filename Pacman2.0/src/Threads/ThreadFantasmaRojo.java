package Threads;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Ventanas.VentanaNivel;

public class ThreadFantasmaRojo extends Thread{

	public ThreadFantasmaRojo() {
		// TODO Auto-generated constructor stub
boolean choque= false;
		
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
				if(VentanaNivel.c<24 && (((ImageIcon) ((JLabel) VentanaNivel.aBi[VentanaNivel.fBlinky][VentanaNivel.cBlinky+1]).getIcon()).getDescription().equalsIgnoreCase("Imagenes\\Bolita.png"))||
						(((ImageIcon) ((JLabel) VentanaNivel.aBi[VentanaNivel.fBlinky][VentanaNivel.cBlinky+1]).getIcon()).getDescription().equalsIgnoreCase("Imagenes\\Fondo.png"))) {
					Object aux2 = VentanaNivel.aBi[VentanaNivel.fBlinky][VentanaNivel.cBlinky + 1];
					VentanaNivel.aBi[VentanaNivel.fBlinky][VentanaNivel.cBlinky + 1] = VentanaNivel.aBi[VentanaNivel.fBlinky][VentanaNivel.cBlinky];
					VentanaNivel.aBi[VentanaNivel.fBlinky][VentanaNivel.cBlinky] = aux2;
					VentanaNivel.cBlinky++;
					ImageIcon im = new ImageIcon("Imagenes\\FantasmaRojo.png");
					im.setDescription("Imagenes\\FantasmaRojo.png");
					((JLabel) VentanaNivel.aBi[VentanaNivel.fBlinky][VentanaNivel.cBlinky]).setIcon(im);
					//VentanaNivel.cambiarPanel();//llamar desde el run no es posible estatic
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					

				}else if(((ImageIcon) ((JLabel) VentanaNivel.aBi[VentanaNivel.fBlinky][VentanaNivel.cBlinky+1]).getIcon()).getDescription().equalsIgnoreCase("Imagenes\\Pared.png")){
					choque = true;
					break;
					
				}
				
			}





		case 2:
			while(!choque) {
				if(VentanaNivel.c<24 && (((ImageIcon) ((JLabel) VentanaNivel.aBi[VentanaNivel.fBlinky][VentanaNivel.cBlinky-1]).getIcon()).getDescription().equalsIgnoreCase("Imagenes\\Bolita.png"))||
						(((ImageIcon) ((JLabel) VentanaNivel.aBi[VentanaNivel.fBlinky][VentanaNivel.cBlinky-1]).getIcon()).getDescription().equalsIgnoreCase("Imagenes\\Fondo.png"))) {
					Object aux2 = VentanaNivel.aBi[VentanaNivel.fBlinky][VentanaNivel.cBlinky - 1];
					VentanaNivel.aBi[VentanaNivel.fBlinky][VentanaNivel.cBlinky -1] = VentanaNivel.aBi[VentanaNivel.fBlinky][VentanaNivel.cBlinky];
					VentanaNivel.aBi[VentanaNivel.fBlinky][VentanaNivel.cBlinky] = aux2;
					VentanaNivel.cBlinky--;
					ImageIcon im = new ImageIcon("Imagenes\\FantasmaRojo.png");
					im.setDescription("Imagenes\\FantasmaRojo.png");
					((JLabel) VentanaNivel.aBi[VentanaNivel.fBlinky][VentanaNivel.cBlinky]).setIcon(im);
				//	VentanaNivel.cambiarPanel();//llamar desde el run no es posible estatic
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					

				}else if(((ImageIcon) ((JLabel) VentanaNivel.aBi[VentanaNivel.fBlinky][VentanaNivel.cBlinky-1]).getIcon()).getDescription().equalsIgnoreCase("Imagenes\\Pared.png")){
					choque = true;
					break;
					
				}
				
			}
			
			
			

		case 3:
			while(!choque) {
				if(VentanaNivel.c<24 && (((ImageIcon) ((JLabel) VentanaNivel.aBi[VentanaNivel.fBlinky-1][VentanaNivel.cBlinky]).getIcon()).getDescription().equalsIgnoreCase("Imagenes\\Bolita.png"))||
						(((ImageIcon) ((JLabel) VentanaNivel.aBi[VentanaNivel.fBlinky-1][VentanaNivel.cBlinky]).getIcon()).getDescription().equalsIgnoreCase("Imagenes\\Fondo.png"))) {
					Object aux2 = VentanaNivel.aBi[VentanaNivel.fBlinky-1][VentanaNivel.cBlinky];
					VentanaNivel.aBi[VentanaNivel.fBlinky-1][VentanaNivel.cBlinky] = VentanaNivel.aBi[VentanaNivel.fBlinky][VentanaNivel.cBlinky];
					VentanaNivel.aBi[VentanaNivel.fBlinky][VentanaNivel.cBlinky] = aux2;
					VentanaNivel.fBlinky--;
					ImageIcon im = new ImageIcon("Imagenes\\FantasmaRojo.png");
					im.setDescription("Imagenes\\FantasmaRojo.png");
					((JLabel) VentanaNivel.aBi[VentanaNivel.fBlinky][VentanaNivel.cBlinky]).setIcon(im);
				//	VentanaNivel.cambiarPanel();//llamar desde el run no es posible estatic
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					

				}else if(((ImageIcon) ((JLabel) VentanaNivel.aBi[VentanaNivel.fBlinky-1][VentanaNivel.cBlinky]).getIcon()).getDescription().equalsIgnoreCase("Imagenes\\Pared.png")){
					choque = true;
					break;
					
				}
				
			}
			

		case 4:
			while(!choque) {
				if(VentanaNivel.c<24 && (((ImageIcon) ((JLabel) VentanaNivel.aBi[VentanaNivel.fBlinky+1][VentanaNivel.cBlinky]).getIcon()).getDescription().equalsIgnoreCase("Imagenes\\Bolita.png"))||
						(((ImageIcon) ((JLabel) VentanaNivel.aBi[VentanaNivel.fBlinky+1][VentanaNivel.cBlinky]).getIcon()).getDescription().equalsIgnoreCase("Imagenes\\Fondo.png"))) {
					Object aux2 = VentanaNivel.aBi[VentanaNivel.fBlinky+1][VentanaNivel.cBlinky];
					VentanaNivel.aBi[VentanaNivel.fBlinky+1][VentanaNivel.cBlinky] = VentanaNivel.aBi[VentanaNivel.fBlinky][VentanaNivel.cBlinky];
					VentanaNivel.aBi[VentanaNivel.fBlinky][VentanaNivel.cBlinky] = aux2;
					VentanaNivel.fBlinky++;
					ImageIcon im = new ImageIcon("Imagenes\\FantasmaRojo.png");
					im.setDescription("Imagenes\\FantasmaRojo.png");
					((JLabel) VentanaNivel.aBi[VentanaNivel.fBlinky][VentanaNivel.cBlinky]).setIcon(im);
					//VentanaNivel.cambiarPanel();//llamar desde el run no es posible estatic
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					

				}else if(((ImageIcon) ((JLabel) VentanaNivel.aBi[VentanaNivel.fBlinky+1][VentanaNivel.cBlinky]).getIcon()).getDescription().equalsIgnoreCase("Imagenes\\Pared.png")){
					choque = true;
					break;
					
				}
				
			}
			
		}
	}

}
