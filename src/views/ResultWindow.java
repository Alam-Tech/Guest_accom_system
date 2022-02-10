package views;

import javax.swing.*;
import java.awt.*;
import java.util.*;

import controller.PurposeSelector;
import controller.PurposeSelector.Purpose;
import model.OrderInfo;

public class ResultWindow extends JFrame{
    int size;
    JPanel p1,p2,cp,sp1;
    JLabel li,cpd,h1,pic;
    JScrollPane sp;
    private int i;
    
    public ResultWindow(PurposeSelector.Purpose purpose, int user_id,
                        ArrayList<Object[]> house_tray,OrderInfo order_info) {
        setResizable(false);
        setBackground(new java.awt.Color(204, 204, 204));

        p1 = new JPanel();
        p1.setLayout(new FlowLayout());
        p1.setPreferredSize(new Dimension(800, 100));

        
        if(purpose == Purpose.Booking){
            setTitle("Results");
            li = new JLabel("Available Houses");
        }else if(purpose == Purpose.ViewActiveBooking){
            setTitle("Active Bookings");
            li = new JLabel("Your current bookings");
        }
        else if(purpose == Purpose.ViewPrevBooking){
            setTitle("Booking history");
            li = new JLabel("Your previous bookings");
        }
        else if(purpose == Purpose.CancelBooking){
            setTitle("Cancel bookings");
            li = new JLabel("Your current bookings");
        }else{
            setTitle("At your service");
            li = new JLabel("");
        }
        
        li.setForeground(Color.BLACK);
        li.setPreferredSize(new Dimension(800, 50));
        li.setFont(new Font("Tahoma", Font.BOLD, 30));
        p1.add(li);
        
        cp = new JPanel(new BorderLayout());
        cp.setPreferredSize(new Dimension(800, 800));

        if(house_tray.isEmpty()){
            JLabel empty_message = new JLabel("There are no items!");
            empty_message.setFont(new Font("Sans Serif",Font.PLAIN,24));
            empty_message.setBounds(100, 200, 450, 40);            
            p1.add(empty_message);
        }else{
            p2 = new JPanel();
            p2.setLayout(new GridLayout(-1, 1));
            p2.setBackground(Color.WHITE);
            size = house_tray.size() * 300;
            p2.setPreferredSize(new Dimension(800, size));
            p2.setAutoscrolls(true);
            sp = new JScrollPane(p2);
            sp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
            sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
            sp.setBounds(0, 0, 800, 1000);
        
            cp.add(sp, BorderLayout.CENTER);

            for (i = 0; i < house_tray.size(); i++) {
                HouseTile temp = new HouseTile(purpose,house_tray.get(i),
                                               user_id,order_info,this);
                p2.add(temp);
            }
        }

        cp.add(p1, BorderLayout.NORTH);
        add(cp);
        setSize(820, 820);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }
}

