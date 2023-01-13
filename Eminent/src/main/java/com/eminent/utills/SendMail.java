//package com.eminent.utills;
//
//import com.mysql.cj.Session;
//import com.sun.xml.internal.messaging.saaj.packaging.mime.MessagingException;
//
//import javax.mail.*;
//import javax.mail.internet.*;
//import java.util.Properties;
//
//public class SendEmail
//{
//    public static <MimeMessage> void main(String [] args){
//        String to = "manishmca777@gmail.com";//change accordingly
//        String from = "manissinha000@gmail.com";//change accordingly
//        String host = "localhost";//or IP address
//
//        //Get the session object
//        Properties properties = System.getProperties();
//        properties.setProperty("mail.smtp.host", host);
//        Session session = Session.getDefaultInstance(properties);
//
//        //compose the message
//        try{
//            MimeMessage message = new MimeMessage(session);
//            message.setFrom(new InternetAddress(from));
//            message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
//            message.setSubject("Ping");
//            message.setText("Hello, this is example of sending email  ");
//
//            // Send message
//            Transport.send(message);
//            System.out.println("message sent successfully....");
//
//        }catch (MessagingException mex) {mex.printStackTrace();}
//    }
//}
