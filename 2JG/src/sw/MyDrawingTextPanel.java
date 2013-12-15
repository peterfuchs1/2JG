package sw;
import java.awt.*;
import java.awt.event.*;

import javax.swing.JPanel;
/**
 * Ein JPanel, mit paintComponent()
 *
 * @author Walter Rafeiner-Magor
 * @version 1.1
 */
public class MyDrawingTextPanel extends JPanel               
{
	private String text;
    /**
     * Konstruktor mit anzuzeigenden Text
     * @param t
     */
    public MyDrawingTextPanel(String t){
    	text=t;
    }
	/* (non-Javadoc)
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	@Override
	protected void paintComponent(Graphics g) {
		g.setColor(Color.GREEN);
		g.fillRoundRect(140, 220, 520, 140, 20, 20);
		g.setColor(Color.WHITE);
		g.drawRoundRect(150, 230, 500, 120, 10, 10);
		g.setColor(Color.YELLOW);
		g.fillRect(160, 240, 480, 100);
		g.setColor(Color.BLUE);
		g.fillOval(160, 240, 480, 100);
		g.setColor(Color.WHITE);
		g.setFont(new Font("SansSerif", Font.BOLD, 30));
		g.drawString(text, 200, 300);
	}
  } 