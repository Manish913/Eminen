//package com.eminent.utills;
//
//import com.mysql.cj.Session;
//
//import javax.mail.*;
//import javax.mail.internet.*;
//import java.net.PasswordAuthentication;
//import java.util.Properties;
//
//public class SendMailBySite {
//    public static <MimeMessage> void main(String[] args) {
//
//        String host="mail.eminent.com";
//        final String user="manishmca777@gmail.com";//change accordingly
//        final String password="Manish@#123";//change accordingly
//
//        String to="manissinha000@gmail.com";//change accordingly
//
//        //Get the session object
//        Properties props = new Properties();
//        props.put("mail.smtp.host",host);
//        props.put("mail.smtp.auth", "true");
//
//        Session session = Session.getDefaultInstance(props,
//                new javax.mail.Authenticator() {
//                    protected PasswordAuthentication getPasswordAuthentication() {
//                        return new PasswordAuthentication(user, password.toCharArray());
//                    }
//                });
//
//        //Compose the message
//        try {
//            MimeMessage message = new MimeMessage(session);
//            message.setFrom(new InternetAddress(user));
//            message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
//            message.setSubject("eminent");
//            message.setText("This is simple program of sending email using JavaMail API");
//
//            //send the message
//            Transport.send(message);
//
//            System.out.println("message sent successfully...");
//
//        } catch (MessagingException e) {e.printStackTrace();}
//    }
//}