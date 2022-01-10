package views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class bookaroom extends JFrame implements ActionListener {
    static JCheckBox ac;
    JLabel bath,date,op,nop,nor,pref,toh,nos;
    ButtonGroup bg,bg2;
    JComboBox<String> cb,day,mon,yr,days;
    static JRadioButton el,n,no,s;
    JCheckBox fr,gy,mg,ki,mo,sw,wm;
    JButton sh,click;
    static int count1;
    static int count2=0;
    bookaroom(){
        setTitle("Book a Room");
        bg = new ButtonGroup();
        bg2 = new ButtonGroup();
        nop = new JLabel("No of People:");
        nop.setFont(new Font("Tahoma", Font.PLAIN, 12));
        add(nop);
        nop.setBounds(50, 20, 80, 40);
        cb = new JComboBox<>();
        cb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10","11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30" }));
        add(cb);
        cb.setBounds(140, 30, 40, 19);
        toh = new JLabel("Type of house:");
        toh.setFont(new Font("Tahoma", Font.PLAIN, 12));
        add(toh);
        toh.setBounds(50, 60, 90, 40);
        el = new JRadioButton("Elite");
        bg.add(el);
        add(el);
        el.setBounds(140, 70, 60, 21);
        no = new JRadioButton("Normal");
        bg.add(no);
        add(no);
        no.setBounds(210, 70, 70, 21);
        pref = new JLabel("Preferrable Facilities:");
        pref.setFont(new Font("Tahoma", Font.PLAIN, 12));
        add(pref);
        pref.setBounds(50, 130, 110, 15);
        fr = new JCheckBox("Fridge");
        add(fr);
        fr.setBounds(110, 160, 80, 21);
        wm = new JCheckBox("Washing Machine");
        add(wm);
        wm.setBounds(110, 190, 150, 21);
        mo = new JCheckBox("Microwave Oven");
        getContentPane().add(mo);
        mo.setBounds(110, 220, 150, 21);
        ac = new JCheckBox("Air Conditioner");
        add(ac);
        ac.setBounds(110, 250, 140, 21);
        ki = new JCheckBox("Kitchen");
        add(ki);
        ki.setBounds(110, 280, 80, 21);
        date = new JLabel("Date of Accomodation:");
        date.setFont(new Font("Tahoma", Font.PLAIN, 12));
        add(date);
        date.setBounds(50, 320, 130, 15);
        day = new JComboBox<>();
        day.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        add(day);
        day.setBounds(190, 320, 50, 19);
        mon = new JComboBox<>();
        mon.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
        add(mon);
        mon.setBounds(260, 320, 50, 19);
        yr = new JComboBox<>();
        yr.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2022", "2023", "2024" }));
        add(yr);
        yr.setBounds(330, 320, 60, 19);
        nos = new JLabel("No of days of stay:");
        nos.setFont(new Font("Tahoma", Font.PLAIN, 12)); // NOI18N
        add(nos);
        nos.setBounds(50, 370, 110, 30);
        days = new JComboBox<>();
        days.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30" }));
        getContentPane().add(days);
        days.setBounds(180, 380, 50, 19);
        nor = new JLabel("No of Rooms required: ");
        nor.setFont(new Font("Tahoma", Font.PLAIN, 12));
        add(nor);
        nor.setBounds(50, 420, 150, 20);
        click = new JButton("Click");
        add(click);
        click.setBounds(220,420,80,20);
        bath = new JLabel("Do you prefer Attached Bathroom?");
        bath.setFont(new Font("Tahoma", Font.PLAIN, 12));
        add(bath);
        bath.setBounds(50, 470, 190, 20);
        s = new JRadioButton("Yes");
        bg2.add(s);
        add(s);
        s.setBounds(250, 470, 50, 21);
        n = new JRadioButton("No");
        bg2.add(n);
        add(n);
        n.setBounds(310, 470, 60, 21);
        op = new JLabel("Other Preferences:");
        op.setFont(new Font("Tahoma", Font.PLAIN, 12));
        add(op);
        op.setBounds(50, 520, 110, 20);
        sw = new JCheckBox("House near swimming pool");
        add(sw);
        sw.setBounds(110, 550, 180, 21);
        gy = new JCheckBox("House near gym");
        add(gy);
        gy.setBounds(110, 580, 150, 21);
        mg = new JCheckBox("House near main gate");
        add(mg);
        mg.setBounds(110, 610, 180, 21);
        sh = new JButton("Search House");
        add(sh);
        sh.setBounds(150, 670, 140, 21);

        setLayout(null);
        setSize(450,800);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setBackground(Color.WHITE);

        click.addActionListener(this);
        sh.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==click){
           count1= Integer.parseInt((String) cb.getSelectedItem());
           count2 = count1/3;
           if(count1%3!=0)
               count2++;
           click.setText(String.valueOf(count2));
        }
        if(e.getSource()==sh){
            dispose();
            search s = new search();
        }
    }
}
