package views;

import javax.swing.*;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

import controller.PaymentController;
import model.OrderInfo;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

final class LengthRestrictedDocument extends PlainDocument {

    private final int limit;

    public LengthRestrictedDocument(int limit) {
        this.limit = limit;
    }

    @Override
    public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {

        if (str == null)
            return;

        if ((getLength() + str.length()) <= limit) {
            super.insertString(offs, str, a);
        }
    }
}

class Success_dialogue extends javax.swing.JDialog{
    public Success_dialogue(String Transaction_id, PaymentWindow window){
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
                window.dispose();
            }
        });
        add(success_message);
        add(print_id);
        add(ok);
        
        setVisible(true);
    }
}

class failure_dialogue extends javax.swing.JDialog{
    public failure_dialogue(String message){
        super((Window)null);
        setModal(true);

        setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setLayout(null);
        setSize(330,230);
        JLabel failure_message=new JLabel("The transaction has failed!");
        failure_message.setBounds(20,20,300,30);
        failure_message.setFont(new Font("Sans Serif",Font.PLAIN,18));
        JLabel reason=new JLabel(message);
        reason.setForeground(Color.RED.darker());
        reason.setBounds(70,70,200,30);
        reason.setFont(new Font("Sans Serif",Font.PLAIN,18));
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
        add(reason);
        add(ok);

        setVisible(true);
    }
}

public class PaymentWindow extends javax.swing.JDialog {
    private int user_id,house_id;
    private OrderInfo order_info;

    public PaymentWindow(int user_id,int house_id,OrderInfo order_info) {
        super((Window)null);
        setModal(true);

        this.user_id = user_id;
        this.house_id = house_id;
        this.order_info = order_info;

        setTitle("Perform Bank Transaction");
        setResizable(false);
        initComponents();
        PaymentController.fill_details(this, house_id);

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

        card_num_input.setDocument(new LengthRestrictedDocument(16));

        cvv_label.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cvv_label.setText("CVV ");

        cvv_input.setDocument(new LengthRestrictedDocument(3));
        cvv_input.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cvv_inputActionPerformed(evt);
            }
        });

        expiry_label.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        expiry_label.setText("Expiry Date");

        UtilDateModel model = new org.jdatepicker.impl.UtilDateModel();
        JDatePanelImpl datePanel = new org.jdatepicker.impl.JDatePanelImpl(model, new Properties());
        datePicker = new JDatePickerImpl(datePanel,new DateLabelFormatter());
        
        pay_button.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        // String amount="1234";
        pay_button.setText("Pay Rs.0");
        PaymentWindow this_window=this;
        pay_button.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                System.out.println("Payment Button clicked");
                if(card_num_input.getText().length()<16)
                {
                    javax.swing.JDialog ccnum_fail= new JDialog();
                    ccnum_fail.setLayout(null);
                    JLabel fail_message=new JLabel("Credit Card number must be a 16 digit number");
                    fail_message.setFont(new Font("Sans Serif",0, 15));
                    fail_message.setBounds(20,2,350,50);
                    ccnum_fail.add(fail_message);
                    ccnum_fail.setSize(380,150);
                    ccnum_fail.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
                    ccnum_fail.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                    ccnum_fail.setVisible(true);
                }
                else if(cvv_input.getText().length()<3)
                {
                    javax.swing.JDialog cvv_fail= new JDialog();
                    cvv_fail.setLayout(null);
                    JLabel fail_message=new JLabel("CVV must be a 3 digit number");
                    fail_message.setFont(new Font("Sans Serif",0, 15));
                    fail_message.setBounds(50,2,300,50);
                    cvv_fail.add(fail_message);
                    cvv_fail.setSize(325,150);
                    cvv_fail.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
                    cvv_fail.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                    cvv_fail.setVisible(true);
                }
                else{
                    int payment_result = PaymentController.handle_payment(PaymentWindow.this, house_id, user_id, order_info);
                    if(payment_result >=1 && payment_result <= 5){
                        // Payment Failed.
                        String error_message = "";
                        if(payment_result == 1) error_message = "Card doesn't exist";
                        else if(payment_result == 2) error_message = "CVV not correct!";
                        else if(payment_result == 3) error_message = "expiry date incorrect!";
                        else if(payment_result == 4) error_message = "Insufficient balance!";
                        else error_message = "Error while processing!";

                        failure_dialogue popup = new failure_dialogue(error_message);
                    }else{
                        Success_dialogue popup = new Success_dialogue(String.valueOf(payment_result), this_window);
                    }
                    // Boolean payment_result=true;//Do controller processing of payment here and return whether it succeeded
                //     if(payment_result){
                //         try {
                //             Success_dialogue dialog = new Success_dialogue("1234",this_window);
                //             dialog.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
                //             dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                //             dialog.setVisible(true);
                //         } catch (Exception ex) {
                //             ex.printStackTrace();
                //         }
                //     }
                //     else
                //     {
                //         try {
                //             failure_dialogue dialog = new failure_dialogue("1234");
                //             dialog.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
                //             dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                //             dialog.setVisible(true);
                //         } catch (Exception ex) {
                //             ex.printStackTrace();
                //         }
                //     }
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
                                        .addComponent(datePicker, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                                .addComponent(datePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    public static void main(String args[]) throws Exception {
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
        OrderInfo info = new OrderInfo();
        info.num_days_of_stay = 1;
        info.num_people = 1;
        info.date_of_accomodation =new SimpleDateFormat("dd/mm/yyyy").parse("11/11/1111");
         java.awt.EventQueue.invokeLater(new Runnable() {
             public void run() {
                 new PaymentWindow(1,1,info);
             }
         });
    }

    // Variables declaration - do not modify
    public javax.swing.JLabel card_no_prompt;
    public javax.swing.JLabel cc_text;
    public javax.swing.JComboBox<String> credit_card_choose;
    public javax.swing.JLabel cvv_label;
    public javax.swing.JLabel expiry_label;
    public javax.swing.JTextField card_num_input;
    public javax.swing.JTextField cvv_input;
    public javax.swing.JButton pay_button;
    public JDatePickerImpl datePicker;
}
