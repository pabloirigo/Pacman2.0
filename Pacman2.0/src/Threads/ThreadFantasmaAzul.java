package Threads;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Ventanas.VentanaNivel;

public class ThreadFantasmaAzul extends Thread{

	public ThreadFantasmaAzul()  {
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
			//int dz = 0;
			if(aux>0 && aux <0.25) {			
				dir =1;//derecha
				dy = 1;
				aux3 =1;	
				//dz = 24;
			}else if( aux>0.25 && aux< 0.50) {
				dir = 2;//izquierda
				dy = -1;
				aux3 =-1;
				//dz = 0;
			}else if( aux>0.50 && aux< 0.75) {
				dir = 3;//arriba
				dx = -1;
				aux3 =-1;
				//dz = 0;
			}else if( aux>0.75 && aux< 1.0) {
				dir = 4;//abajo
				dx = 1;
				aux3 =1;
				//dz = 24;
			}
			while(!choque) {
				
//				 if(VentanaNivel.cInky == 23 || VentanaNivel.cInky ==1 || VentanaNivel.fInky == 1||VentanaNivel.fInky ==23) {
//					 // si la poscion del fantasma es 1 just antes de llegar al brode, avanza 1 y sale del blucle para coger nueva dir{
//					 	Icon aux2 = ((JLabel)VentanaNivel.aBi[VentanaNivel.fInky+ dx][VentanaNivel.cInky + dy]).getIcon();
//						Icon aux1 = ((JLabel)VentanaNivel.aBi[VentanaNivel.fInky][VentanaNivel.cInky]).getIcon();
//						((JLabel)VentanaNivel.aBi[VentanaNivel.fInky+ dx][VentanaNivel.cInky + dy]).setIcon(aux1);
//						((JLabel)VentanaNivel.aBi[VentanaNivel.fInky][VentanaNivel.cInky]).setIcon(aux2);
//						if(dir== 1) {
//							VentanaNivel.cInky = VentanaNivel.cInky + aux3;
//						}else if(dir == 2) {
//							VentanaNivel.cInky = VentanaNivel.cInky + aux3;
//						}else if(dir == 3) {
//							VentanaNivel.fInky = VentanaNivel.fInky + aux3;
//						}else if(dir == 4) {
//							VentanaNivel.fInky = VentanaNivel.fInky + aux3;
//						}						
//					}
			if(VentanaNivel.cInky < 24 && VentanaNivel.cInky > 0 && VentanaNivel.fInky >0 && VentanaNivel.fInky < 24 && 
					(((ImageIcon) ((JLabel) VentanaNivel.aBi[VentanaNivel.fInky+dx][VentanaNivel.cInky+ dy]).getIcon()).getDescription().equalsIgnoreCase("Imagenes\\Bolita.png"))||
					(((ImageIcon) ((JLabel) VentanaNivel.aBi[VentanaNivel.fInky+dx][VentanaNivel.cInky+ dy]).getIcon()).getDescription().equalsIgnoreCase("Imagenes\\Fondo.png"))) {
					Icon aux2 = ((JLabel)VentanaNivel.aBi[VentanaNivel.fInky+ dx][VentanaNivel.cInky + dy]).getIcon();
				Icon aux1 = ((JLabel)VentanaNivel.aBi[VentanaNivel.fInky][VentanaNivel.cInky]).getIcon();
				((JLabel)VentanaNivel.aBi[VentanaNivel.fInky+ dx][VentanaNivel.cInky + dy]).setIcon(aux1);
				((JLabel)VentanaNivel.aBi[VentanaNivel.fInky][VentanaNivel.cInky]).setIcon(aux2);
				if(dir== 1) {
					VentanaNivel.cInky = VentanaNivel.cInky + aux3;
				}else if(dir == 2) {
					VentanaNivel.cInky = VentanaNivel.cInky + aux3;
				}else if(dir == 3) {
					VentanaNivel.fInky = VentanaNivel.fInky + aux3;
				}else if(dir == 4) {
					VentanaNivel.fInky = VentanaNivel.fInky + aux3;
				}
				
				
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}


			/*}else if(VentanaNivel.cInky == 24 || VentanaNivel.fInky == 1 || VentanaNivel.cInky == 0 || VentanaNivel.fInky == 24 || ((ImageIcon) ((JLabel) VentanaNivel.aBi[VentanaNivel.fInky+dx][VentanaNivel.cInky+dy]).getIcon()).getDescription().equalsIgnoreCase("Imagenes\\Pared.png")){
				System.out.println("hola mundo");
				choque = true;
				break;	*/				
			}else
				choque  = true;
			}
		}
		
		

		}

	

}
