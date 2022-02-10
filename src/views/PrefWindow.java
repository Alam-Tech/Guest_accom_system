package views;

import javax.swing.*;
import javax.swing.JFormattedTextField.AbstractFormatter;
import java.awt.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import org.jdatepicker.impl.*;
import java.awt.event.*;

class DateLabelFormatter extends AbstractFormatter {
 
    private String datePattern = "dd-MM-yyyy";
    private SimpleDateFormat dateFormatter = new SimpleDateFormat(datePattern);
     
    @Override
    public Object stringToValue(String text) throws ParseException {
        return dateFormatter.parseObject(text);
    }
 
    @Override
    public String valueToString(Object value) throws ParseException {
        if (value != null) {
            Calendar cal = (Calendar) value;
            return dateFormatter.format(cal.getTime());
        }
         
        return "";
    }
 
}

public class PrefWindow extends JDialog{
    public JComboBox<Integer> num_people;
    public ButtonGroup house_type;
    public JLabel house_type_error,date_of_accom_error;
    public ArrayList<JCheckBox> pref_acc = new ArrayList<>();

    public PrefWindow(int user_id){
        super((Window)null);
        setModal(true);

        setTitle("Testing");
        setSize(400,400);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(null);
        Container cont = getContentPane();

        UtilDateModel model = new UtilDateModel();
        JDatePanelImpl datePanel = new JDatePanelImpl(model, new Properties());
        JDatePickerImpl datePicker = new JDatePickerImpl(datePanel,new DateLabelFormatter());
        datePicker.setBounds(20,40,200,30);
        cont.add(datePicker);

        JLabel display = new JLabel("");
        display.setBounds(20,80,200,20);
        cont.add(display);

        JButton test_btn = new JButton("Display");
        test_btn.setBounds(20,100,100,20);
        cont.add(test_btn);
        test_btn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Date date = (Date)datePicker.getModel().getValue();
                DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
                String str_date = formatter.format(date);
                display.setText(str_date);
            }
        });

        setVisible(true);
    }
}
