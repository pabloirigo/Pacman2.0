package Threads;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Ventanas.VentanaNivel;

public class ThreadFantasmaNaranja extends Thread{

	public ThreadFantasmaNaranja()  {
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
					if(VentanaNivel.cClyde<24 && (((ImageIcon) ((JLabel) VentanaNivel.aBi[VentanaNivel.fClyde][VentanaNivel.cClyde+1]).getIcon()).getDescription().equalsIgnoreCase("Imagenes\\Bolita.png"))||
							(((ImageIcon) ((JLabel) VentanaNivel.aBi[VentanaNivel.fClyde][VentanaNivel.cClyde+1]).getIcon()).getDescription().equalsIgnoreCase("Imagenes\\Fondo.png"))) {
//						Object aux2 = VentanaNivel.aBi[VentanaNivel.fClyde][VentanaNivel.cClyde + 1];
//						VentanaNivel.aBi[VentanaNivel.fClyde][VentanaNivel.cClyde + 1] = VentanaNivel.aBi[VentanaNivel.fClyde][VentanaNivel.cClyde];
//						VentanaNivel.aBi[VentanaNivel.fClyde][VentanaNivel.cClyde] = aux2;
//						VentanaNivel.cClyde++;
//						ImageIcon im = new ImageIcon("Imagenes\\FantasmaNaranja.png");
//						im.setDescription("Imagenes\\FantasmaNaranja.png");
//						((JLabel) VentanaNivel.aBi[VentanaNivel.fClyde][VentanaNivel.cClyde]).setIcon(im);
						Icon aux2 = ((JLabel)VentanaNivel.aBi[VentanaNivel.fClyde][VentanaNivel.cClyde + 1]).getIcon();
						Icon aux1 = ((JLabel)VentanaNivel.aBi[VentanaNivel.fClyde][VentanaNivel.cClyde]).getIcon();
						((JLabel)VentanaNivel.aBi[VentanaNivel.fClyde][VentanaNivel.cClyde + 1]).setIcon(aux1);
						((JLabel)VentanaNivel.aBi[VentanaNivel.fClyde][VentanaNivel.cClyde]).setIcon(aux2);
						VentanaNivel.cClyde++;
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
						
	
					}else if( VentanaNivel.cClyde<24 && ((ImageIcon) ((JLabel) VentanaNivel.aBi[VentanaNivel.fClyde][VentanaNivel.cClyde+1]).getIcon()).getDescription().equalsIgnoreCase("Imagenes\\Pared.png")){
						choque = true;
						break;					
					}else
						choque  = true;
					
					
				}
			case 2:
				while(!choque) {
					if(VentanaNivel.cClyde<24 && VentanaNivel.cClyde>0 && VentanaNivel.cClyde>0 && (((ImageIcon) ((JLabel) VentanaNivel.aBi[VentanaNivel.fClyde][VentanaNivel.cClyde-1]).getIcon()).getDescription().equalsIgnoreCase("Imagenes\\Bolita.png"))||
							(((ImageIcon) ((JLabel) VentanaNivel.aBi[VentanaNivel.fClyde][VentanaNivel.cClyde-1]).getIcon()).getDescription().equalsIgnoreCase("Imagenes\\Fondo.png"))) {
//						Object aux2 = VentanaNivel.aBi[VentanaNivel.fClyde][VentanaNivel.cClyde - 1];
//						VentanaNivel.aBi[VentanaNivel.fClyde][VentanaNivel.cClyde - 1] = VentanaNivel.aBi[VentanaNivel.fClyde][VentanaNivel.cClyde];
//						VentanaNivel.aBi[VentanaNivel.fClyde][VentanaNivel.cClyde] = aux2;
//						VentanaNivel.cClyde--;
//						ImageIcon im = new ImageIcon("Imagenes\\FantamsmaNaranja.png");
//						im.setDescription("Imagenes\\FantasmaNaranja.png");
//						((JLabel) VentanaNivel.aBi[VentanaNivel.fClyde][VentanaNivel.cClyde]).setIcon(im);
						Icon aux2 = ((JLabel)VentanaNivel.aBi[VentanaNivel.fClyde][VentanaNivel.cClyde - 1]).getIcon();
						Icon aux1 = ((JLabel)VentanaNivel.aBi[VentanaNivel.fClyde][VentanaNivel.cClyde]).getIcon();
						((JLabel)VentanaNivel.aBi[VentanaNivel.fClyde][VentanaNivel.cClyde - 1]).setIcon(aux1);
						((JLabel)VentanaNivel.aBi[VentanaNivel.fClyde][VentanaNivel.cClyde]).setIcon(aux2);
						VentanaNivel.cClyde--;
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
	
					}else if( VentanaNivel.cClyde>0 && ((ImageIcon) ((JLabel) VentanaNivel.aBi[VentanaNivel.fClyde][VentanaNivel.cClyde-1]).getIcon()).getDescription().equalsIgnoreCase("Imagenes\\Pared.png")){
						choque = true;
						break;
						
					}else
						choque  = true;
					
					
				}
				
