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
			if(VentanaNivel.cInky<24 && (((ImageIcon) ((JLabel) VentanaNivel.aBi[VentanaNivel.fInky+dx][VentanaNivel.cInky+ dy]).getIcon()).getDescription().equalsIgnoreCase("Imagenes\\Bolita.png"))||
					(((ImageIcon) ((JLabel) VentanaNivel.aBi[VentanaNivel.fInky+dx][VentanaNivel.cInky+ dy]).getIcon()).getDescription().equalsIgnoreCase("Imagenes\\Fondo.png"))) {
				//						Object aux2 = VentanaNivel.aBi[VentanaNivel.fInky][VentanaNivel.cInky + 1];
				//						VentanaNivel.aBi[VentanaNivel.fInky][VentanaNivel.cInky + 1] = VentanaNivel.aBi[VentanaNivel.fInky][VentanaNivel.cInky];
				//						VentanaNivel.aBi[VentanaNivel.fInky][VentanaNivel.cInky] = aux2;
				//						VentanaNivel.cInky++;
				//						ImageIcon im = new ImageIcon("Imagenes\\FantasmaAzul.png");
				//						im.setDescription("Imagenes\\FantasmaAzul.png");
				//						((JLabel) VentanaNivel.aBi[VentanaNivel.fInky][VentanaNivel.cInky]).setIcon(im);
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
				//						VentanaNivel.panelCentro.removeAll();
				//						for (int i = 0; i < VentanaNivel.aBi.length; i++) {
				//							for (int j = 0; j < VentanaNivel.aBi[0].length; j++) {
				//								VentanaNivel.panelCentro.add((JLabel) VentanaNivel.aBi[i][j]);
				//							}
				//							VentanaNivel.panelCentro.updateUI();
				//						}


			}else if( VentanaNivel.cInky<24 && ((ImageIcon) ((JLabel) VentanaNivel.aBi[VentanaNivel.fInky][VentanaNivel.cInky+1]).getIcon()).getDescription().equalsIgnoreCase("Imagenes\\Pared.png")){
				choque = true;
				break;					
			}else
				choque  = true;
			}
		}
			//			switch(dir) {
