/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package company.com.Email;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

/**
 *
 * @author gustavoscipiao
 */
public class EnviadorEmail {
    
    
    public static void enviarEmail() throws EmailException{
       Email email = new SimpleEmail();
email.setHostName("smtp.googlemail.com");
email.setSmtpPort(465);
email.setAuthentication("GustavoScipiao@gmail.com", "A17forte!");
email.setSSLOnConnect(true);
email.setFrom("GustavoScipiao@gmail.com");
email.setSubject("ListaVip - Convite");
email.setMsg("Voce foi convidado pelo Lista Vip, favor entrar em contato pelo número (85)92695595");
email.addTo("GustavoScipiao@gmail.com");
email.send();
      
    
        
    }
}