			case 3:
				while(!choque) {
					if(VentanaNivel.cClyde<24 && VentanaNivel.cClyde>0 && VentanaNivel.cClyde>0 && VentanaNivel.fClyde>0 && (((ImageIcon) ((JLabel) VentanaNivel.aBi[VentanaNivel.fClyde-1][VentanaNivel.cClyde]).getIcon()).getDescription().equalsIgnoreCase("Imagenes\\Bolita.png"))||
							(((ImageIcon) ((JLabel) VentanaNivel.aBi[VentanaNivel.fClyde][VentanaNivel.cClyde-1]).getIcon()).getDescription().equalsIgnoreCase("Imagenes\\Fondo.png"))) {
//						Object aux2 = VentanaNivel.aBi[VentanaNivel.fClyde-1][VentanaNivel.cClyde ];
//						VentanaNivel.aBi[VentanaNivel.fClyde-1][VentanaNivel.cClyde ] = VentanaNivel.aBi[VentanaNivel.fClyde][VentanaNivel.cClyde];
//						VentanaNivel.aBi[VentanaNivel.fClyde][VentanaNivel.cClyde] = aux2;
//						VentanaNivel.fClyde--;
//						ImageIcon im = new ImageIcon("Imagenes\\FantasmaNaranja.png");
//						im.setDescription("Imagenes\\FantasmaNaranja.png");
//						((JLabel) VentanaNivel.aBi[VentanaNivel.fClyde][VentanaNivel.cClyde]).setIcon(im);
						Icon aux2 = ((JLabel)VentanaNivel.aBi[VentanaNivel.fClyde-1][VentanaNivel.cClyde]).getIcon();
						Icon aux1 = ((JLabel)VentanaNivel.aBi[VentanaNivel.fClyde][VentanaNivel.cClyde]).getIcon();
						((JLabel)VentanaNivel.aBi[VentanaNivel.fClyde-1][VentanaNivel.cClyde]).setIcon(aux1);
						((JLabel)VentanaNivel.aBi[VentanaNivel.fClyde][VentanaNivel.cClyde]).setIcon(aux2);
						VentanaNivel.fClyde--;
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
	
					}else if(VentanaNivel.cClyde>0 && ((ImageIcon) ((JLabel) VentanaNivel.aBi[VentanaNivel.fClyde-1][VentanaNivel.cClyde]).getIcon()).getDescription().equalsIgnoreCase("Imagenes\\Pared.png")){
						choque = true;
						break;
						
					}else
						choque  = true;
					
				}
				
	
			case 4:
				while(!choque) {
					if(VentanaNivel.fClyde<24 && (((ImageIcon) ((JLabel) VentanaNivel.aBi[VentanaNivel.fClyde+1][VentanaNivel.cClyde]).getIcon()).getDescription().equalsIgnoreCase("Imagenes\\Bolita.png"))||
							(((ImageIcon) ((JLabel) VentanaNivel.aBi[VentanaNivel.fClyde+1][VentanaNivel.cClyde]).getIcon()).getDescription().equalsIgnoreCase("Imagenes\\Fondo.png"))) {
//						Object aux2 = VentanaNivel.aBi[VentanaNivel.fClyde+1][VentanaNivel.cClyde];
//						VentanaNivel.aBi[VentanaNivel.fClyde+1][VentanaNivel.cClyde ] = VentanaNivel.aBi[VentanaNivel.fClyde][VentanaNivel.cClyde];
//						VentanaNivel.aBi[VentanaNivel.fClyde][VentanaNivel.cClyde] = aux2;
//						VentanaNivel.fClyde++;
//						ImageIcon im = new ImageIcon("Imagenes\\FantasmaNaranja.png");
//						im.setDescription("Imagenes\\FantasmaNaranja.png");
//						((JLabel) VentanaNivel.aBi[VentanaNivel.fClyde][VentanaNivel.cClyde]).setIcon(im);
						Icon aux2 = ((JLabel)VentanaNivel.aBi[VentanaNivel.fClyde+1][VentanaNivel.cClyde]).getIcon();
						Icon aux1 = ((JLabel)VentanaNivel.aBi[VentanaNivel.fClyde][VentanaNivel.cClyde]).getIcon();
						((JLabel)VentanaNivel.aBi[VentanaNivel.fClyde+1][VentanaNivel.cClyde]).setIcon(aux1);
						((JLabel)VentanaNivel.aBi[VentanaNivel.fClyde][VentanaNivel.cClyde]).setIcon(aux2);
						VentanaNivel.fClyde++;
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
	
					}else if(VentanaNivel.cClyde<24 && ((ImageIcon) ((JLabel) VentanaNivel.aBi[VentanaNivel.fClyde+1][VentanaNivel.cClyde]).getIcon()).getDescription().equalsIgnoreCase("Imagenes\\Pared.png")){
						choque = true;
						break;
						
					}else
						choque  = true;
					
					
				}
			}
		}

	}

}