package Threads;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Ventanas.VentanaNivel;

public class ThreadFantasmaRojo extends Thread{

	public ThreadFantasmaRojo()  {
		super();

	}
	public void run() {
		while (true) {
			boolean choque= false;
			 //Mientras no se lo haya comido el pacman // falta poner la condicion de que se lo haya comido el pacman
				
				// TODO Auto-generated constructor stub
				double aux = Math.random();
				int dir=0;
				int dx = 0;
				int dy=0;
				int aux3 =0 ;
				if(aux>0 && aux <0.25) {			
					dir =1;//derecha
					dy = 1;
					aux3 =1;				
				}else if( aux>0.25 && aux< 0.50) {
					dir = 2;//izquierda
					dy = -1;
					aux3 =-1;
				}else if( aux>0.50 && aux< 0.75) {
					dir = 3;//arriba
					dx = -1;
					aux3 =-1;
				}else if( aux>0.75 && aux< 1.0) {
					dir = 4;//abajo
					dx = 1;
					aux3 =1;
				}
				while(!choque) {
				if(VentanaNivel.cBlinky<24 && (((ImageIcon) ((JLabel) VentanaNivel.aBi[VentanaNivel.fBlinky+dx][VentanaNivel.cBlinky+ dy]).getIcon()).getDescription().equalsIgnoreCase("Imagenes\\Bolita.png"))||
						(((ImageIcon) ((JLabel) VentanaNivel.aBi[VentanaNivel.fBlinky+dx][VentanaNivel.cBlinky+ dy]).getIcon()).getDescription().equalsIgnoreCase("Imagenes\\Fondo.png"))) {
					
					Icon aux2 = ((JLabel)VentanaNivel.aBi[VentanaNivel.fBlinky+ dx][VentanaNivel.cBlinky + dy]).getIcon();
					Icon aux1 = ((JLabel)VentanaNivel.aBi[VentanaNivel.fBlinky][VentanaNivel.cBlinky]).getIcon();
					((JLabel)VentanaNivel.aBi[VentanaNivel.fBlinky+ dx][VentanaNivel.cBlinky + dy]).setIcon(aux1);
					((JLabel)VentanaNivel.aBi[VentanaNivel.fBlinky][VentanaNivel.cBlinky]).setIcon(aux2);
					if(dir== 1) {
						VentanaNivel.cBlinky = VentanaNivel.cBlinky + aux3;
					}else if(dir == 2) {
						VentanaNivel.cBlinky = VentanaNivel.cBlinky + aux3;
					}else if(dir == 3) {
						VentanaNivel.fBlinky = VentanaNivel.fBlinky + aux3;
					}else if(dir == 4) {
						VentanaNivel.fBlinky = VentanaNivel.fBlinky + aux3;
					}
					
					
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					

				}else if( VentanaNivel.cBlinky<24 && ((ImageIcon) ((JLabel) VentanaNivel.aBi[VentanaNivel.fBlinky][VentanaNivel.cBlinky+1]).getIcon()).getDescription().equalsIgnoreCase("Imagenes\\Pared.png")){
					choque = true;
					break;					
				}else
					choque  = true;
				}
			}


		}

	}

