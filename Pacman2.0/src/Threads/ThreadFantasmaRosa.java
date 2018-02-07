package Threads;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Ventanas.VentanaNivel;

public class ThreadFantasmaRosa extends Thread{

	public ThreadFantasmaRosa()  {
		super();
		
	}
	public void run() {
		while(true) { //Mientras no se lo haya comido el pacman
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
					if(VentanaNivel.cPinky<24 && (((ImageIcon) ((JLabel) VentanaNivel.aBi[VentanaNivel.fPinky][VentanaNivel.cPinky+1]).getIcon()).getDescription().equalsIgnoreCase("Imagenes\\Bolita.png"))||
							(((ImageIcon) ((JLabel) VentanaNivel.aBi[VentanaNivel.fPinky][VentanaNivel.cPinky+1]).getIcon()).getDescription().equalsIgnoreCase("Imagenes\\Fondo.png"))) {
						Object aux2 = VentanaNivel.aBi[VentanaNivel.fPinky][VentanaNivel.cPinky + 1];
						VentanaNivel.aBi[VentanaNivel.fPinky][VentanaNivel.cPinky + 1] = VentanaNivel.aBi[VentanaNivel.fPinky][VentanaNivel.cPinky];
						VentanaNivel.aBi[VentanaNivel.fPinky][VentanaNivel.cPinky] = aux2;
						VentanaNivel.cPinky++;
						ImageIcon im = new ImageIcon("Imagenes\\FantasmaRosa.png");
						im.setDescription("Imagenes\\FantasmaRosa.png");
						((JLabel) VentanaNivel.aBi[VentanaNivel.fPinky][VentanaNivel.cPinky]).setIcon(im);
						try {
							Thread.sleep(500);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						VentanaNivel.panelCentro.removeAll();
						for (int i = 0; i < VentanaNivel.aBi.length; i++) {
							for (int j = 0; j < VentanaNivel.aBi[0].length; j++) {
								VentanaNivel.panelCentro.add((JLabel) VentanaNivel.aBi[i][j]);
							}
							VentanaNivel.panelCentro.updateUI();
						}
						
	
					}else if( VentanaNivel.cPinky<24 && ((ImageIcon) ((JLabel) VentanaNivel.aBi[VentanaNivel.fPinky][VentanaNivel.cPinky+1]).getIcon()).getDescription().equalsIgnoreCase("Imagenes\\Pared.png")){
						choque = true;
						break;					
					}else
						choque  = true;
					
					
				}
			case 2:
				while(!choque) {
					if(VentanaNivel.cPinky<24 && VentanaNivel.cPinky>0 && VentanaNivel.cPinky>0 && (((ImageIcon) ((JLabel) VentanaNivel.aBi[VentanaNivel.fPinky][VentanaNivel.cPinky-1]).getIcon()).getDescription().equalsIgnoreCase("Imagenes\\Bolita.png"))||
							(((ImageIcon) ((JLabel) VentanaNivel.aBi[VentanaNivel.fPinky][VentanaNivel.cPinky-1]).getIcon()).getDescription().equalsIgnoreCase("Imagenes\\Fondo.png"))) {
						Object aux2 = VentanaNivel.aBi[VentanaNivel.fPinky][VentanaNivel.cPinky - 1];
						VentanaNivel.aBi[VentanaNivel.fPinky][VentanaNivel.cPinky - 1] = VentanaNivel.aBi[VentanaNivel.fPinky][VentanaNivel.cPinky];
						VentanaNivel.aBi[VentanaNivel.fPinky][VentanaNivel.cPinky] = aux2;
						VentanaNivel.cPinky--;
						ImageIcon im = new ImageIcon("Imagenes\\FantasmaRosa.png");
						im.setDescription("Imagenes\\FantasmaRosa.png");
						((JLabel) VentanaNivel.aBi[VentanaNivel.fPinky][VentanaNivel.cPinky]).setIcon(im);
						try {
							Thread.sleep(500);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						VentanaNivel.panelCentro.removeAll();
						for (int i = 0; i < VentanaNivel.aBi.length; i++) {
							for (int j = 0; j < VentanaNivel.aBi[0].length; j++) {
								VentanaNivel.panelCentro.add((JLabel) VentanaNivel.aBi[i][j]);
							}
							VentanaNivel.panelCentro.updateUI();
						}
	
					}else if( VentanaNivel.cPinky>0 && ((ImageIcon) ((JLabel) VentanaNivel.aBi[VentanaNivel.fPinky][VentanaNivel.cPinky-1]).getIcon()).getDescription().equalsIgnoreCase("Imagenes\\Pared.png")){
						choque = true;
						break;
						
					}else
						choque  = true;
					
					
				}
				
			case 3:
				while(!choque) {
					if(VentanaNivel.cPinky<24 && VentanaNivel.cPinky>0 && VentanaNivel.cPinky>0 && VentanaNivel.fPinky>0 && (((ImageIcon) ((JLabel) VentanaNivel.aBi[VentanaNivel.fPinky-1][VentanaNivel.cPinky]).getIcon()).getDescription().equalsIgnoreCase("Imagenes\\Bolita.png"))||
							(((ImageIcon) ((JLabel) VentanaNivel.aBi[VentanaNivel.fPinky][VentanaNivel.cPinky-1]).getIcon()).getDescription().equalsIgnoreCase("Imagenes\\Fondo.png"))) {
						Object aux2 = VentanaNivel.aBi[VentanaNivel.fPinky-1][VentanaNivel.cPinky ];
						VentanaNivel.aBi[VentanaNivel.fPinky-1][VentanaNivel.cPinky ] = VentanaNivel.aBi[VentanaNivel.fPinky][VentanaNivel.cPinky];
						VentanaNivel.aBi[VentanaNivel.fPinky][VentanaNivel.cPinky] = aux2;
						VentanaNivel.fPinky--;
						ImageIcon im = new ImageIcon("Imagenes\\FantasmaRosa.png");
						im.setDescription("Imagenes\\FantasmaRosa.png");
						((JLabel) VentanaNivel.aBi[VentanaNivel.fPinky][VentanaNivel.cPinky]).setIcon(im);
						try {
							Thread.sleep(500);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						VentanaNivel.panelCentro.removeAll();
						for (int i = 0; i < VentanaNivel.aBi.length; i++) {
							for (int j = 0; j < VentanaNivel.aBi[0].length; j++) {
								VentanaNivel.panelCentro.add((JLabel) VentanaNivel.aBi[i][j]);
							}
							VentanaNivel.panelCentro.updateUI();
						}
	
					}else if(VentanaNivel.cPinky>0 && ((ImageIcon) ((JLabel) VentanaNivel.aBi[VentanaNivel.fPinky-1][VentanaNivel.cPinky]).getIcon()).getDescription().equalsIgnoreCase("Imagenes\\Pared.png")){
						choque = true;
						break;
						
					}else
						choque  = true;
					
				}
				
	
			case 4:
				while(!choque) {
					if(VentanaNivel.fPinky<24 && (((ImageIcon) ((JLabel) VentanaNivel.aBi[VentanaNivel.fPinky+1][VentanaNivel.cPinky]).getIcon()).getDescription().equalsIgnoreCase("Imagenes\\Bolita.png"))||
							(((ImageIcon) ((JLabel) VentanaNivel.aBi[VentanaNivel.fPinky+1][VentanaNivel.cPinky]).getIcon()).getDescription().equalsIgnoreCase("Imagenes\\Fondo.png"))) {
						Object aux2 = VentanaNivel.aBi[VentanaNivel.fPinky+1][VentanaNivel.cPinky];
						VentanaNivel.aBi[VentanaNivel.fPinky+1][VentanaNivel.cPinky ] = VentanaNivel.aBi[VentanaNivel.fPinky][VentanaNivel.cPinky];
						VentanaNivel.aBi[VentanaNivel.fPinky][VentanaNivel.cPinky] = aux2;
						VentanaNivel.fPinky++;
						ImageIcon im = new ImageIcon("Imagenes\\FantasmaRosa.png");
						im.setDescription("Imagenes\\FantasmaRosa.png");
						((JLabel) VentanaNivel.aBi[VentanaNivel.fPinky][VentanaNivel.cPinky]).setIcon(im);
						try {
							Thread.sleep(500);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						VentanaNivel.panelCentro.removeAll();
						for (int i = 0; i < VentanaNivel.aBi.length; i++) {
							for (int j = 0; j < VentanaNivel.aBi[0].length; j++) {
								VentanaNivel.panelCentro.add((JLabel) VentanaNivel.aBi[i][j]);
							}
							VentanaNivel.panelCentro.updateUI();
						}
	
					}else if(VentanaNivel.cPinky<24 && ((ImageIcon) ((JLabel) VentanaNivel.aBi[VentanaNivel.fPinky+1][VentanaNivel.cPinky]).getIcon()).getDescription().equalsIgnoreCase("Imagenes\\Pared.png")){
						choque = true;
						break;
						
					}else
						choque  = true;
					
					
				}
			}
		}

	}

}