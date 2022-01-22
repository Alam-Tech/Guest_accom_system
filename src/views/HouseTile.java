package views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.border.LineBorder;

import controller.HouseTileController;
import controller.PurposeSelector.Purpose;
import model.OrderInfo;
import views.popups.CancelationPopup;
import views.popups.ConfirmCancel;

public class HouseTile extends JPanel{
    private int id;
    private ResultWindow parent_win;
    // public HouseTile(int id,String name,double price,
    //                  String photo_name,int user_id,
    //                  OrderInfo order_info, ResultWindow result){
    public HouseTile(Purpose purpose,Object[] data_tray,int user_id,
                     OrderInfo order_info, ResultWindow result){
        this.id = (Integer)data_tray[0];
        this.parent_win = result;

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
            JLabel h1 = new JLabel((String)data_tray[1]);
            h1.setFont(new Font("Tahoma", Font.PLAIN, 24));
            h1.setBounds(290, 30, 171, 62);
            add(h1);

            JLabel pic;
            try{
                BufferedImage myPicture = ImageIO.read(new File("src\\util\\images\\"+data_tray[3]));
                pic = new JLabel(new ImageIcon(myPicture));
            }
            catch(Exception e) {
                pic = new JLabel("No Image");
            }
            pic.setBounds(20, 30, 250, 250);
            add(pic);
            
            JLabel cpd = new JLabel("");
            if(purpose == Purpose.Booking){
                cpd = new JLabel("Cost per day: Rs."+data_tray[2]);
            }else{
                cpd = new JLabel(data_tray[4]+" to "+data_tray[5]);
            }
            cpd.setFont(new Font("Tahoma", Font.PLAIN, 18));
            cpd.setBounds(290, 100, 250, 48);
            add(cpd);
            
            if(purpose == Purpose.Booking){
                JButton loc_btn = new JButton("Open Location in Map");
                loc_btn.setBounds(290, 170, 171, 39);
                add(loc_btn);
            }else{
                JLabel member_label = new JLabel(data_tray[2]+" members");
                member_label.setFont(new Font("Tahoma", Font.PLAIN, 14));
                member_label.setBounds(290,170,150,30);  
                add(member_label);
            }

            if(purpose == Purpose.Booking){
                JButton buy_btn = new JButton("Buy Now");
                buy_btn.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        //Action to open the billing window
                        OrderSummaryWindow sum_win = new OrderSummaryWindow(user_id, 
                        id, order_info, null, result);
                    }
                });
                buy_btn.setBounds(600, 40, 100, 40);
                add(buy_btn);

                MouseListener ml = new MouseAdapter(){
                    @Override
                    public void mousePressed(MouseEvent e){
                        HouseInfoWindow info_win = new HouseInfoWindow(user_id, id, order_info, result);
                    }
                };
                addMouseListener(ml);
            }else if(purpose == Purpose.CancelBooking){
                JButton cancel_btn = new JButton("Cancel");
                cancel_btn.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        HouseTileController controller = new HouseTileController();
                        
                        ConfirmCancel popup = new ConfirmCancel();
                        int result = controller.handle_cancel(popup, id);
                        if(result > 0){
                            boolean is_positive = false;
                            String message = "Dummy message";
                            if(result == 1) message = "No Booking record as such!";
                            else if(result == 2) message = "Cancellation not permitted!";
                            else if(result == 3) message = "Payment record doesnt't exist!";
                            else if(result == 4) message = "Amount refunding failed!";
                            else if(result == 5) message = "Unable to register refund transaction!";
                            else if(result == 6){
                                is_positive = true;
                                message = "Succesfully cancelled, amount refunded!";
                            }
                            parent_win.dispose();
                            CancelationPopup pop = new CancelationPopup(is_positive, message);
                        }
                        // if(result == 1 || result == -1){
                        //     parent_win.dispose();
                        //     if(result == 1) System.out.println("The cancellation was succesful!");
                        //     else System.out.println("The cancellation wasn't succesful!");
                        // }
                        // System.out.println("Delete button pressed");
                    }
                });
                cancel_btn.setBounds(600, 40, 100, 40);
                add(cancel_btn);
            }else{
                JLabel status_msg = new JLabel("Status: "+data_tray[6]);
                status_msg.setFont(new Font("Sans Serif",Font.BOLD,16));
                status_msg.setBounds(600,40,150,30);
                add(status_msg);
            }
            
            setBorder(new LineBorder(Color.BLACK,2));
        }
}
