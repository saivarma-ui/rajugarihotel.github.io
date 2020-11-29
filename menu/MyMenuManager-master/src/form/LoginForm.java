package form;

import validation.constraints.ConstraintInterface;
import validation.constraints.NotBlank;

public class LoginForm extends AbstractForm {

    private final static String username = "username";
    private final static String password = "password";
    
    public LoginForm() {
        ConstraintInterface[] cs = { new NotBlank() }; 
        constraints.put(username, cs);
        constraints.put(password, cs);
    }

    
    public String getUsername() {
        return username;
    }

    
    public String getPassword() {
        return password;
    }
}
