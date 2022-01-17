package views.popups;
import views.HouseInfoWindow;
import views.OrderSummaryWindow;
import views.PaymentWindow;
import views.ResultWindow;

import javax.swing.*;
import java.awt.*;

public class SuccessDialog extends javax.swing.JDialog{
    public SuccessDialog(String Transaction_id, PaymentWindow pay_window,
                         OrderSummaryWindow order_window, HouseInfoWindow house_window,
                         ResultWindow result_window){
        super((Window)null);
        setModal(true);

        setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setLayout(null);
        setSize(330,230);
        JLabel success_message=new JLabel("The transaction was successful!");
        success_message.setBounds(20,20,300,30);
        success_message.setFont(new Font("Sans Serif",Font.PLAIN,18));
        JLabel print_id=new JLabel("Transaction ID: "+Transaction_id);
        print_id.setBounds(70,70,200,30);
        print_id.setFont(new Font("Sans Serif",Font.PLAIN,18));
        JButton ok=new JButton("Done");
        ok.setBounds(100,120,100,30);
        ok.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                dispose();
                pay_window.dispose();
                order_window.dispose();
                try{
                    house_window.dispose();
                }
                catch (Exception e) {System.out.println("User has entered payment directly from HouseTile");}
                result_window.dispose();
            }
        });
        add(success_message);
        add(print_id);
        add(ok);

        setVisible(true);
    }
}