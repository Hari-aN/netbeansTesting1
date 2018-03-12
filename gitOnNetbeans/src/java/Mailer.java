import java.util.Properties;  
  
import javax.mail.*;  
import javax.mail.internet.InternetAddress;  
import javax.mail.internet.MimeMessage;  
  
public class Mailer {  
public static void send(String to,String subject,String msg){  
  
final String user="matremonu@gmail.com";//change accordingly  
final String pass="Monumatre@2018";  
  
//1st step) Get the session object    
Properties props = new Properties();  
props.put("mail.smtp.localhost", "mail.javatpoint.com");//change accordingly  
props.put("mail.smtp.auth", "true");  
  
Session session = Session.getInstance(props,  
 new javax.mail.Authenticator() {  
  @Override
  protected PasswordAuthentication getPasswordAuthentication() {  
   return new PasswordAuthentication(user,pass);  
   }  
});  
//2nd step)compose message  
try {  
 MimeMessage message = new MimeMessage(session);  
 message.setFrom(new InternetAddress(user));  
 message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));  
 message.setSubject(subject);  
 message.setText(msg);  
   
 //3rd step)send message  
 Transport.send(message);  
  
 System.out.println("Done");  
  
 } catch (MessagingException e) {  
    throw new RuntimeException(e);  
 }  
      
}  
}