package views;

import controller.OrderInfoController;

public class OrderInfoWindow extends javax.swing.JFrame {
    private OrderInfoController controller = new OrderInfoController();

    public OrderInfoWindow(int bill_id_num) {
        setTitle("Booking summary");
        initComponents(bill_id_num);
        controller.fill_details(this, bill_id_num);
        setVisible(true);
    }

    private void initComponents(int bill_id) {

        Bill_ID = new javax.swing.JLabel();
        house_image = new javax.swing.JLabel();
        House_name = new javax.swing.JLabel();
        Booked_by = new javax.swing.JLabel();
        User_name = new javax.swing.JLabel();
        Occupant_count = new javax.swing.JLabel();
        date_range = new javax.swing.JLabel();
        Day_count = new javax.swing.JLabel();
        Amt_paid = new javax.swing.JLabel();
        CCnum = new javax.swing.JLabel();
        Date_paid = new javax.swing.JLabel();
        // Ok_button = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        Bill_ID.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Bill_ID.setText("Bill ID: "+ bill_id);

        House_name.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        House_name.setText("House Name");

        Booked_by.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Booked_by.setText("Booked By:");

        User_name.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        User_name.setText("Username");

        Occupant_count.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Occupant_count.setText("No. of Occupants: ");

        date_range.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        date_range.setText("Period of Stay: ");
        date_range.setToolTipText("");

        Day_count.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Day_count.setText("No. of Days of Stay: ");

        Amt_paid.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Amt_paid.setText("Amount Paid: ");

        CCnum.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        CCnum.setText("Credit Card Number: ");

        Date_paid.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Date_paid.setText("Paid on: ");
        Date_paid.setToolTipText("");

        // Ok_button.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        // Ok_button.setText("OK");
        // Ok_button.addActionListener(new java.awt.event.ActionListener() {
        //     @Override
        //     public void actionPerformed(java.awt.event.ActionEvent evt)
        //     {
        //         dispose();
        //     }
        // });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(23, 23, 23)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                .addComponent(User_name)
                                                                .addGroup(layout.createSequentialGroup()
                                                                        .addComponent(house_image, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addGap(36, 36, 36)
                                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(House_name)
                                                                                .addComponent(Booked_by))))
                                                        .addComponent(Occupant_count)
                                                        .addComponent(date_range)
                                                        .addComponent(Day_count)
                                                        .addComponent(Amt_paid)
                                                        .addComponent(CCnum)
                                                        .addComponent(Date_paid)
                                                        .addComponent(Bill_ID)))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(197, 197, 197)
                                                // .addComponent(Ok_button)
                                                ))
                                .addContainerGap(133, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(Bill_ID)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(house_image, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(23, 23, 23)
                                                .addComponent(House_name)
                                                .addGap(18, 18, 18)
                                                .addComponent(Booked_by)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(User_name)))
                                .addGap(34, 34, 34)
                                .addComponent(Occupant_count)
                                .addGap(18, 18, 18)
                                .addComponent(date_range)
                                .addGap(18, 18, 18)
                                .addComponent(Day_count)
                                .addGap(18, 18, 18)
                                .addComponent(Amt_paid)
                                .addGap(18, 18, 18)
                                .addComponent(CCnum)
                                .addGap(18, 18, 18)
                                .addComponent(Date_paid)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                // .addComponent(Ok_button)
                                .addContainerGap(17, Short.MAX_VALUE))
        );

        pack();
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
            java.util.logging.Logger.getLogger(OrderInfoWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OrderInfoWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OrderInfoWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OrderInfoWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OrderInfoWindow(1).setVisible(true);
            }
        });
    }

    // Variables declaration
    public javax.swing.JLabel Amt_paid;
    public javax.swing.JLabel Bill_ID;
    public javax.swing.JLabel Booked_by;
    public javax.swing.JLabel CCnum;
    public javax.swing.JLabel Date_paid;
    public javax.swing.JLabel Day_count;
    public javax.swing.JLabel House_name;
    public javax.swing.JLabel Occupant_count;
    // public javax.swing.JButton Ok_button;
    public javax.swing.JLabel User_name;
    public javax.swing.JLabel date_range;
    public javax.swing.JLabel house_image;
}
