package views;

import javax.swing.*;
import java.awt.*;

class Success_dialogue extends javax.swing.JDialog
{
    public Success_dialogue(String Transaction_id, PaymentWindow window)
    {
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
                window.dispose();
            }
        });
        add(success_message);
        add(print_id);
        add(ok);
    }
}

class failure_dialogue extends javax.swing.JDialog
{
    public failure_dialogue(String Transaction_id)
    {
        setLayout(null);
        setSize(330,230);
        JLabel failure_message=new JLabel("The transaction has failed!");
        failure_message.setBounds(20,20,300,30);
        failure_message.setFont(new Font("Sans Serif",Font.PLAIN,18));
        JLabel print_id=new JLabel("Transaction ID: "+Transaction_id);
        print_id.setBounds(70,70,200,30);
        print_id.setFont(new Font("Sans Serif",Font.PLAIN,18));
        JButton ok=new JButton("Go Back");
        ok.setBounds(100,120,100,30);
        ok.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                dispose();
            }
        });
        add(failure_message);
        add(print_id);
        add(ok);
    }
}

public class PaymentWindow extends javax.swing.JFrame {

    public PaymentWindow() {
        initComponents();
        setVisible(true);
    }
    private void initComponents() {

        cc_text = new javax.swing.JLabel();
        credit_card_choose = new javax.swing.JComboBox<>();
        card_no_prompt = new javax.swing.JLabel();
        card_num_input = new javax.swing.JTextField();
        cvv_label = new javax.swing.JLabel();
        cvv_input = new javax.swing.JTextField();
        expiry_label = new javax.swing.JLabel();
        pay_button = new javax.swing.JButton();
        dateString_input = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        cc_text.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cc_text.setText("Enter Credit Card Details");

        credit_card_choose.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        credit_card_choose.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "MasterCard", "IndusInd", "Standard Chartered", "ICICI", "VISA" }));
        credit_card_choose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                credit_card_chooseActionPerformed(evt);
            }
        });

        card_no_prompt.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        card_no_prompt.setText("Card Number");

        cvv_label.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cvv_label.setText("CVV ");

        cvv_input.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cvv_inputActionPerformed(evt);
            }
        });

        expiry_label.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        expiry_label.setText("Expiry Date");

        pay_button.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        String amount="1234";
        pay_button.setText("Pay "+amount);
        PaymentWindow this_window=this;
        pay_button.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                System.out.println("Payment Button clicked");
                Boolean payment_result=true;//Do controller processing of payment here and return whether it succeeded
                if(payment_result)
                {
                    try {
                        Success_dialogue dialog = new Success_dialogue("1234",this_window);
                        dialog.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
                        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                        dialog.setVisible(true);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
                else
                {
                    try {
                        failure_dialogue dialog = new failure_dialogue("1234");
                        dialog.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
                        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                        dialog.setVisible(true);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(172, Short.MAX_VALUE)
                                .addComponent(pay_button)
                                .addGap(179, 179, 179))
                        .addGroup(layout.createSequentialGroup()
                                .addGap(52, 52, 52)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(expiry_label)
                                        .addComponent(cvv_label)
                                        .addComponent(card_no_prompt)
                                        .addComponent(cc_text, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(card_num_input, javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(credit_card_choose, javax.swing.GroupLayout.Alignment.LEADING, 0, 149, Short.MAX_VALUE)
                                                .addComponent(cvv_input, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(dateString_input, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(cc_text)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(credit_card_choose, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(card_no_prompt)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(card_num_input, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(cvv_label)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cvv_input, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34)
                                .addComponent(expiry_label)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(dateString_input, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                                .addComponent(pay_button)
                                .addGap(41, 41, 41))
        );

        pack();
    }

    private void credit_card_chooseActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void cvv_inputActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PaymentWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PaymentWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PaymentWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PaymentWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PaymentWindow();
            }
        });
    }

    // Variables declaration - do not modify
    private javax.swing.JLabel card_no_prompt;
    private javax.swing.JLabel cc_text;
    private javax.swing.JComboBox<String> credit_card_choose;
    private javax.swing.JLabel cvv_label;
    private javax.swing.JLabel expiry_label;
    private javax.swing.JTextField card_num_input;
    private javax.swing.JTextField cvv_input;
    private javax.swing.JTextField dateString_input;
    private javax.swing.JButton pay_button;
}