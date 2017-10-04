package TiposDeDatos;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;



public class Icono  implements KeyListener {
	private int x=0;
	private int y=0;
	private int dx=0;
	private int dy=0;
	public Icono(){
		
	
		
	}
	public void mover() {
		x = dx;
		y +=dy;
	}
	
	
/*esta mal, tengo que pensarlo y no me da tiempo a mas */
	
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int key = e.getKeyCode();
		
		if(key == KeyEvent.VK_LEFT) {
			dx = -1;
			
		}
		//if(key == KeyEvent.VK_RIGHT)
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
