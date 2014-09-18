package co.za.ngwane.epms.helper;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class Authenticate extends Authenticator {
     String user;
     String pw;
     public Authenticate (String username, String password)
     {
        super();
        this.user = username;
        this.pw = password;
     }
    public PasswordAuthentication getPasswordAuthentication()
    {
       return new PasswordAuthentication(user, pw);
    }
}