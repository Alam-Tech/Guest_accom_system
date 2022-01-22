package views;

import javax.swing.*;

import controller.SignUpController;
import views.popups.CancelationPopup;

import java.awt.*;
import java.awt.event.*;

public class SignUp extends JFrame{
    public JTextField user_name;
    public JPasswordField password,conf_password;
    public JLabel user_name_error,password_error,conf_password_error;
    private SignUpController controller = new SignUpController();

    public SignUp(){
        setTitle("Sign Up!");
        setSize(380,450);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(null);
        setResizable(false);
        Container cont = getContentPane();

        JLabel title = new JLabel("New Account");
        title.setFont(new Font("Sans Serif",Font.BOLD,20));
        title.setBounds(140,20,150,30);
        cont.add(title);

        JLabel user_name_label = new JLabel("User Name");
        user_name_label.setFont(new Font("Sans Serif",Font.BOLD,15));
        user_name_label.setBounds(50,55,100,20);
        cont.add(user_name_label);

        user_name = new JTextField(25);
        user_name.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (user_name.getText().length() >= 25 ) e.consume();
            }
        });
        user_name.setBounds(50,80,250,30);
        cont.add(user_name);

        user_name_error = new JLabel("");
        user_name_error.setForeground(Color.RED);
        user_name_error.setFont(new Font("Sans Serif",Font.BOLD,12));
        user_name_error.setBounds(50,110,400,15);
        cont.add(user_name_error);
        
        JLabel password_label = new JLabel("Password");
        password_label.setFont(new Font("Sans Serif",Font.BOLD,15));
        password_label.setBounds(50,130,100,20);
        cont.add(password_label);

        // JTextField password = new JTextField(25);
        password = new JPasswordField();
        password.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (password.getPassword().toString().length() >= 25 ) e.consume();
            }
        });
        password.setBounds(50,150,250,30);
        cont.add(password);

        password_error = new JLabel("");
        password_error.setForeground(Color.RED);
        password_error.setFont(new Font("Sans Serif",Font.BOLD,12));
        password_error.setBounds(50,180,400,15);
        cont.add(password_error);

        JLabel conf_password_label = new JLabel("Confirm Password");
        conf_password_label.setFont(new Font("Sans Serif",Font.BOLD,15));
        conf_password_label.setBounds(50,200,150,20);
        cont.add(conf_password_label);

        conf_password = new JPasswordField();
        conf_password.setBounds(50,220,250,30);
        password.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (password.getPassword().toString().length() >= 25 ) e.consume();
            }
        });
        cont.add(conf_password);
        
        conf_password_error = new JLabel("");
        conf_password_error.setBounds(50,250,400,15);
        conf_password_error.setForeground(Color.RED);
        conf_password_error.setFont(new Font("Sans Serif",Font.BOLD,12));
        cont.add(conf_password_error);

        JCheckBox view = new JCheckBox("View password");
        view.setBounds(50,280,180,20);
        view.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    password.setEchoChar((char) 0);
                    conf_password.setEchoChar((char) 0);
                } else {
                    password.setEchoChar('*');
                    conf_password.setEchoChar('*');
                }
            }
        });
        cont.add(view);

        JButton sign_up_btn = new JButton("Create new account");
        sign_up_btn.setFont(new Font("San Serif",Font.BOLD,16));
        sign_up_btn.setBounds(90,320,200,30);
        sign_up_btn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                boolean is_correct = controller.validate(SignUp.this);
                if(is_correct){
                    boolean created = controller.handle_submit(SignUp.this);
                    if(created){
                        dispose();
                        CancelationPopup popup = new CancelationPopup(true, "Account created succesfully!");
                    }else{
                        CancelationPopup popup = new CancelationPopup(false, "Unable to create account!");
                    }
                }                
            }
        });
        cont.add(sign_up_btn);

        setVisible(true);
    }
    
    public static void main(String args[]){
        SignUp sample_win = new SignUp();
    }
}
