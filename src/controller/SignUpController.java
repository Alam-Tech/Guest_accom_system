package controller;

import model.DbClient;
import model.UserIdManager;
import views.SignUp;

public class SignUpController {
    public boolean validate(SignUp target){
        if(target.user_name.getText().isEmpty()){
            target.user_name_error.setText("Enter a user name!");
            return false;
        }
        target.user_name_error.setText("");
        //Checking for password input:
        String pass = LoginController.get_string(target.password.getPassword()); 
        if(pass.isEmpty()){
            target.password_error.setText("Enter a password!");
            return false;
        }
        target.password_error.setText("");
        //Check for same password:
        String conf_pass = LoginController.get_string(target.conf_password.getPassword());
        if(!conf_pass.equals(pass)){
            target.conf_password_error.setText("Passwords don't match!");
            return false;
        }
        target.conf_password_error.setText("");
        //Checking if the user_name alreay exists:
        String user_name = target.user_name.getText();
        Object[] user = DbClient.get_user(user_name);
        if(user != null){
            target.user_name_error.setText("Username already exists!");
            return false;
        }
        target.user_name_error.setText("");
        return true;
    }

    /**
     * This function is to handle the sign up button
     * @param target The target window
     * @return true if user account was successfully created, false otherwise.
     */
    public boolean handle_submit(SignUp target){
        String user_name = target.user_name.getText();
        String password = LoginController.get_string(target.password.getPassword());
        int new_user_id = UserIdManager.get_user_id();

        return DbClient.add_user(new_user_id, user_name, password);
    }
}
