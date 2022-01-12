package views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.border.LineBorder;

import model.OrderInfo;

public class HouseTile extends JPanel{
    public int id;
    public HouseTile(int id,String name,double price,
                     String photo_name,int user_id,
                     OrderInfo order_info){
        this.id = id;
        setLayout(null);
        setBackground(Color.WHITE);
        setPreferredSize(new Dimension(800, 100));
            
            // MouseListener ml = new MouseAdapter(){
            //     @Override
            //     public void mousePressed(MouseEvent e){
            //         int house_id = (Integer)house_tray.get(i)[0];
            //         System.out.println("The house");
            //         HouseInfoWindow info_win = new HouseInfoWindow(user_id, 
            //                                   house_id, order_info); 
            //     }
            // };
            // sp1.addMouseListener(ml);

           // if(i<t){
            //if(bookaroom.el.isSelected())
                //h1 = new JLabel("ELITE HOUSE "+i);
            //else
            JLabel h1 = new JLabel(name);
            h1.setFont(new Font("Tahoma", Font.PLAIN, 24));
            h1.setBounds(290, 30, 171, 62);
            add(h1);

            JLabel pic;
            try{
                BufferedImage myPicture = ImageIO.read(new File("src\\util\\images\\"+photo_name));
                pic = new JLabel(new ImageIcon(myPicture));
            }
            catch(Exception e) {
                pic = new JLabel("No Image");
            }
            pic.setBounds(20, 30, 250, 250);
            add(pic);
            
            JLabel cpd = new JLabel("Cost per day: Rs."+price);
            cpd.setFont(new Font("Tahoma", Font.PLAIN, 18));
            cpd.setBounds(290, 100, 250, 48);
            add(cpd);
            
            JButton loc_btn = new JButton("Open Location in Map");
            loc_btn.setBounds(290, 170, 171, 39);
            add(loc_btn);

            
            JButton buy_btn = new JButton("Buy Now");
            buy_btn.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    //Action to open the billing window
                    OrderSummaryWindow sum_win = new OrderSummaryWindow(user_id, 
                    id, order_info);
                }
            });
            buy_btn.setBounds(600, 40, 100, 40);
            add(buy_btn);
            
            setBorder(new LineBorder(Color.BLACK,2));

            MouseListener ml = new MouseAdapter(){
                @Override
                public void mousePressed(MouseEvent e){
                    HouseInfoWindow info_win = new HouseInfoWindow(user_id, 
                                                id, order_info); 
                }
            };
            addMouseListener(ml);
        }
}
