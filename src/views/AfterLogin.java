package views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class AfterLoginGui extends JFrame implements ActionListener{
    JLabel x,y;
    JButton br,yb,cb,pb,lo;
    String username = "User";
    AfterLoginGui(){
        setTitle("After Login");
        x = new JLabel("Welcome "+username);
        x.setBounds(20,20,500,50);
        x.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(x);
        y = new JLabel("How can we help you?");
        y.setBounds(50,50,500,50);
        y.setFont(new Font("Tahoma", Font.PLAIN, 15));
        add(y);
        br = new JButton("Book a Room");
        br.setBounds(140, 90, 130, 23);
        br.setFont(new Font("Tahoma", Font.PLAIN, 15));
        add(br);
        yb = new JButton("Your Bookings");
        yb.setBounds(140, 130, 130, 23);
        yb.setFont(new Font("Tahoma", Font.PLAIN, 15));
        add(yb);
        cb = new JButton("Cancel Booking");
        cb.setBounds(140, 170, 130, 23);
        cb.setFont(new Font("Tahoma", Font.PLAIN, 15));
        add(cb);
        pb = new JButton("Previous Booking");
        pb.setBounds(140, 210, 150, 23);
        pb.setFont(new Font("Tahoma", Font.PLAIN, 15));
        add(pb);
        lo = new JButton("Logout");
        lo.setBounds(300, 50, 100, 23);
        lo.setFont(new Font("Tahoma", Font.PLAIN, 12));
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
        }
        if(e.getSource()==br){
            //Book a room
            dispose();
            bookaroom b = new bookaroom();
        }
        if(e.getSource()==yb){
            //your booking
            dispose();
        }
        if(e.getSource()==cb){
            //cancel booking
            System.exit(0);
        }
        if(e.getSource()==pb){
            //previous booking
            dispose();
        }
    }
}
public class AfterLogin {
    public static void main(String[] args) {

            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    try {
                        UIManager.setLookAndFeel(info.getClassName());
                    } catch (ClassNotFoundException e) {
                        System.out.println("Error!!! "+e);
                    } catch (InstantiationException e) {
                        System.out.println("Error!!! "+e);
                    } catch (IllegalAccessException e) {
                        System.out.println("Error!!! "+e);
                    } catch (UnsupportedLookAndFeelException e) {
                        System.out.println("Error!!! "+e);
                    }
                    break;
                }
            }

        AfterLoginGui g = new AfterLoginGui();
    }
}
