import java.awt.Container;
import javax.swing.JFrame;
/*
 * CalculatorFrame.java
 *
 * Created on 24 íæáíæ, 2006, 02:00 ã
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

/**
 *
 * @author Tetoooooooooo
 */
public class CalculatorFrame extends JFrame
{
    
    /** Creates a new instance of CalculatorFrame */
    public CalculatorFrame() 
    {
        setTitle("Calculator");
        setLocation(300,200);
        setSize(500,500);
        CalculatorPanel pan=new CalculatorPanel();
        Container contentPane=getContentPane();
        contentPane.add(pan);
        pack();
    }
    
}
