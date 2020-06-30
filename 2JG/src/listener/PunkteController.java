package listener;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Steuert ein Programm, das Punkte auf ein Panel zeichnet. Die Position der Punkte
 * wird dabei �ber einen Maus-Klick bestimmt. Die Farbe �ber einen Tastendruck
 *
 * @author Lisa Vittori
 * @version 12.06.2018
 */
public class PunkteController implements MouseListener, KeyListener {
    private PunkteLayout myPanel; /*Objekt der View-Klasse*/
    private Punkt myModel; /*Objekt der Model-Klasse*/

    /**
     * Controller, der mit Hilfe einer selbst geschriebenen GenericFrame-Klasse
     * das Layout anzeigt.
     */
    public PunkteController() {
    	
        myPanel = new PunkteLayout();
        myModel = new Punkt(10,10,50);

        MyFrame f = new MyFrame(myPanel, "Punkte-Grafik",  420, 300);
        f.addKeyListener(this); // der KeyListener bezieht sich immer auf das gesamte Frame
        myPanel.addMouseListener(this); // der MouseListener bezieht sich auf das Panel, das
        // �berwacht werden soll.
    }

    /**
     * Starten des Programms
     * @param args nicht verwendet
     */
    public static void main(String[] args) {
        new PunkteController();
    }

    /**
     * Aus dem KeyListener:
     * Funktioniert nur bei druckbaren Zeichen  (Buchstaben, Ziffern, ...) und wird
     * ausgel�st, sobald das Keyboard den unicode-Wert an das System schickt.
     * @param e das KeyEvent mit den Informationen �ber den Ausl�ser
     */
    @Override
    public void keyTyped(KeyEvent e) {
        // Nicht ben�tigt		
    }

    /**
     * Aus dem KeyListener:
     * Wird ausgel�st, sobald die Taste hinunter gedr�ckt wird.
     * @param e das KeyEvent mit den Informationen �ber den Ausl�ser
     */	
    @Override
    public void keyPressed(KeyEvent e) {
        char k = e.getKeyChar(); // hole das Zeichen, das das Event ausgel�st hat.
        switch (k) {
            case 'r': case 'R':
            myPanel.setFarbe(Color.RED, "Rot");
            break;
            case 'g': case 'G':
            myPanel.setFarbe(Color.GREEN, "Gr�n");
            break;
            case 'b': case 'B':
            myPanel.setFarbe(Color.BLUE, "Blau");
            break;
        }
    }

    /**
     * Aus dem KeyListener:
     * Wird ausgel�st, sobald die Taste losgelassen wird.
     * @param e das KeyEvent mit den Informationen �ber den Ausl�ser
     */ 
    @Override
    public void keyReleased(KeyEvent e) {
        // Nicht ben�tigt

    }

    /**
     * Aus dem MouseListener:
     * Wird ausgel�st, sobald die Maus-Taste geklickt (dr�cken + loslassen) wurde,
     * w�hrend der Mauszeiger in der �berwachten Komponente (dem Panel) ist.
     * @param e das MouseEvent mit den Informationen �ber den Ausl�ser
     */ 	
    @Override
    public void mouseClicked(MouseEvent e) {
        int x = e.getX(); // hole dir aus dem MouseEvent die x-Koordinate
        int y = e.getY(); // hole dir aus dem MouseEvent die x-Koordinate
        myPanel.setPunkt(x, y);

    }

    /**
     * Aus dem MouseListener:
     * Wird ausgel�st, sobald die Maus-Taste gedr�ckt wurde, w�hrend der
     * Mauszeiger in der �berwachten Komponente (dem Panel) ist.
     * @param e das MouseEvent mit den Informationen �ber den Ausl�ser
     */   
    @Override
    public void mousePressed(MouseEvent e) {
        // Nicht ben�tigt

    }

    /**
     * Aus dem MouseListener:
     * Wird ausgel�st, sobald die Maus-Taste losgelassen wurde, w�hrend der
     * Mauszeiger in der �berwachten Komponente (dem Panel) ist.
     * @param e das MouseEvent mit den Informationen �ber den Ausl�ser
     */  
    @Override
    public void mouseReleased(MouseEvent e) {
        // Nicht ben�tigt

    }

    /**
     * Aus dem MouseListener:
     * Wird ausgel�st, sobald der Mauszeiger die �berwachte Komponente 
     * erreicht und hineinf�hrt.
     * @param e das MouseEvent mit den Informationen �ber den Ausl�ser
     */  
    @Override
    public void mouseEntered(MouseEvent e) {
        // Nicht ben�tigt
    }

    /**
     * Aus dem MouseListener:
     * Wird ausgel�st, sobald der Mauszeiger aus der �berwachten Komponente 
     * herausf�hrt.
     * @param e das MouseEvent mit den Informationen �ber den Ausl�ser
     */  
    @Override
    public void mouseExited(MouseEvent e) {
        // Nicht ben�tigt.

    }
}