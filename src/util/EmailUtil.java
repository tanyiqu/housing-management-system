package util;


import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

public class EmailUtil
{
    public static void sendSimple(String personal, String to, String subject, String msg) {
        //指定发送邮件信息
        String from = "1953649096@qq.com";

        // 指定发送邮件的主机为 smtp.qq.com
        String host = "smtp.qq.com";  //QQ 邮件服务器

        // 获取系统属性
        Properties properties = System.getProperties();

        // 设置邮件服务器
        properties.setProperty("mail.smtp.host", host);

        properties.put("mail.smtp.auth", "true");
        // 获取默认session对象
        Session session = Session.getDefaultInstance(properties,new Authenticator(){
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, "bwsvpzakpgdichhe"); //发件人邮件用户名、授权码
            }
        });

        try{
            // 创建默认的 MimeMessage 对象
            MimeMessage message = new MimeMessage(session);

            // Set From: 头部头字段
            try {
                message.setFrom(new InternetAddress(from,personal));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }

            // Set To: 头部头字段
            message.addRecipient(Message.RecipientType.TO,
                    new InternetAddress(to));

            // Set Subject: 头部头字段
            message.setSubject(subject);

            // 设置消息体
            message.setText(msg);

            // 发送消息
            Transport.send(message);

        }catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }


    public static void sendHtml(String personal, String to, String subject, String content) {
        //指定发送邮件信息
        String from = "1953649096@qq.com";

        // 指定发送邮件的主机为 smtp.qq.com
        String host = "smtp.qq.com";  //QQ 邮件服务器

        // 获取系统属性
        Properties properties = System.getProperties();

        // 设置邮件服务器
        properties.setProperty("mail.smtp.host", host);

        properties.put("mail.smtp.auth", "true");
        // 获取默认session对象
        Session session = Session.getDefaultInstance(properties,new Authenticator(){
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, "bwsvpzakpgdichhe"); //发件人邮件用户名、授权码
            }
        });

        try{
            // 创建默认的 MimeMessage 对象
            MimeMessage message = new MimeMessage(session);

            // Set From: 头部头字段
            try {
                message.setFrom(new InternetAddress(from,personal));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }

            // Set To: 头部头字段
            message.addRecipient(Message.RecipientType.TO,
                    new InternetAddress(to));

            // Set Subject: 头部头字段
            message.setSubject(subject);

            String t =
                    "<style type='text/css'>\n" +
                    "    h1{\n" +
                    "        text-align: center;\n" +
                    "    }\n" +
                    "</style>\n" +
                    "<body>\n" +
                    "    <h1>" + content + "</h1>\n" +
                    "</body>";

            message.setContent(t, "text/html;charset=UTF-8");

            // 发送消息
            Transport.send(message);

        }catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }

}