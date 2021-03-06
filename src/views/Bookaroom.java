package views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;
import org.jdatepicker.impl.*;

import controller.BookaroomController;
import controller.PurposeSelector.Purpose;
import model.OrderInfo;

public class Bookaroom extends JFrame implements ActionListener{
    JLabel bath,date,op,nop,nor,pref,toh,nos,date_error;
    public ButtonGroup house_type,attach_bath;
    public JComboBox<String> num_people,days;
    static JRadioButton el,n,no,s;
    public JCheckBox fridge,oven,washing_machine,ac,kitchen;
    public JCheckBox gym,main_gate,swimming_pool;
    public JDatePickerImpl datePicker;
    JButton search_btn,click;
    private int user_id;

    public Bookaroom(int user_id){
        setResizable(false);
        setBackground(new java.awt.Color(204, 204, 204));
        this.user_id = user_id;
        setTitle("Book a Room");
        house_type = new ButtonGroup();
        attach_bath = new ButtonGroup();

        nop = new JLabel("No of People:");
        nop.setFont(new Font("Tahoma", Font.PLAIN, 12));
        add(nop);
        nop.setBounds(50, 20, 80, 40);

        num_people = new JComboBox<String>(new String[] {"1", "2", "3", "4", "5", "6"});
        add(num_people);
        num_people.setBounds(140, 30, 50, 19);
        num_people.setSelectedIndex(0);


        toh = new JLabel("Type of house:");
        toh.setFont(new Font("Tahoma", Font.PLAIN, 12));
        add(toh);
        toh.setBounds(50, 60, 90, 40);

        el = new JRadioButton("Elite");
        el.setSelected(true);
        el.setActionCommand("elite");
        house_type.add(el);
        add(el);
        el.setBounds(140, 70, 60, 21);
        no = new JRadioButton("Normal");
        no.setActionCommand("normal");
        house_type.add(no);
        add(no);
        no.setBounds(210, 70, 70, 21);

        pref = new JLabel("Preferable Facilities:");
        pref.setFont(new Font("Tahoma", Font.PLAIN, 12));
        add(pref);
        pref.setBounds(50, 130, 110, 15);

        fridge = new JCheckBox("Fridge");
        add(fridge);
        fridge.setBounds(110, 160, 80, 21);

        washing_machine = new JCheckBox("Washing Machine");
        add(washing_machine);
        washing_machine.setBounds(110, 190, 150, 21);

        oven = new JCheckBox("Microwave Oven");
        getContentPane().add(oven);
        oven.setBounds(110, 220, 150, 21);

        ac = new JCheckBox("Air Conditioner");
        add(ac);
        ac.setBounds(110, 250, 140, 21);

        kitchen = new JCheckBox("Kitchen");
        add(kitchen);
        kitchen.setBounds(110, 280, 80, 21);

        date = new JLabel("Date of Accomodation:");
        date.setFont(new Font("Tahoma", Font.PLAIN, 12));
        add(date);
        date.setBounds(50, 320, 130, 15);

        UtilDateModel model = new org.jdatepicker.impl.UtilDateModel();
        JDatePanelImpl datePanel = new org.jdatepicker.impl.JDatePanelImpl(model, new Properties());
        datePicker = new JDatePickerImpl(datePanel,new DateLabelFormatter());
        datePicker.setBounds(190,320,200,30);
        add(datePicker);

        date_error = new JLabel("Choose a valid date!");
        date_error.setFont(new Font("Tahoma", Font.BOLD, 12));
        date_error.setForeground(new java.awt.Color(255, 0, 0));
        add(date_error);
        date_error.setBounds(200, 355, 210, 30);
        date_error.setVisible(false);

        nos = new JLabel("No of days of stay:");
        nos.setFont(new Font("Tahoma", Font.PLAIN, 12));
        add(nos);
        nos.setBounds(50, 390, 110, 30);

        days = new JComboBox<>(new String[] { "1", "2", "3", "4", "5", "6", "7",
                "8", "9", "10", "11", "12", "13", "14"});
        add(days);
        days.setBounds(180, 400, 50, 19);

        nor = new JLabel("No of Rooms required: ");
        nor.setFont(new Font("Tahoma", Font.PLAIN, 12));
        add(nor);
        nor.setBounds(50, 440, 150, 20);
        click = new JButton("Click");
        add(click);
        click.setBounds(220,440,80,20);

        bath = new JLabel("Do you prefer Attached Bathroom?");
        bath.setFont(new Font("Tahoma", Font.PLAIN, 12));
        add(bath);
        bath.setBounds(50, 490, 190, 20);

        s = new JRadioButton("Yes");
        s.setSelected(true);
        s.setActionCommand("yes");
        attach_bath.add(s);
        add(s);
        s.setBounds(250, 490, 50, 21);

        n = new JRadioButton("No");
        n.setActionCommand("no");
        attach_bath.add(n);
        add(n);
        n.setBounds(310, 490, 60, 21);

        op = new JLabel("Other Preferences:");
        op.setFont(new Font("Tahoma", Font.PLAIN, 12));
        add(op);
        op.setBounds(50, 540, 110, 20);

        swimming_pool = new JCheckBox("House near swimming pool");
        add(swimming_pool);
        swimming_pool.setBounds(110, 570, 180, 21);

        gym = new JCheckBox("House near gym");
        add(gym);
        gym.setBounds(110, 600, 150, 21);

        main_gate = new JCheckBox("House near main gate");
        add(main_gate);
        main_gate.setBounds(110, 630, 180, 21);

        search_btn = new JButton("Search House");
        add(search_btn);
        search_btn.setBounds(150, 690, 140, 21);

        setLayout(null);
        setSize(450,800);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setBackground(Color.WHITE);

        click.addActionListener(this);
        search_btn.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e) {
        long day = 1000 * 60 * 60 * 24;
        if(e.getSource()==click){
            int people_count = Integer.parseInt((String) num_people.getSelectedItem());
            int room_count = people_count / 2;
            if(people_count % 2 != 0) room_count += 1;
            click.setText(String.valueOf(room_count));
        }
        if(e.getSource()==search_btn){
            Date date = (Date)datePicker.getModel().getValue();
            Date sysdate = new java.util.Date();
            if(date ==null || date.compareTo(new Date(sysdate.getTime() - day))<0){
                date_error.setVisible(true);
            }else{
                date_error.setVisible(false);
                ArrayList<Object[]> result = BookaroomController.search(Bookaroom.this);
                OrderInfo order_info = BookaroomController.get_order_info(Bookaroom.this);
                ResultWindow next = new ResultWindow(Purpose.Booking,user_id,result,order_info);
            }
        }
    }
}
