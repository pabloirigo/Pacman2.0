package Ventanas;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import TiposDeDatos.Pacman;

import java.awt.GridLayout;
import java.awt.event.KeyEvent;

public class VentanaNivel extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane, panelNorte, panelSur, panelCentro;
	public static Object aBi[][];
	public int columnas, filas;
	//public int x,y;
	Pacman pacman = new Pacman();
 
	/**
	 * Create the frame.
	 */
	public VentanaNivel(Object aBi[][]) {

		VentanaNivel.aBi = aBi;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		panelNorte = new JPanel();
		contentPane.add(panelNorte, BorderLayout.NORTH);

		panelSur = new JPanel();
		contentPane.add(panelSur, BorderLayout.SOUTH);

		panelCentro = new JPanel();
		contentPane.add(panelCentro, BorderLayout.CENTER);
		panelCentro.setLayout(new GridLayout(0, 32, 0, 0));
		
		for (int i = 0; i < aBi.length; i++) {			
			for (int j = 0; j < aBi[0].length; j++) {
				panelCentro.add((JLabel) aBi[i][j]);
				if (aBi[i][j].equals("Pacman")){// con que lo comparo??? con la desc?			
				pacman.setX(i);
				pacman.setY(j);
							
				}
					
						
			}
			setVisible(true);
			
			
		}
	}
		public void keyPressed(KeyEvent e) {

			// TODO Auto-generated method stub
		
			int keyCode = e.getKeyCode();
			
			switch( keyCode ) { 

			case KeyEvent.VK_UP:
					pacman.mover();
				
				break;	
			case KeyEvent.VK_DOWN:					
				break;
			case KeyEvent.VK_LEFT:
				break;
			case KeyEvent.VK_RIGHT :			
				break;
			}

		
		
	
	
	}

}