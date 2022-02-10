package views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import controller.AfterLoginController;
import controller.PurposeSelector.Purpose;

public class AfterLogin extends JFrame implements ActionListener{
    private AfterLoginController controller = new AfterLoginController();
    private int user_id;
    JLabel x,y;
    JButton br,yb,cb,pb,lo;
    
    public AfterLogin(String user_name,int user_id){
        this.user_id = user_id;
        setTitle("Welcome!");
        setResizable(false);

        x = new JLabel("Welcome "+user_name);
        x.setBounds(20,20,500,50);
        x.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(x);
        y = new JLabel("How can we help you?");
        y.setBounds(50,50,500,50);
        y.setFont(new Font("Tahoma", Font.PLAIN, 15));
        add(y);

        br = new JButton("Book a Room");
        br.setBounds(140, 90, 130, 30);
        br.setFont(new Font("Tahoma", Font.PLAIN, 15));
        add(br);

        yb = new JButton("Your Bookings");
        yb.setBounds(140, 130, 130, 30);
        yb.setFont(new Font("Tahoma", Font.PLAIN, 15));
        add(yb);

        cb = new JButton("Cancel Booking");
        cb.setBounds(140, 170, 130, 30);
        cb.setFont(new Font("Tahoma", Font.PLAIN, 15));
        add(cb);
        pb = new JButton("Previous Booking");
        pb.setBounds(140, 210, 150, 30);
        pb.setFont(new Font("Tahoma", Font.PLAIN, 15));
        add(pb);
        lo = new JButton("Logout");
        lo.setBounds(300, 50, 100, 30);
        lo.setFont(new Font("Tahoma", Font.PLAIN, 15));
        add(lo);
        setLayout(null);
        setSize(500,300);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setBackground(Color.WHITE);
        br.addActionListener(this);
        yb.addActionListener(this);
        cb.addActionListener(this);
        pb.addActionListener(this);
        lo.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==lo){
            //LOGOUT
            dispose();
            LoginWindow login_win = new LoginWindow();
        }
        if(e.getSource()==br){
            Bookaroom pref_win = new Bookaroom(user_id);
        }
        if(e.getSource()==yb){
            ArrayList<Object[]> active_bookings = controller.get_active_bookings(user_id);
            ResultWindow result_win = new ResultWindow(Purpose.ViewActiveBooking, user_id,
                                                       active_bookings, null);
        }
        if(e.getSource()==cb){
            ArrayList<Object[]> active_bookings = controller.get_active_bookings(user_id);
            ResultWindow result_win = new ResultWindow(Purpose.CancelBooking, user_id,
                                                       active_bookings, null);
        }
        if(e.getSource()==pb){
            ArrayList<Object[]> prev_bookings = controller.get_previous_bookings(user_id);
            ResultWindow result_win = new ResultWindow(Purpose.ViewPrevBooking, user_id,
                                                       prev_bookings, null);
        }
    }
}