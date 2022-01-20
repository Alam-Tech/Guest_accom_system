package views.popups;

import javax.swing.*;
import java.awt.*;

public class CancelationResult extends JDialog
{
    public CancelationResult(Boolean result)
    {
        setModal(true);
        setLayout(null);
        setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        String message_string = "Booking Cancelation has ";
        String button_string;
        if(result==true)
        {
            message_string+= "succeeded";
            button_string="Done";
        }
        else
        {
            message_string+= "failed";
            button_string="Go Back";
        }
        JLabel message=new JLabel(message_string);
        message.setFont(new Font("Sans Serif",0, 15));
        message.setForeground(Color.red);
        message.setBounds(50,20,350,50);
        JButton ok = new JButton(button_string);
        ok.setBounds(130,80,100,30);
        ok.addActionListener(new java.awt.event.ActionListener()
        {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                dispose();
            }
        });
        add(message);
        add(ok);
        setSize(390,180);
        setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setVisible(true);
    }
    public static void main(String[] args)
    {
        CancelationResult x=new CancelationResult(true);
    }
}