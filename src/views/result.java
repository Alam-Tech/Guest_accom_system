package views;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.LineBorder;

class search extends JFrame implements ActionListener {
    int t= bookaroom.count2;
    JPanel p1,p2,cp,sp1;
    JLabel li,cpd,h1,pic;
    JScrollPane sp;
    JButton[] bn = new JButton[3];
    JButton[] loc = new JButton[3];
    search() {
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
        p2.setPreferredSize(new Dimension(800, 1000));
        p2.setAutoscrolls(true);
        sp = new JScrollPane(p2);
        sp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        sp.setBounds(0, 0, 800, 1300);
        cp = new JPanel(new BorderLayout());
        cp.setPreferredSize(new Dimension(800, 800));
        cp.add(sp, BorderLayout.CENTER);

        for (int i = 0; i < 3; i++) {
            sp1 = new JPanel();
            sp1.setLayout(null);
            sp1.setBackground(Color.WHITE);
            sp1.setPreferredSize(new Dimension(700, 200));
           // if(i<t){
            if(bookaroom.el.isSelected())
                h1 = new JLabel("ELITE HOUSE "+i);
            else
                h1 = new JLabel("HOUSE "+i);
            h1.setFont(new Font("Tahoma", Font.PLAIN, 24));
            sp1.add(h1);
            h1.setBounds(290, 30, 171, 62);
            String x = "wp3719616-1980s-wallpapers.jpg";
            try{
                BufferedImage myPicture = ImageIO.read(new File("src\\util\\images\\"+x));
                pic = new JLabel(new ImageIcon(myPicture));
                pic.setBounds(20, 30, 250, 250);
                sp1.add(pic);
            }
            catch(Exception e) {
                System.out.println("Image not available");
            }
            cpd = new JLabel("Cost per day");
            cpd.setFont(new Font("Tahoma", Font.PLAIN, 18));
            sp1.add(cpd);
            cpd.setBounds(290, 100, 171, 48);
            loc[i] = new JButton("Open Location in Map");
            sp1.add(loc[i]);
            loc[i].setBounds(290, 170, 171, 39);
            bn[i] = new JButton("Buy Now");
            sp1.add(bn[i]);
            bn[i].addActionListener(this);
            bn[i].setBounds(510, 40, 100, 40);
                sp1.setBorder(new LineBorder(Color.BLACK));
           // }
           // else
             //   sp1.setBorder(new LineBorder(Color.WHITE));
            p2.add(sp1);
        }
        cp.add(p1, BorderLayout.NORTH);
        add(cp);
        setSize(850, 850);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==bn[0]){
            //BUY NOW 0
        }
        if(e.getSource()==bn[1]){
            //BUY NOW 1
        }
        if(e.getSource()==bn[2]){
            //BUY NOW 2
        }
    }
}

