package controller;

import model.DbClient;
import model.DbInterface;
import views.LoginWindow;

public class LoginController {

    public static String get_string(char[] array){
        String result = "";
        for(char element:array) result += element;
        return result;
    }

    public boolean validate(LoginWindow target){
        String user_name = target.user_name.getText();
        if(user_name.length() == 0){
            target.user_name_error.setText("Enter a valid user name!");
            return false;
        }
        target.user_name_error.setText("");
        //Converting the password char_array into a string:
        String pass = get_string(target.password.getPassword());

        if(pass.length() == 0){
            target.password_error.setText("Enter a valid password!");
            return false;
        } 
        target.password_error.setText("");
        Object[] user_details = DbClient.get_user(user_name);
        
        if(user_details == null){
            target.user_name_error.setText("Username does not exist!");
            return false;
        }
        target.user_name_error.setText("");

        if(!pass.equals(user_details[1])){
            target.password_error.setText("Wrong password!");
            return false;
        }
        target.password_error.setText("");
        target.user_id = (Integer)user_details[0];
        DbInterface.update_tables(target.user_id);
        return true;
    }
}
