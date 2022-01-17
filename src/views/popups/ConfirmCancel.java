package views.popups;

import javax.swing.*;
import java.awt.*;

public class ConfirmCancel extends javax.swing.JDialog
{
    String Choice;
    public ConfirmCancel()
    {
        super((Window)null);
        setModal(true);
        
        setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setLayout(null);
        setSize(360,180);
        JLabel confirm_prompt=new JLabel("Are you sure you want to cancel the booking?");
        confirm_prompt.setBounds(20,20,325,30);
        confirm_prompt.setFont(new Font("Sans Serif",Font.PLAIN,14));
        JButton yes=new JButton("Yes");
        yes.setBounds(50,70,100,30);
        yes.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                Choice="Yes";
                dispose();
            }
        });

        JButton no=new JButton("No");
        no.setBounds(180,70,100,30);
        no.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                Choice="No";
                dispose();
            }
        });
        add(confirm_prompt);
        add(yes);
        add(no);
        setVisible(true);
    }
    public static void main(String[] args)
    {
        ConfirmCancel x=new ConfirmCancel();
    }
}
