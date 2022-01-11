package views;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class order_summary extends javax.swing.JFrame {
    public order_summary() {
        initComponents();
        setVisible(true);
    }
    private void initComponents() {

        Bill_heading = new javax.swing.JLabel();
        house_image = new javax.swing.JLabel();
        house_name = new javax.swing.JLabel();
        Price = new javax.swing.JLabel();
        accom_date = new javax.swing.JLabel();
        days_of_stay = new javax.swing.JLabel();
        ppl_count = new javax.swing.JLabel();
        booking_date = new javax.swing.JLabel();
        booked_by_label = new javax.swing.JLabel();
        Bill_id = new javax.swing.JLabel();
        payment_button = new javax.swing.JButton();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        Bill_heading.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Bill_heading.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Bill_heading.setText("Billing Information");

        try{
            BufferedImage myPicture = ImageIO.read(new File("src\\util\\images\\house1.jpg"));
            house_image.setIcon(new javax.swing.ImageIcon(myPicture)); // NOI18N
            house_image.setText("jLabel4");
        }catch(Exception e) {System.out.println("Image not available");}
        house_image.setText("jLabel1");

        house_name.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        house_name.setText("House Name");

        Price.setText("Price: Rs.160 per day");

        accom_date.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        accom_date.setText("Date of Accomodation: dd/mm/yyyy");

        days_of_stay.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        days_of_stay.setText("Days of Stay: 9999");

        ppl_count.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ppl_count.setText("Number of People: 999");

        booking_date.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        booking_date.setText("Date of Booking: timestamp");

        booked_by_label.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        booked_by_label.setText("Booked By: \"username\"");

        Bill_id.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Bill_id.setText("Bill ID: 19932");

        payment_button.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        payment_button.setText("Make Payment");
        payment_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //payment_buttonActionPerformed(evt);
                Payment_window new_window= new Payment_window();
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(40, 40, 40)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(house_image, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(52, 52, 52)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                        .addComponent(house_name, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(Price)))
                                                        .addComponent(Bill_heading)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                                .addComponent(Bill_id, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(booked_by_label, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(accom_date, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 331, Short.MAX_VALUE)
                                                                .addComponent(days_of_stay, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(ppl_count, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(booking_date, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(181, 181, 181)
                                                .addComponent(payment_button)))
                                .addContainerGap(76, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(Bill_heading)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(house_image, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(37, 37, 37)
                                                .addComponent(house_name, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(Price)))
                                .addGap(49, 49, 49)
                                .addComponent(accom_date)
                                .addGap(18, 18, 18)
                                .addComponent(days_of_stay)
                                .addGap(18, 18, 18)
                                .addComponent(ppl_count)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(booking_date)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(booked_by_label)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Bill_id)
                                .addGap(37, 37, 37)
                                .addComponent(payment_button)
                                .addContainerGap(39, Short.MAX_VALUE))
        );

        pack();
    }

    private void payment_buttonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        Payment_window new_window= new Payment_window();
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
            java.util.logging.Logger.getLogger(order_summary.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(order_summary.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(order_summary.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(order_summary.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new order_summary();
            }
        });
    }

    // Variables declaration
    private javax.swing.JLabel Bill_heading;
    private javax.swing.JLabel Bill_id;
    private javax.swing.JLabel Price;
    private javax.swing.JLabel accom_date;
    private javax.swing.JLabel booked_by_label;
    private javax.swing.JLabel booking_date;
    private javax.swing.JLabel days_of_stay;
    private javax.swing.JLabel house_image;
    private javax.swing.JLabel house_name;
    private javax.swing.JButton payment_button;
    private javax.swing.JLabel ppl_count;
}
