import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
/*
 * CalculatorPanel.java
 *
 * Created on 24 íæáíæ, 2006, 02:02 ã
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

/**
 *
 * @author Tetoooooooooo
 */
public class CalculatorPanel extends JPanel
{
    
    /** Creates a new instance of CalculatorPanel */
    public CalculatorPanel() 
    {
        setLayout(new BorderLayout());
        
        result=0;
        lastCommand="=";
        start=true;
        
        display=new JLabel("0.0");
        add(display,BorderLayout.NORTH);
        
        ActionListener insert=new InsertAction();
        ActionListener command=new CommandAction();
        
        panel=new JPanel();
        
        panel.setLayout(new GridLayout(4,4));
        
        addButton("7",insert);
        addButton("8",insert);
        addButton("9",insert);
        addButton("/",command);
        
        addButton("4",insert);
        addButton("5",insert);
        addButton("6",insert);
        addButton("*",command);
        
        addButton("1",insert);
        addButton("2",insert);
        addButton("3",insert);
        addButton("-",command);
        
        addButton("0",insert);
        addButton(".",insert);
        addButton("=",command);
        addButton("+",command);
        
        add(panel,BorderLayout.CENTER);
        
    }
    
    private void addButton(String label,ActionListener listner)
    {
        JButton button=new JButton(label);
        button.addActionListener(listner);
        panel.add(button);
    }
    
    private class InsertAction implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            String input=event.getActionCommand();
            if(start)
            {
                display.setText("");
                start=false;
            }
            display.setText(display.getText()+input);
        }
    }
    private class CommandAction implements ActionListener
    {
        public void actionPerformed(ActionEvent eve)
        {
            String command=eve.getActionCommand();
            
            if(start)
            {
                if(command.equals("-"))
                {
                    display.setText("-");
                    start=false;
                }
                else
                    lastCommand=command;
            }
            else
            {
                Calculate(Double.parseDouble(display.getText()));
                lastCommand=command;
                start=true;
            }
        }
        
    }
    
    public void Calculate(double x)
    {
        if(lastCommand.equals("/"))
            result/=x;
        else if(lastCommand.equals("*"))
            result*=x;
        else if(lastCommand.equals("-"))
            result-=x;
        else if(lastCommand.equals("+"))
            result+=x;
        else if(lastCommand.equals("="))
            result=x;
        
        display.setText(""+result);
    }
    
    private JPanel panel;
    private JLabel display;
    private double result;
    private String lastCommand;
    private boolean start;
}