//
//			case 1:
//				while(!choque) {
//					if(VentanaNivel.cInky<24 && (((ImageIcon) ((JLabel) VentanaNivel.aBi[VentanaNivel.fInky+dx][VentanaNivel.cInky+ dy]).getIcon()).getDescription().equalsIgnoreCase("Imagenes\\Bolita.png"))||
//							(((ImageIcon) ((JLabel) VentanaNivel.aBi[VentanaNivel.fInky+dx][VentanaNivel.cInky+ dy]).getIcon()).getDescription().equalsIgnoreCase("Imagenes\\Fondo.png"))) {
//						//						Object aux2 = VentanaNivel.aBi[VentanaNivel.fInky][VentanaNivel.cInky + 1];
//						//						VentanaNivel.aBi[VentanaNivel.fInky][VentanaNivel.cInky + 1] = VentanaNivel.aBi[VentanaNivel.fInky][VentanaNivel.cInky];
//						//						VentanaNivel.aBi[VentanaNivel.fInky][VentanaNivel.cInky] = aux2;
//						//						VentanaNivel.cInky++;
//						//						ImageIcon im = new ImageIcon("Imagenes\\FantasmaAzul.png");
//						//						im.setDescription("Imagenes\\FantasmaAzul.png");
//						//						((JLabel) VentanaNivel.aBi[VentanaNivel.fInky][VentanaNivel.cInky]).setIcon(im);
//						Icon aux2 = ((JLabel)VentanaNivel.aBi[VentanaNivel.fInky+ dx][VentanaNivel.cInky + dy]).getIcon();
//						Icon aux1 = ((JLabel)VentanaNivel.aBi[VentanaNivel.fInky][VentanaNivel.cInky]).getIcon();
//						((JLabel)VentanaNivel.aBi[VentanaNivel.fInky+ dx][VentanaNivel.cInky + dy]).setIcon(aux1);
//						((JLabel)VentanaNivel.aBi[VentanaNivel.fInky][VentanaNivel.cInky]).setIcon(aux2);
//						VentanaNivel.cInky = VentanaNivel.cInky + aux3;
//						try {
//							Thread.sleep(500);
//						} catch (InterruptedException e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//						}
//						//						VentanaNivel.panelCentro.removeAll();
//						//						for (int i = 0; i < VentanaNivel.aBi.length; i++) {
//						//							for (int j = 0; j < VentanaNivel.aBi[0].length; j++) {
//						//								VentanaNivel.panelCentro.add((JLabel) VentanaNivel.aBi[i][j]);
//						//							}
//						//							VentanaNivel.panelCentro.updateUI();
//						//						}
//
//
//					}else if( VentanaNivel.cInky<24 && ((ImageIcon) ((JLabel) VentanaNivel.aBi[VentanaNivel.fInky][VentanaNivel.cInky+1]).getIcon()).getDescription().equalsIgnoreCase("Imagenes\\Pared.png")){
//						choque = true;
//						break;					
//					}else
//						choque  = true;
//
//
//				}
//			case 2:
//				while(!choque) {
//					if(VentanaNivel.cInky<24 && VentanaNivel.cInky>0 && VentanaNivel.cInky>0 && (((ImageIcon) ((JLabel) VentanaNivel.aBi[VentanaNivel.fInky][VentanaNivel.cInky-1]).getIcon()).getDescription().equalsIgnoreCase("Imagenes\\Bolita.png"))||
//							(((ImageIcon) ((JLabel) VentanaNivel.aBi[VentanaNivel.fInky][VentanaNivel.cInky-1]).getIcon()).getDescription().equalsIgnoreCase("Imagenes\\Fondo.png"))) {
//						//						Object aux2 = VentanaNivel.aBi[VentanaNivel.fInky][VentanaNivel.cInky - 1];
//						//						VentanaNivel.aBi[VentanaNivel.fInky][VentanaNivel.cInky - 1] = VentanaNivel.aBi[VentanaNivel.fInky][VentanaNivel.cInky];
//						//						VentanaNivel.aBi[VentanaNivel.fInky][VentanaNivel.cInky] = aux2;
//						//						ImageIcon im = new ImageIcon("Imagenes\\FantasmaAzul.png");
//						//						im.setDescription("Imagenes\\FantasmaAzul.png");
//						//						((JLabel) VentanaNivel.aBi[VentanaNivel.fInky][VentanaNivel.cInky]).setIcon(im);
//						Icon aux2 = ((JLabel)VentanaNivel.aBi[VentanaNivel.fInky][VentanaNivel.cInky - 1]).getIcon();
//						Icon aux1 = ((JLabel)VentanaNivel.aBi[VentanaNivel.fInky][VentanaNivel.cInky]).getIcon();
//						((JLabel)VentanaNivel.aBi[VentanaNivel.fInky][VentanaNivel.cInky - 1]).setIcon(aux1);
//						((JLabel)VentanaNivel.aBi[VentanaNivel.fInky][VentanaNivel.cInky]).setIcon(aux2);
//						VentanaNivel.cInky--;
//						try {
//							Thread.sleep(500);
//						} catch (InterruptedException e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//						}
//						//						VentanaNivel.panelCentro.removeAll();
//						//						for (int i = 0; i < VentanaNivel.aBi.length; i++) {
//						//							for (int j = 0; j < VentanaNivel.aBi[0].length; j++) {
//						//								VentanaNivel.panelCentro.add((JLabel) VentanaNivel.aBi[i][j]);
//						//							}
//						//							VentanaNivel.panelCentro.updateUI();
//						//						}
//
//					}else if( VentanaNivel.cInky>0 && ((ImageIcon) ((JLabel) VentanaNivel.aBi[VentanaNivel.fInky][VentanaNivel.cInky-1]).getIcon()).getDescription().equalsIgnoreCase("Imagenes\\Pared.png")){
//						choque = true;
//						break;
//
//					}else
//						choque  = true;
//
//
//				}
//
//			case 3:
//				while(!choque) {
//					if(VentanaNivel.cInky<24 && VentanaNivel.cInky>0 && VentanaNivel.cInky>0 && VentanaNivel.fInky>0 && (((ImageIcon) ((JLabel) VentanaNivel.aBi[VentanaNivel.fInky-1][VentanaNivel.cInky]).getIcon()).getDescription().equalsIgnoreCase("Imagenes\\Bolita.png"))||
//							(((ImageIcon) ((JLabel) VentanaNivel.aBi[VentanaNivel.fInky-1][VentanaNivel.cInky]).getIcon()).getDescription().equalsIgnoreCase("Imagenes\\Fondo.png"))) {
//						//						Object aux2 = VentanaNivel.aBi[VentanaNivel.fInky-1][VentanaNivel.cInky ];
//						//						VentanaNivel.aBi[VentanaNivel.fInky-1][VentanaNivel.cInky ] = VentanaNivel.aBi[VentanaNivel.fInky][VentanaNivel.cInky];
//						//						VentanaNivel.aBi[VentanaNivel.fInky][VentanaNivel.cInky] = aux2;
//						//						VentanaNivel.fInky--;
//						//						ImageIcon im = new ImageIcon("Imagenes\\FantasmaAzul.png");
//						//						im.setDescription("Imagenes\\FantasmaAzul.png");
//						//						((JLabel) VentanaNivel.aBi[VentanaNivel.fInky][VentanaNivel.cInky]).setIcon(im);
//						Icon aux2 = ((JLabel)VentanaNivel.aBi[VentanaNivel.fInky-1][VentanaNivel.cInky]).getIcon();
//						Icon aux1 = ((JLabel)VentanaNivel.aBi[VentanaNivel.fInky][VentanaNivel.cInky]).getIcon();
//						((JLabel)VentanaNivel.aBi[VentanaNivel.fInky-1][VentanaNivel.cInky]).setIcon(aux1);
//						((JLabel)VentanaNivel.aBi[VentanaNivel.fInky][VentanaNivel.cInky]).setIcon(aux2);
//						VentanaNivel.fInky--;
//						try {
//							Thread.sleep(500);
//						} catch (InterruptedException e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//						}
//						//						VentanaNivel.panelCentro.removeAll();
//						//						for (int i = 0; i < VentanaNivel.aBi.length; i++) {
//						//							for (int j = 0; j < VentanaNivel.aBi[0].length; j++) {
//						//								VentanaNivel.panelCentro.add((JLabel) VentanaNivel.aBi[i][j]);
//						//							}
//						//							VentanaNivel.panelCentro.updateUI();
//						//						}
//
//					}else if(VentanaNivel.cInky>0 && ((ImageIcon) ((JLabel) VentanaNivel.aBi[VentanaNivel.fInky-1][VentanaNivel.cInky]).getIcon()).getDescription().equalsIgnoreCase("Imagenes\\Pared.png")){
//						choque = true;
//						break;
//
//					}else
//						choque  = true;
//
//				}
//
//
//			case 4:
//				while(!choque) {
//					if(VentanaNivel.fInky<24 && (((ImageIcon) ((JLabel) VentanaNivel.aBi[VentanaNivel.fInky+1][VentanaNivel.cInky]).getIcon()).getDescription().equalsIgnoreCase("Imagenes\\Bolita.png"))||
//							(((ImageIcon) ((JLabel) VentanaNivel.aBi[VentanaNivel.fInky+1][VentanaNivel.cInky]).getIcon()).getDescription().equalsIgnoreCase("Imagenes\\Fondo.png"))) {
//						//						Object aux2 = VentanaNivel.aBi[VentanaNivel.fInky+1][VentanaNivel.cInky];
//						//						VentanaNivel.aBi[VentanaNivel.fInky+1][VentanaNivel.cInky ] = VentanaNivel.aBi[VentanaNivel.fInky][VentanaNivel.cInky];
//						//						VentanaNivel.aBi[VentanaNivel.fInky][VentanaNivel.cInky] = aux2;
//						//						VentanaNivel.fInky++;
//						//						ImageIcon im = new ImageIcon("Imagenes\\FantasmaAzul.png");
//						//						im.setDescription("Imagenes\\FantasmaAzul.png");
//						//						((JLabel) VentanaNivel.aBi[VentanaNivel.fInky][VentanaNivel.cInky]).setIcon(im);
//						Icon aux2 = ((JLabel)VentanaNivel.aBi[VentanaNivel.fInky+1][VentanaNivel.cInky]).getIcon();
//						Icon aux1 = ((JLabel)VentanaNivel.aBi[VentanaNivel.fInky][VentanaNivel.cInky]).getIcon();
//						((JLabel)VentanaNivel.aBi[VentanaNivel.fInky+1][VentanaNivel.cInky]).setIcon(aux1);
//						((JLabel)VentanaNivel.aBi[VentanaNivel.fInky][VentanaNivel.cInky]).setIcon(aux2);
//						VentanaNivel.fInky++;
//						try {
//							Thread.sleep(500);
//						} catch (InterruptedException e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//						}
//						//						VentanaNivel.panelCentro.removeAll();
//						//						for (int i = 0; i < VentanaNivel.aBi.length; i++) {
//						//							for (int j = 0; j < VentanaNivel.aBi[0].length; j++) {
//						//								VentanaNivel.panelCentro.add((JLabel) VentanaNivel.aBi[i][j]);
//						//							}
//						//							VentanaNivel.panelCentro.updateUI();
//						//						}
//
//					}else if(VentanaNivel.cInky<24 && ((ImageIcon) ((JLabel) VentanaNivel.aBi[VentanaNivel.fInky+1][VentanaNivel.cInky]).getIcon()).getDescription().equalsIgnoreCase("Imagenes\\Pared.png")){
//						choque = true;
//						break;
//
//					}else
//						choque  = true;
//
//
//				}
//			}
		}

	

}
