package TiposDeDatos;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;



public class Icono  implements KeyListener {
	
	public Icono(){



	}
	public void mover() {
		
	}


	/*esta mal, tengo que pensarlo y no me da tiempo a mas */

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int keyCode = e.getKeyCode();
		switch( keyCode ) { 
		case KeyEvent.VK_UP:
	//	Pacman pacman = new Pacman();
			break;	
		case KeyEvent.VK_DOWN:	
			break;
		case KeyEvent.VK_LEFT:
			break;
		case KeyEvent.VK_RIGHT :
			break;
		case KeyEvent.VK_W:
			break;			
		case KeyEvent.VK_S:		
			break;
		case KeyEvent.VK_A:		
			break;			
		case KeyEvent.VK_D :			
			break;
		}
	}


		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub

		}


	}
