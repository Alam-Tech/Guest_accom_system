package views.popups;

import javax.swing.*;
import java.awt.*;

public class CancelationPopup extends JDialog{
    public CancelationPopup(Boolean positive,String message){
        setModal(true);
        setLayout(null);
        setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        String button_string = "Close";
        
        if(positive){
            setTitle("Success");
        }else{
            setTitle("Failed");
        }

        JLabel message_field = new JLabel(message);
        message_field.setFont(new Font("Sans Serif",0, 15));
        if(!positive) message_field.setForeground(Color.red);
        message_field.setBounds(50,20,350,50);

        JButton ok = new JButton(button_string);
        ok.setBounds(130,80,100,30);
        ok.addActionListener(new java.awt.event.ActionListener(){
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt){
                dispose();
            }
        });
        add(message_field);
        add(ok);
        setSize(390,180);
        setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setVisible(true);
    }
    public static void main(String[] args)
    {
        CancelationPopup x=new CancelationPopup(false,"Unable to refund amount!");
    }
}