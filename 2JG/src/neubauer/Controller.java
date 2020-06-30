package neubauer;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
/**
 * Controller Klasse 
 * @author David Neubauer
 * @version 2019-05-29
 *
 */
public class Controller implements KeyListener{
	private Frame f;
	private MyPanel p;
	/**
	 * Konstruktor
	 */
	public Controller() {
		this.p = new MyPanel();
		f = new Frame("David Neubauer",400,400,p);
		f.addKeyListener(this);
		p.setKreis(1);
	}
	/**
	 * Mehtode KeyPressed
	 * @param a KeyEvent
	 */
	@Override
	public void keyPressed(KeyEvent a) {
		char a1 = a.getKeyChar();
		switch (a1) {
			case 'l': case 'L':
			p.setKreis(3);
			break;
			case 'w': case 'W':
			p.setKreis(2);
            break;
            case 'n': case 'N':
            p.setKreis(1);
            break;
		}
		
	}
	/**
	 * Mehtode keyReleased
	 * @param arg0 KeyEvent
	 */
	@Override
	public void keyReleased(KeyEvent arg0) {
	}
	/**
	 * Mehtode keyTyped
	 * @param a KeyEvent
	 */
	@Override
	public void keyTyped(KeyEvent a) {
	}
}
