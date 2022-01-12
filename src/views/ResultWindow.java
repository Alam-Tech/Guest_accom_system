package views;

import javax.swing.*;
import java.awt.*;
import java.util.*;

import model.OrderInfo;

public class ResultWindow extends JFrame{
    int size;
    JPanel p1,p2,cp,sp1;
    JLabel li,cpd,h1,pic;
    JScrollPane sp;
    private int i;
    
    public ResultWindow(int user_id,ArrayList<Object[]> house_tray,OrderInfo order_info) {
        setBackground(new java.awt.Color(204, 204, 204));
        setTitle("Results");
        p1 = new JPanel();
        p1.setLayout(new FlowLayout());
        p1.setBackground(Color.WHITE);
        p1.setPreferredSize(new Dimension(800, 100));
        li = new JLabel("Available Rooms");
        li.setForeground(Color.BLACK);
        li.setPreferredSize(new Dimension(800, 50));
        li.setFont(new Font("Tahoma", Font.BOLD, 30));
        p1.add(li);
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
        cp = new JPanel(new BorderLayout());
        cp.setPreferredSize(new Dimension(800, 800));
        cp.add(sp, BorderLayout.CENTER);
        
        for (i = 0; i < house_tray.size(); i++) {
            HouseTile temp = new HouseTile(
                (Integer)house_tray.get(i)[0], (String)house_tray.get(i)[1], 
                (Double)house_tray.get(i)[2],(String)house_tray.get(i)[3],
                user_id, order_info);
            p2.add(temp);
        }
        cp.add(p1, BorderLayout.NORTH);
        add(cp);
        setSize(820, 820);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

     public static void main(String args[]){
         try {
             for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                 if ("Nimbus".equals(info.getName())) {
                     javax.swing.UIManager.setLookAndFeel(info.getClassName());
                     break;
                 }
             }
         } catch (ClassNotFoundException ex) {
             java.util.logging.Logger.getLogger(Bookaroom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
         } catch (InstantiationException ex) {
             java.util.logging.Logger.getLogger(Bookaroom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
         } catch (IllegalAccessException ex) {
             java.util.logging.Logger.getLogger(Bookaroom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
         } catch (javax.swing.UnsupportedLookAndFeelException ex) {
             java.util.logging.Logger.getLogger(Bookaroom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
         }
         //ResultWindow sample_win = new ResultWindow();
     }
}

