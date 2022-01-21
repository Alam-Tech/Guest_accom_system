package views;

import javax.imageio.ImageIO;

import controller.HouseInfoController;

import java.awt.image.BufferedImage;
import java.io.File;

import model.OrderInfo;

public class HouseInfoWindow extends javax.swing.JFrame {
    private int user_id,house_id;
    private OrderInfo order_info;
    public HouseInfoWindow(int user_id,int house_id,OrderInfo order_info, ResultWindow result) {
        setResizable(false);
        initComponents(result);
        HouseInfoController.fill_details(this, house_id);
        
        this.user_id = user_id;
        this.house_id = house_id;
        this.order_info = order_info;

        setVisible(true);
    }

    private void initComponents(ResultWindow result) {
        Book_button = new javax.swing.JButton();
        Map_house = new javax.swing.JButton();
        house_name = new javax.swing.JLabel();
        house_rate = new javax.swing.JLabel();
        house_image = new javax.swing.JLabel();
        Accessory_heading = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        AccessoryList = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        Distances_list = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 204));

        HouseInfoWindow house_window = this;
        Book_button.setText("Book Now");
        Book_button.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //System.out.println("Button clicked");
                OrderSummaryWindow Order_window = new OrderSummaryWindow(
                    user_id,house_id,order_info, house_window, result
                );
                //Book_buttonActionPerformed(evt);
            }
        });

        Map_house.setText("Locate in Map");

        house_name.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        house_name.setText("N/A");

        house_rate.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        house_rate.setText("Cost per day: N/A");
        
        // try{
        // BufferedImage myPicture = ImageIO.read(new File("src\\util\\images\\sample_house.jpg"));
        // house_image.setIcon(new javax.swing.ImageIcon(myPicture)); // NOI18N
        // house_image.setText("jLabel4");
        // }catch(Exception e) {house_image.setText("Image not available");}

        Accessory_heading.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Accessory_heading.setText("Accessories in house: ");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("House Details");

        AccessoryList.setEditable(false);
        AccessoryList.setBackground(new java.awt.Color(246, 246, 246));
        AccessoryList.setColumns(20);
        AccessoryList.setRows(5);
        AccessoryList.setBorder(null);
        jScrollPane2.setViewportView(AccessoryList);

        Distances_list.setEditable(false);
        Distances_list.setBackground(new java.awt.Color(246, 246, 246));
        Distances_list.setColumns(20);
        Distances_list.setRows(5);
        Distances_list.setBorder(null);
        jScrollPane3.setViewportView(Distances_list);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(Book_button, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(Accessory_heading, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(house_image, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(29, 29, 29)
                                                                .addComponent(Map_house))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(28, 28, 28)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                        .addComponent(house_name, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(house_rate, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                                .addContainerGap(168, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(25, 25, 25)
                                                .addComponent(jLabel1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(house_image, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(67, 67, 67)
                                                .addComponent(house_name, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(house_rate, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(Map_house)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                                .addComponent(Accessory_heading)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(Book_button, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28))
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
            java.util.logging.Logger.getLogger(HouseInfoWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HouseInfoWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HouseInfoWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HouseInfoWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HouseInfoWindow(1,1,null,null).setVisible(true);
            }
        });
    }

    // Variables declaration
    public javax.swing.JTextArea AccessoryList;
    public javax.swing.JLabel Accessory_heading;
    public javax.swing.JButton Book_button;
    public javax.swing.JTextArea Distances_list;
    public javax.swing.JLabel house_name;
    public javax.swing.JLabel house_rate;
    public javax.swing.JButton Map_house;
    public javax.swing.JLabel house_image;
    public javax.swing.JLabel jLabel1;
    public javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JScrollPane jScrollPane3;
    public BufferedImage myPicture;
}

