package views;

import javax.swing.*;

import controller.LoginController;

import java.awt.*;
import java.awt.event.*;

public class LoginWindow extends JFrame{
    public JTextField user_name;
    public int user_id = -1;
    public JLabel user_name_error,password_error;
    public JPasswordField password;
    private LoginController controller = new LoginController();

    public LoginWindow(){
        setTitle("Login");
        setResizable(false);
        setSize(380,380);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        Container cont = getContentPane();

        JLabel title = new JLabel("User Login");
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
        
        JCheckBox view = new JCheckBox("View password");
        view.setBounds(50,200,180,20);
        view.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    password.setEchoChar((char) 0);
                } else {
                    password.setEchoChar('*');
                }
            }
        });
        cont.add(view);

        JButton login_btn = new JButton("Login");
        login_btn.setFont(new Font("San Serif",Font.BOLD,16));
        login_btn.setBounds(140,240,100,30);
        cont.add(login_btn);
        
        JLabel general_error = new JLabel("");
        general_error.setForeground(Color.RED);
        general_error.setFont(new Font("Sans Serif",Font.PLAIN,13));
        general_error.setBounds(70,260,300,15);
        cont.add(general_error);

        login_btn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                boolean is_ok = controller.validate(LoginWindow.this);
                if(is_ok){
                    String username = user_name.getText();
                    if(user_id == -1){
                        System.out.println("user_id has not been set by the LoginController!");
                    }else{
                        dispose();
                        AfterLogin result_win = new AfterLogin(username,user_id);
                    }
                }
            }
        });

        setVisible(true);
    }

    public static void main(String args[]){
        LoginWindow sample_win = new LoginWindow();
    }
}
